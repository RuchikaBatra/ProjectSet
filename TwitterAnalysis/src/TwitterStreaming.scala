import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.SparkContext._
import org.apache.spark.streaming.twitter._
import org.apache.spark.SparkConf
import org.apache.spark.streaming.twitter.TwitterUtils

object TwitterStreaming {
  def main(args:Array[String]){

 val consumerKey="afaBdl7HmpbIm53Sa6wcRdr2h"    
val consumerSecret="nVje0Vjoc8dY2LyjTUr1eGrsFw8tqpsBMFneGxVaChJXytHS2M"    
val accessToken="90580147-odxPiI67zcO23g51eZZjjmI43vCZckp4IKDXXO2YY"    
val accessTokenSecret="kze3sRc7T41vGXdDuiPLuLzjJaHkVGcfMKexfI5o3y7fG"

 val filters=Array("coffee","hadoop","spark","kafka","xbox","ps4","nintendo")
 System.setProperty("twitter4j.oauth.consumerKey", consumerKey)
 System.setProperty("twitter4j.oauth.consumerSecret",consumerSecret)
 System.setProperty("twitter4j.oauth.accessToken", accessToken)
 System.setProperty("twitter4j.oauth.accessTokenSecret",accessTokenSecret)
 val sparkConf = new SparkConf().setAppName("TwitterPopularTags").setMaster("local[2]")
 val ssc = new StreamingContext(sparkConf, Seconds(10))
 val stream = TwitterUtils.createStream(ssc, None, filters)
 val hashTags = stream.flatMap(status => status.getText.split(" ").filter(_.startsWith("#")))
 
 val topCounts60 = hashTags.map((_, 1)).reduceByKeyAndWindow(_ + _,Seconds(60))
 .map{case (topic, count) => (count, topic)}
 .transform(_.sortByKey(false))
 val topCounts10 = hashTags.map((_, 1)).reduceByKeyAndWindow(_ + _,Seconds(10)).map{case (topic, count) => (count, topic)}.transform(_.sortByKey(false))
 topCounts60.foreachRDD(rdd => {
 val topList = rdd.take(10)
 println(" Popular topics in last 60 seconds (%s total):".format(rdd.count()))
 topList.foreach{case (count, tag) => println("%s (%s tweets)".format(tag, count))}
 })
 topCounts10.foreachRDD(rdd => {val topList = rdd.take(10)
 println("\nPopular topics in last 10 seconds (%s total):".format(rdd.count()))
 topList.foreach{case (count, tag) => println("%s (%s tweets)".format(tag, count))}})
 ssc.start()
 ssc.awaitTermination()
 }

}