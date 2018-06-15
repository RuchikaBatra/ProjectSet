
import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.types._
import org.apache.spark.sql._

import org.apache.spark.mllib.classification._
import org.apache.spark.mllib.optimization._
import org.apache.spark.mllib.evaluation._
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.mllib.linalg._
import org.apache.spark.mllib.util._
import org.apache.spark.mllib.feature._
import org.apache.spark.mllib.classification.LogisticRegressionWithLBFGS

import org.apache.spark.mllib.feature.StandardScaler
import org.apache.log4j.Logger
import org.apache.log4j.Level


object CrimeCategorization {
	
	def main(args: Array[String]) {
	
		val dataReader = new DataReader()

		val train = dataReader.readTrainingData(args(0))

		val test =  dataReader.readTestData(args(1))

		train.createOrReplaceTempView("train")
		var categories = SparkSetup.spark.sql("select distinct category from train ")

		categories = categories.sort("category")

		val cat_count: Long = categories.count()

		val htf = new HashingTF(5000)

		val cat_mod = categories.rdd.map( x => (x.get(0).toString(),x.get(0).toString().length.toDouble) )

		val catMap:Map[String,Double] = cat_mod.take(cat_count.toInt).toMap
    val sp = SparkSetup.spark
		import sp.implicits._
		val trainingData = train.map( x => LabeledPoint(
															catMap.get(x(1).toString).get,
															htf.transform(List( 
																				x.get(3).toString(),
																				x.get(4).toString(),
																				x.get(0).toString().substring(11,13).toInt
																				)
																			)					
	
														)				
										)

		val model = new LogisticRegressionWithLBFGS().setNumClasses(cat_count.toInt).run(trainingData.rdd)

		val out = test.map( x => {
							val prediction = model.predict(
																htf.transform(List(
																						x.get(2).toString(),
																						x.get(3).toString(),
																						x.get(1).toString().substring(11,13).toInt
																					)
																				)
																)
						
						(x.get(0).toString(), prediction)
						}
					)
    		out.write.csv(args(2))
  	}
	
}