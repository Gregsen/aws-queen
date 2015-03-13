#!/bin/sh

if [ "$(id -u)" != "0" ]; then
   echo "This script must be run as root" 1>&2
   exit 1
fi

mkdir -p /opt/awsqueen/lib
mkdir -p /opt/awsqueen/bin


if ! type "mvn" > /dev/null; then
  echo "your need maven 2 to run this script"
  exit 1
fi

cd ..
mvn clean package

cd scripts

cp ../awqregion/target/awqregion-0.1-SNAPSHOT.jar /opt/awsqueen/lib
cp ../awqfetch/target/awqfetch-0.1-SNAPSHOT.jar /opt/awsqueen/lib

cp awqregion.sh /opt/awsqueen/lib
cp awqfetch.sh /opt/awsqueen/lib

chmod +x /opt/awsqueen/bin/awqregion-0.1-SNAPSHOT.jar
chmod +x /opt/awsqueen/bin/awqfetch-0.1-SNAPSHOT.jar

echo "awsqueen successfully installed!"

exit 0