FROM timfpark/spark:20180301

RUN mkdir -p /opt/spark/jars

COPY target/scala-2.11/k8s-sparkpi_2.11-0.1.0-SNAPSHOT.jar /opt/spark/jars
