# Module 1 - Cloud Concepts Overview

## Introduction Video

After completing this module, you should be able to:

- Define different types of cloud computing models
- Describe six advantages of cloud computing
- Recognize the main AWS service categories and core services
- Review the AWS Cloud Adoption Framework (AWS CAF)

**Knowledge Check** after this module!

## Section 1 Video - Introduction to Cloud Computing

### Cloud Computing Defined 🧑‍💻

- **Cloud computing** means using computing resources (like servers, storage, and databases) over the internet.
- It is **on-demand**, so you get what you need when you need it—no need to buy hardware upfront.
- It includes:
  - Compute power (e.g., virtual machines)
  - Databases
  - Storage
  - Applications
  - Other IT services
- It is delivered **via the internet**, not locally.
- Uses **pay-as-you-go** pricing, meaning you only pay for what you actually use—like electricity or water.
- **Simply put: you build the app, AWS runs it in the cloud using their services.**

### Cloud Service Models 🧑‍💻

- **IaaS (Infrastructure as a Service)**

  - You get basic building blocks: servers, storage, and networking.
  - You manage the OS and applications.
  - AWS example: Amazon EC2
  - Best for: full control and flexibility over infrastructure

- **PaaS (Platform as a Service)**

  - You get a platform to build and deploy applications.
  - AWS manages the hardware, OS, and runtime — you just write the code.
  - Or with services like **Heroku**, **Railway**, or **Render**, you don’t deal with infrastructure at all.
  - AWS example: AWS Elastic Beanstalk
  - Best for: developers who want to focus on app logic without managing infrastructure

- **SaaS (Software as a Service)**

  - Software delivered over the internet — no need to install or maintain it locally.
  - Usually accessed via a **web browser**, but can also be a desktop or mobile app.
  - The **service provider manages everything**: infrastructure, updates, backups, and security.
  - You just **log in and use the app** — like renting software.
  - To build and run a SaaS app, you still need:
    - **IaaS** to provide servers, networking, storage, etc. OR:
    - **PaaS** to simplify development, deployment, and scaling

- **Examples of SaaS:**

  - Web apps: Google Docs, Dropbox, Figma
  - Desktop clients (still SaaS): Zoom, Slack

- Example
  - IaaS: Land, Pipes, Electricity (Infrastructure)
  - PaaS: The construction company and tools (PLatform)
  - SaaS: The finsihed house you move into and live in (app)

In Short

- SaaS (app)
  - Runs on top of PaaS (platform)
    - Built on → IaaS (infrastructure)
- When you create an app, you can deploy it directly to
  - PaaS (that uses IaaS under the hood)
  - IaaS (where you manage everything)

### Deployment Models 🧑‍💻

#### Cloud

- Everything runs on the internet using a cloud provider like AWS.
- No physical servers on your own site.
- You access resources (compute, storage, etc.) as needed.
- Example: Hosting a website entirely on AWS (EC2, S3, RDS).
- Best for: speed, scalability, low upfront costs

#### Hybrid

- A mix of on-premises (your own servers) and cloud services.
- Some workloads run locally, others in the cloud.
- Often used during cloud migration or to meet special security/compliance needs.
- Example: A hospital keeps patient data on its own servers (on-prem), but uses AWS for analytics.
- Best for: flexibility, gradual cloud adoption

#### On-premises (Private Cloud)

- Everything runs in your own data center.
- You fully own, manage, and maintain the hardware and software.
- Can still use cloud-like technologies (e.g., virtualization, Kubernetes), but it's not public cloud.
- Example: A bank runs its own private data center for all services.
- Best for: maximum control, strict compliance or legacy systems

### Summary Table

| Model       | Runs Where?      | Managed By     | Best For                        |
| ----------- | ---------------- | -------------- | ------------------------------- |
| Cloud       | Public cloud     | Cloud provider | Fast, cost-efficient scaling    |
| Hybrid      | Both             | Shared         | Flexibility & gradual migration |
| On-premises | Your data center | Your IT team   | Full control & data residency   |

## Section 2 Video - Advantages of the Cloud

- Benefits?
  1. Trade Capital Expense for Variable Expense - pay only the amount of what you consume
  2. Massive Economies of Scale: Because AWS operates on a global level and serves millions of customers, it can afford to pass on lower costs to its users.
  3. Stop guessing capacity - you will get the capacity based on your need
  4. Increase speed and agility - you will get more resources based on your need
  5. Stop spending money on data centers - AWS has everything build up for you
  6. Go global in minutes: your app can run in different region, smaller latency

## Section 3 - Introduction to AWS

- AWS contains a LOT of services
- Select your service under category
- Services depend what kind of app you are building
- Services in this course

  - **Compute** – Run applications and servers (like Amazon EC2). Think of it as your virtual computer in the cloud.
  - **Storage** – Save files, backups, and data securely (like Amazon S3).
  - **Database** – Store and manage structured data (like Amazon RDS or DynamoDB).
  - **Networking** – Connect apps and users across the internet or private networks.
  - **Content Delivery** – Speed up loading times by delivering content closer to users (like CloudFront).
  - **Security, Identity, and Compliance** – Keep your cloud environment safe and ensure only the right people have access (like IAM).
  - **Management and Governance** – Monitor and control your resources efficiently (using tools like CloudWatch or AWS Config).
  - **Cost Management** – Understand and control how much you're spending in the cloud.

- How to use AWS
  - AWS Management Console, GUI in Web
  - AWS CLI, Command Line Interface
  - SDK, via programming language, like Java, Python and others

## Section 4 - Moving to the AWS Cloud

- The AWS Cloud Adoption Framework (CAF) helps organizations move to the cloud in a smart and structured way. It’s like a **cloud roadmap** that covers both technology and people.
- **What it does:** Guides organizations through cloud adoption by identifying what needs to change — not just technology, but also processes, people, and mindset.
- **6 Areas of Focus (aka "Perspectives"):**

  1. **Business** – Align cloud goals with business goals.
  2. **People** – Prepare staff for new cloud roles and skills.
  3. **Governance** – Set up rules and policies to manage cloud use.
  4. **Platform** – Build the tech foundation (networks, compute, storage).
  5. **Security** – Keep data safe and manage risks.
  6. **Operations** – Monitor and manage cloud environments daily.

- **Why it matters:** It helps avoid chaos — cloud is more than just moving servers; it’s about doing it **strategically** and **safely**.

- **For beginners:** It’s not something you have to _implement_, but it's helpful to **understand the big picture** of how companies successfully use the cloud.
