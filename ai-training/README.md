# AI-Assisted Software Development

## Trainer

- Jussi Pohjolainen
- Pohjolainen Consulting Oy
- `jussi@pohjolainenconsulting.fi`
- `040-718 4338`

## Overview

This four-day (2 + 2) training covers the transition from traditional software development to an AI-native development model.
Participants learn how to use AI throughout the entire development process.

## Target Audience

This training is designed for software developers who want to integrate AI into their daily development workflow.

## Prerequisites

Participants should have **working experience in at least one programming language** (such as Java, Python, or JavaScript) and be comfortable with **version control**, **command-line tools**, and basic software development practices.

**No prior experience with AI tools is required.**

## Required Tooling: Claude Access

Although most of the AI tools are covered, like Codex, Claude, Gemini etc, the hands-on exercises are built on top of Claude.
There are two options for providing Claude access to participants:

**Option A: Company-Provided API Keys (Recommended)**

The organizing company creates an account at `console.anthropic.com`, loads it with credits (pay-as-you-go), and generates API keys for participants.
Each participant configures Claude Code to use the provided API key instead of a personal login.
Usage is billed per token against the company's credit balance with no per-user hourly caps, so participants can work continuously as long as credits remain.

**Option B: Personal Subscription**

Each participant uses their own **Claude Pro or Team subscription** (Team preferred for higher usage limits).
Note that Claude Pro has usage caps that reset every few hours, and intensive hands-on work, especially with Opus, can exhaust the allowance mid-session, leaving the participant unable to continue until the limit resets.

## Training 1: AI-Assisted Software Development in Practice (2 days)

### Day 1

**AI as a Developer's Working Tool**

- What generative AI and LLMs mean in practical software development
- How models produce answers and why they make mistakes
- Developer's role shifts from implementer to director, evaluator, and quality assurer
- AI-native development model: requirement -> context -> generation -> validation -> iteration

**AI Tools, Models, and Selection Criteria**

- Chat-based tools, IDE assistants, and agent-style development environments
- Examples: Claude, ChatGPT/Codex, GitHub Copilot, Cursor, IntelliJ IDEA AI
- Analysis vs. fast generation, long context vs. lightweight editor assistance, cloud vs. local
- Choosing the right tool and model for the task

**Prompting and Context Management**

- Structure of a good prompt: role, objective, context, constraints, acceptance criteria, output format
- Common mistakes: vague requests, missing context, oversized tasks, lack of validation
- Building project context: codebase, architecture, interfaces, and business rules

### Day 2

**Greenfield and Brownfield Environments**

- Building a new system vs. modernizing an existing one
- Greenfield: planning, initial implementation, specification interpretation, test scaffolding
- Brownfield: legacy-code understanding, refactoring, documentation, change-risk identification
- Making the codebase AI-navigable

**Spec-Driven and Test-Driven Development with AI**

- Prototype vs. production solution
- Spec-driven flow: requirement -> technical description -> implementation -> tests -> review
- Generating tests from specifications
- Using tests as guardrails and validating AI-generated code against acceptance criteria

**Code Review and Production Hardening**

- Systematic code review with AI: pull requests, bugs, security, design problems
- Critically assessing AI-generated code instead of accepting it as-is
- Debugging with AI assistance
- From working code to production-ready: error handling, edge cases, performance, documentation

## Training 2: Building AI Solutions and Agent-Based Development (2 days)

### Day 1

**AI in Applications and Integrations**

- Integrating AI into real applications and development processes
- Request/response thinking and placement of AI components in system architecture
- Integration with backend systems and external services
- Roles of Java (production integrations) and Python (prototyping, agent logic)

**AI Tool Use and Workflows**

- Driving tools with AI: function calls, APIs, databases, files, external actions
- Multi-step workflows where the model uses tools and returns structured results
- Chaining tools and managing workflows in practice

**Retrieval-Based AI Solutions**

- Practical RAG thinking with organizational or project knowledge
- Using documentation, guides, and technical descriptions in answers
- When to use retrieval, direct context, or both

**Integration Strategies and Model Choices**

- Direct API calls, SDK integration, MCP-based tool connectivity, embedded model pipelines
- Cloud services, local models, and hybrid strategies
- When a local or self-hosted LLM is justified and its limitations
- Matching model and integration approach to the use case

### Day 2

**Reliability, Security, and Moving to Production**

- Validation, guardrails, and auditing in production environments
- Secure interfaces and handling failure cases
- Reducing the impact of hallucinations
- Controlled path from prototype to production readiness

**Agent-Based Operating Models**

- Agent thinking: plan -> act -> evaluate
- From simple helpers to task-specific specialized agents
- Multi-agent roles: planner, implementer, tester, reviewer
- Shared agent configurations, CI/CD-integrated agents, team-wide prompting standards and governance

**Applied Workshop: Idea to Prototype to Production**

- Turn an idea into a specification and build a working prototype with AI
- Harden toward production with tests, error handling, and security checks
- Create architecture documentation and a testing approach with AI assistance
- Present the solution with rationale for design choices
