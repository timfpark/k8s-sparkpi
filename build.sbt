name := "rhom-backup-locations"
scalaVersion := "2.11.7"
scalacOptions ++= Seq(
  "-target:jvm-1.8",
  "-unchecked",
  "-deprecation",
  "-feature"
)

val sparkVersion = "2.3.0"
parallelExecution in Test := false

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion % "provided",
  "org.apache.spark" %% "spark-sql" % sparkVersion % "provided",
  "org.apache.spark" %% "spark-streaming" % sparkVersion % "provided",
  "org.apache.spark" %% "spark-catalyst" % sparkVersion % "provided",
  "com.databricks" %% "spark-avro" % "4.0.0" % "provided",
  "com.datastax.spark" %% "spark-cassandra-connector" % "2.0.7" % "provided",
  "com.microsoft.azure" % "azure-storage" % "3.1.0" % "provided",
  "org.apache.hadoop" % "hadoop-azure" % "2.7.2" % "provided",
)
