/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// scalastyle:off println
package io.rhom

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.cassandra._

import com.datastax.spark.connector.cql.CassandraConnectorConf
import com.datastax.spark.connector.rdd.ReadConf

/** Computes an approximation to pi */
object BackupLocations {
  def main(args: Array[String]) {
    val spark = SparkSession
      .builder
      .appName("BackupLocations")
      .getOrCreate()

    spark.sparkContext.hadoopConfiguration.set(
      "fs.defaultFS",
      "wasb://activityfeatures@rhomlocations.blob.core.windows.net"
    )

    spark.sparkContext.hadoopConfiguration.set(
      "fs.azure.account.key.rhomlocations.blob.core.windows.net",
      "4495ciCh1/jzDzQBeXB5CxorjJo/+azb197CGb3pl8t2koxXMGA/44G11d0PRj73ZiRURoD7y5urMHP0U3XdUQ=="
    )

    val df = spark
      .read
      .format("org.apache.spark.sql.cassandra")
      .options(Map( "table" -> "locations", "keyspace" -> "rhom"))
      .load()

    df.write
      .mode("overwrite")
      .format("com.databricks.spark.avro")
      .save("wasb://backups@rhomlocations.blob.core.windows.net/locations/test")

    //spark.stop()
  }
}
// scalastyle:on println
