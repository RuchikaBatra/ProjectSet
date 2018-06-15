
import org.apache.spark.sql.types._
import org.apache.spark.sql.catalyst.ScalaReflection
import org.apache.spark.sql.functions._
import org.apache.spark.sql.SparkSession
case class Person(
name:String,
city:String,
country:String,
age:Option[Int]
)
//create schema for parsing data
object Person{
  val spark = SparkSession
.builder
.appName("parsingdata")
.getOrCreate()
import spark.implicits._
val caseSchema = (ScalaReflection.schemaFor[Person].dataType.asInstanceOf[StructType])
val peopleStream = (spark.readStream.schema(caseSchema).option("header",true).option("maxfilespertrigger",1).csv("data/people.*").as[Person])

(peopleStream.writeStream.outputMode("append").format("console").start)
}