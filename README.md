#AWS Queen
##A unix-ish approach to AWS
This tool aims to integrate AWS services into the traditional shell. For example Instances or regions will be folders.

Example:

```
AWS
├── frankfurt
│   ├── EC2-Instance1
│   ├── EC2-Instance2
│   └── LB1
└── ireland
    ├── DynamoDB1
    └── ElastiCache1
```

###TODO & Questions
 - Which CLI library? Apache CLI, Spring, ...?
 - Every service is a folder?
 - Functionality of a service (e.g. S3 Bucket upload)?