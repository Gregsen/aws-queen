[![Build Status](https://travis-ci.org/Gregsen/aws-queen.svg?branch=master)](https://travis-ci.org/Gregsen/aws-queen)

#AWS Queen
##A unix-ish approach to AWS
This tool aims to integrate AWS services into the traditional shell. For example Instances or regions will be folders.

Example:

```
AWS
├── eu-west-1
│   ├── EC2-Instance1
│   ├── EC2-Instance2
│   └── LB1
└── us-west-2
    ├── DynamoDB1
    └── ElastiCache1
```
##Prerequisites
You need Java 7 for running ```awsqueen```. Additionally, you need [maven](http://maven.apache.org) for the installation.
Since the install script is running with sudo, make sure that maven is available for root.

##Installation
To install ```awsqueen``` clone via ```git clone https://github.com/Gregsen/aws-queen.git``` and run the install
script.
```
chmod +x install-aws-queen.sh
sudo  ./install-aws-queen.sh
```
That's it (well, almost). The files will be installed under /opt/awsqueen/bin, so make sure, this folder is in
your PATH.
```
PATH=$PATH:/opt/awsqueen/bin
```

###TODO & Questions
 - Which CLI library? Apache CLI, Spring, ...?
 - Every service is a folder?
 - Functionality of a service (e.g. S3 Bucket upload)?
