FROM timfpark/spark:20180305

COPY core-site.xml /opt/spark/conf

RUN mkdir -p /opt/spark/jars
COPY target/scala-2.11/rhom-backup-locations_2.11-0.1.0-SNAPSHOT.jar /opt/spark/jars
