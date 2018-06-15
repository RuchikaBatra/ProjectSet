import org.apache.spark.sql.SparkSession

object SparkSetup {
  var spark:SparkSession = null
  def initialize:Unit = {
    spark = SparkSession
      .builder
      .appName("CrimeCategory")
      .getOrCreate()
  }
}