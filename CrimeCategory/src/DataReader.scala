
import org.apache.spark.sql.types._
import org.apache.spark.sql._
import org.apache.spark.sql.Encoders


class DataReader {
val sp = SparkSetup.spark
import sp.implicits._

def readTrainingData(path :String) : DataFrame ={

var crimeSchema = StructType( List( 
					StructField( "Dates",StringType,true),
					StructField( "Category",StringType,true),
					StructField( "Descript",StringType,true),
					StructField( "DayOfWeek",StringType,true),
					StructField( "PdDistrict",StringType,true),
					StructField( "Resolution",StringType,true),
					StructField( "Address",StringType,true),
					StructField( "X",DoubleType,true),
					StructField( "Y",DoubleType,true)
		))
val trainDF = SparkSetup.spark.read.format("csv").option("header", "true").option("delimiter", ",").schema(crimeSchema).load(path)

trainDF
	}


def readTestData(path :String) : DataFrame ={
		
var crimetestSchema =  StructType( List( 
					StructField( "Id",StringType,true),
					StructField( "Dates",StringType,true),
					StructField( "DayOfWeek",StringType,true),
					StructField( "PdDistrict",StringType,true),
					StructField( "Address",StringType,true),
					StructField( "X",DoubleType,true),
					StructField( "Y",DoubleType,true)
		))
val testDF = SparkSetup.spark.read.format("csv").option("header", "true").option("delimiter", ",").schema(crimetestSchema).load(path)
testDF
	}

}