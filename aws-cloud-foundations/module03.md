# Module 3: AWS Global Infrastructure Overview

## Video: Overvideo

- AWS Global INfrastructure
- AWS service and service category
- Lab

## Video: AWS Global Infrastructure

- Flexible, reliable, scalable and sercure computing environment
- Globalt network performance
- Lot of AWS Regions all over the world
- AWS Region is geographical area
  - Data replication
  - Communication?
  - All data is replicated inside of region
  - Region consisto two or more Availabitility Zones.
  - AWS Management. manage regions

Selecting a Regions?

- Data governance
  - Proximity
    - Service available withing the Region
      - Costs

Availability Zones

- Each Region has multiple Availability Zones
- Availability Zoned consists of data centers
- Region ue-west-1
  - Availability zone: eu-west-1a (data centers)
  - Availability zone: eu-west-1b (data centers)
  - Availability zone: eu-west-1c (data centers)
- Availability zone is interconnected with other avalability zones
- Recommendation: Replicate data and resouces across Avalabilitys Zones
- Cloud developer chooses the region
- Design your system so that it works if disaster strikes
- Data Cetners are designed for security
- 50 000 -> 80 000 servers
- Data center has redundatn power, networking, connectivity and housed in a separate facility

CloudFront

- CDN delivers content, reduce latency
- Amazon route 53 is DNS service, request is routed to the nearest Edge location
- Points of presence are located in most of the major cities
- If client is in Finland, Region is in US, Point of Presence would be in Stockholm
- Availibility Zone: full replication
- PoP temporary cache, static files, read only, short periods
- PoP is used in CloudFront, Route 53, Shiled, Web Application Firewall services
- Regional Edge caches are used by default with Amazon CloudFront
  - Data that is not accessed enough to remain in an Edge location, directly from origin server

Benefits

- Dynamic adaption of capacity
- Scales
- Fault-tolerance
- High availability

## Video: AWS Services

- Building Blocks
- Infrastructure
  1. Regions
  2. Availability Zones
  3. Edge Locations
- Foundation Services
  1. Compute
  2. Networking
  3. Storage
- Platform Services
  1. Databases
  2. Analytics
  3. App Services
  4. Seployment
  5. Mobile
- Applications
  1. Virtual Desktops
  2. Collaborations and sharing
- 23 services or categories

Storage service category

- Amazon S3
- Amazon EBS - designed for S3
- Amazon EFS - File System (NFS)
- Amazon simple storage service glacier - Secure S3

Compute

- Amazon EC2 - Virtual machines that scale
- EC2 Auto scaling - add EC2 instances
- ESC Elastic Container Service - Docker
- ESR EC2 Container Registry - Docker Container Registry
- AWS Elastic Beanstalk - deploying and scaling web apps to prebuilt servers like apaches
- AWS Lambda - run code without servers, no charge if lambda is not running
  Amazon EKS - Elastic Kubernetes Service
  - Kubernetes: runs apps accross many servers
  - Keeps your ap always running
  - Manages these automatically
- AWS Fargate: run app in containers but you figure out servers
  - You do not need to manage servers, OS, scaling, patching
  - Fargate manages the hardware of your docker container automatically

Database

- Amazont Relational Database Service
- Amazon Aurora: fast SQL database
- Amazon Redshift: analytic?
- Amazon DynamoDB: key-value nosql database

Networking and Contend Delivery Service

- Amazon VPC: Virtual Private Cloud
  - Your own private network inside of AWS
  - Which apps are public (website), private (database), who can access each parte, what traffic is allowed in and out
- VPC: walled city
  - Subnets: neighborhoods
  - Internet gateway = city gates
  - EC2 = buildings
  - Security Group = Who's allowd in each building
  - Route Table = Your traffic GPS system

Elastic Load Balancing

- Traffic controller for you app
- Incoming requests across multiple servers

CloudFront

- Fast CDN

Transit Gateway

- Connect VPCs to a single managed gateway

Route 53

- is DNS service, request is routed to the nearest Edge location
- ip addresses to domain names

Direct Connect

- Driving your packages on your own private road straight to AWS
- You’re moving lots of data to/from AWS regularly
- Compared to internet, much faster

VPN

- Private network from your device to cloud

Security

- IAM: enables access to AWS services
- AWS Organizations lets you manage multiple AWS accounts from one central place.

Cognito

- Amazon Cognito helps you add login/signup features to your app — without building your own user system.

AWS artifact

- It gives you official documents from AWS, such as: ISO certifactes, GDPR papers, other reports

AWS Key Management Service

- AWS KMS is a service that helps you create, store, and manage encryption keys securely — so you can encrypt and decrypt data in AWS.

AWS shield

- AWS Shield is a protection service that defends your AWS apps against DDoS attacks (Distributed Denial of Service).
- DDoS: flood your server with huge amounts of fake traffic

AWS Cost amangements

- Cost and Usage Report: A detailed CSV export of all your AWS usage and costs.
- Budgets: Lets you set spending limits and get alerts when you’re close to or over budget.
- Cost explorer: A visual tool to analyze, track, and forecast your AWS spending over time.

AWS Management and Governance Service category

- **AWS Management Console**: A web-based dashboard to manage all AWS services through a graphical user interface.

- **AWS Config**: Tracks and records changes to your AWS resources and checks compliance with rules you define.

- **Amazon CloudWatch**: Monitors your AWS resources and apps in real time (CPU, logs, alarms, etc.).

- **AWS Auto Scaling**: Automatically adds or removes compute capacity based on demand to keep performance steady and costs low.

- **AWS Command Line Interface (CLI)**: A tool to control AWS services using terminal/command-line commands instead of the console.

- **AWS Trusted Advisor**: Gives real-time recommendations for cost optimization, security, fault tolerance, and performance.

- **AWS Well-Architected Tool**: Reviews your workloads against AWS best practices (security, cost, reliability, etc.).

- **AWS CloudTrail**: Records every action taken in your AWS account for security auditing and monitoring.

- **AWS Management Console**: A web-based dashboard to manage all AWS services through a graphical user interface.

- **AWS Config**: Tracks and records changes to your AWS resources and checks compliance with rules you define.

- **Amazon CloudWatch**: Monitors your AWS resources and apps in real time (CPU, logs, alarms, etc.).

- **AWS Auto Scaling**: Automatically adds or removes compute capacity based on demand to keep performance steady and costs low.

- **AWS Command Line Interface (CLI)**: A tool to control AWS services using terminal/command-line commands instead of the console.

- **AWS Trusted Advisor**: Gives real-time recommendations for cost optimization, security, fault tolerance, and performance.

- **AWS Well-Architected Tool**: Reviews your workloads against AWS best practices (security, cost, reliability, etc.).

- **AWS CloudTrail**: Records every action taken in your AWS account for security auditing and monitoring.

| Tool                          | Purpose / Use Case                              | Who Uses It                |
| ----------------------------- | ----------------------------------------------- | -------------------------- |
| **AWS Management Console**    | GUI for accessing and managing AWS services     | Beginners, general users   |
| **AWS Config**                | Tracks config changes, checks compliance        | DevOps, security teams     |
| **Amazon CloudWatch**         | Monitors performance (metrics, logs, alarms)    | Developers, ops teams      |
| **AWS Auto Scaling**          | Adjusts compute capacity based on demand        | Backend engineers, SREs    |
| **AWS CLI**                   | Command-line access to AWS services             | Power users, automation    |
| **AWS Trusted Advisor**       | Gives optimization/security recommendations     | Cost managers, architects  |
| **AWS Well-Architected Tool** | Evaluates workloads against AWS best practices  | Architects, tech leads     |
| **AWS CloudTrail**            | Logs all API activity for auditing and security | Security, compliance teams |
