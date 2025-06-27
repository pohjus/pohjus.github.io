# Cloud Economics and Billing

## Section 1 Video - Fundamentals of Pricing

Three fundamental drivers of cost

1. Compute - charged by time
2. Storage - charged by size
3. Data Transfer - charged per gb

- Deployment is free
- Interaction between service free, if in the same region
- Pay what you use
- The more users AWS have, the less you may pay
- Volume-based discounts
  - If usage increase, you may save
  - The more you use storage, the less you pay per GB
- Custom pricing available for large apps
- AWS free tier, Free 1 year for new customers
- No charge
  - VPC, Beanstalk, Auto Scaling, Cloudformation, IAM

## Section 2 Video - Total Cost of Ownership

- Traditional, on premises, your own hardware (facilities, maintancene stuff, scaling down does not decrease cost)
- AWS cloud: scale up and down, self-service infrastructure

### TCO

- Financial estimate to help identify direct and indirect costs of a system
- Why use TCO? compare costs
  - 1. Server costs, 2. Storage, 3. Network, 4. IT Labor
- Cloud providers give you easy understandable pricing, easy to predict.
- On premises, difficult to know what is TCO.

### AWS Pricing Calculator

- Estimate monthly costs
- Identify how to save

### Hard Benefits (Direct savings and efficiency)

- Spend less money on things like servers, storage, network, and security.
- Avoid buying hardware and software (like big servers or expensive licenses).
- Lower daily costs like backup systems or disaster recovery setups.
- Need fewer IT people to manage infrastructure.

Think of this as saving money and needing less stuff or staff.

### Soft Benefits (More flexibility and innovation)

These are about improving how your team and business operate:

- Reuse the same services again and again to build or change solutions quickly.
- Developers work faster and get more done.
- Customers are happier because services run better and faster.
- Business reacts faster to new opportunities (e.g. launch new products quickly).
- Reach more users globally, since cloud services can run in many regions.

Think of this as working smarter, faster, and reaching more people.

## Section 2 Case Study

- A lot of money saved when company moved from traditional to cloud services. 😀

## Section 3 Video - AWS Organizations

- **Consolidated Billing** in AWS means that **multiple AWS accounts** (like your company’s departments or teams) can be grouped together to get **one single monthly bill** — instead of each account getting billed separately.

### Why?

- Imagine your company has 3 departments: **Marketing**, **Development**, and **Research**.
- Each has its own AWS account, but with **Consolidated Billing**, all charges go to the **main (payer) account**.
- Everyone still uses AWS separately, but **only one bill** is paid.

| Benefit              | Explanation                                                            |
| -------------------- | ---------------------------------------------------------------------- |
| **One Bill**         | You get a single, easy-to-read invoice for all linked accounts         |
| **Volume Discounts** | AWS gives discounts when usage increases — combined accounts save more |
| **Cost Tracking**    | You can still **see costs for each account** separately                |
| **Free to Use**      | There’s no extra cost for using consolidated billing                   |

- There is **one “payer” account** that receives the bill.
- Other accounts are called **“linked” accounts**.
- Linked accounts can’t see or manage each other — **they're isolated**, just share billing.

> A university has 5 departments using AWS.
> Each department has its own AWS account.
> With Consolidated Billing, IT gets **one invoice** at the end of the month, and can **break down costs** per department.

- Multiple accounts into an organizational team, where you have teams
- Organiztion has a root, AWS accounts and policies
- AWS account is organized into organizational units, or OUs
- OU is branch of accounts
- Branch can have only one parent
- Account can be a member of one branch
- IAM policy enable you to allow or deny access to AWS services for users, groups and roles.

### Organizations setup

1. Create organization
2. Creat organizational units
3. Create service contorl policies
4. Test restrictions

### Management

- AWS Console
- AWS CLI
- SDK
- HTTPS API

## Section 4 Video - AWS Billing

- What is your cost in the future?
- Analyze your data
- AWS Cost and Usage Tool, Data trends
- AWS Billing Dashboard, GUI for how costs are trending
- Spend Summary, how much money went last month
- Tools
  - AWS Budgets
  - AWS Cost and Usage Report
  - AWS Cost Explorer

## Console Demonstration - Billing Dashboard

- Just a demo of billing report in AWS management console

## Section 5 Video - Technical Support Models

- Support is for

  - Experimenting
  - Production use
  - Business-critical use

- Proactive guidance: Techincal Account Manager (TAM), Enerprise support plan
- Best practices: AWS Trusted Advisor
- Account assistance: AWS Support Concierge

Support plans

- Basic support (FREE)
- Developer support, includes Basic support and development support
- Business support: Support Center and Trusted Advisor
- Enterprise support: Support Center and Trusted Advisor, Techincal account manager

- Better response types depending on support plans.
