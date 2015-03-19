#!/bin/bash
set -e

sudo -s <<EOF
if [ ! -d /opt/awsqueen/lib ]; then
	mkdir -p /opt/awsqueen/lib
fi

if [ ! -d /opt/awsqueen/bin ]; then
	mkdir -p /opt/awsqueen/bin
fi
EOF

if [[ ! $(type "mvn") > /dev/null ]]; then
  echo "your need maven to run this script\n"
  echo "make sure root has access to mvn, too"
  exit 1
fi


mvn clean package

sudo -s <<EOF
cp awqregion/target/awqregion-0.1-SNAPSHOT.jar /opt/awsqueen/lib
cp awqfetch/target/awqfetch-0.1-SNAPSHOT.jar /opt/awsqueen/lib

# shell expansion. I have no fucking clue what I'm doing
for file in scripts/*.sh; do
	filename=${file##*/} # WUT?! oO
	cp "$file" /opt/awsqueen/bin/"${filename%.sh}"; # mhm...yes...of course
done

chmod +x /opt/awsqueen/bin/*
EOF

echo "awsqueen successfully installed!"

exit 0
