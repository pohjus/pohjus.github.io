# AI-Assisted Software Development

## Overview

This four-day (2 + 2) training covers the transition from traditional software development to an AI-native development model.
The training is divided into two modules:

- **Module 1: AI-Assisted Software Development in Practice** (2 days): using AI as part of daily development work.
- **Module 2: AI in Applications, as Agents, and in Production** (2 days): integrating AI into applications, building agents, and taking applications to production.

The training is hands-on. The agenda is preliminary and may change slightly depending on the needs of the participants.

## Target Audience

The training is aimed at software developers who want to integrate AI into their daily development work.

## Prerequisites

- Proficiency in at least one programming language, e.g. Python, Java, JavaScript, etc.
- Familiarity with version control and command-line environments

**No prior experience with AI tools is required.**

## Learning Objectives

By the end of the training, participants will be able to:

- Use AI as a practical daily tool in software development
- Understand the strengths of different AI coding tools and choose the right one for the situation
- Generate, test, and review code with the help of AI
- Understand how AI is integrated into applications using different integration strategies
- Know the principles of agent and MCP architecture and be able to apply them
- Take an AI-assisted prototype toward production in a controlled manner

## Required Tools and Access

The training is delivered remotely. Participants must have access to the following tools before the training begins.

### Claude

Although the training covers several AI tools (Codex, Claude, Gemini, etc.), the exercises are built around Claude. Participants need access to Claude during the training.

**Option A: Company API Keys (Recommended)**

The organizing company creates an account at console.anthropic.com, loads it with credits (pay-as-you-go), and creates API keys for participants. Participants configure Claude Code to use the provided API key instead of their own login. Usage is billed token-based from the company's credit balance, and there are no per-user hourly limits, so work continues uninterrupted as long as credits are available.

**Option B: Personal Subscription**

Each participant uses their own **Claude Pro or Team subscription** (Team is recommended due to higher usage limits). Note that Claude Pro has usage limits that reset every few hours, and intensive hands-on work may exhaust the limit mid-session.

_Company API keys ensure that exercises proceed without interruption throughout the training days, without the risk of quota-related interruptions._

### GitHub

Participants must have a GitHub account, either personal or provided by their organization. The account is used for version control in exercises and CI/CD exercises.

### Slack

Some communication during the training takes place via Slack. Participants must have access to the training Slack workspace. Login instructions will be provided before the training begins.

## Module 1: AI-Assisted Software Development in Practice - 2 days

### AI as a Developer's Tool

- What generative AI and LLMs mean in practical software development
- How models produce responses and why they make mistakes
- The changing role of the developer: from implementer to guide, evaluator, and quality assurer
- The AI-native development model
- Principles of prompting and the structure of a good prompt
- Making project context understandable to AI
- Context management in long tasks

### Current AI Coding Tools and How to Choose

- Main categories of AI tools: chat-based, IDE assistants, agentic development environments
- Example tools: Claude (Code), GitHub Copilot, Cursor, Gemini, ChatGPT/Codex-style use, IntelliJ IDEA AI
- Differences between models
- Claude Code CLI basics

### Generating Code with AI

- Differences between building new systems and AI-assisted modernization of existing code
- Greenfield: AI in design, initial implementation, interpreting specifications, and layering tests
- Brownfield: AI in understanding legacy code, refactoring, documentation, and identifying change risks
- Claude Code: plan mode, change management, debugging, feature development
- AI-assisted code review

### Specification- and Test-Driven Development with AI

- Generating tests from specifications with AI
- Tests as a driver in AI-assisted implementation
- Validating AI-generated code against acceptance criteria
- Claude: Test and Evaluate, Develop Tests, Eval Tool

## Module 2: AI in Applications, as Agents, and in Production - 2 days

### AI in Applications and Integration Strategies

- Comparing and selecting integration strategies: direct API calls, SDK-based integration, MCP-based tool connections
- Cloud vs. local models and hybrid strategies
- Installing and using a local cloud service

### Retrieval-Augmented Generation (RAG)

- RAG thinking in practice
- Using your own documentation and databases in RAG
- When to use RAG vs. direct context
- Embeddings and Files

### AI Agents and Tool Use

- Agent thinking in development
- Multi-agent model
- LLM Tool Calling
  - Claude Tools
  - OpenAI Function Calling
- MCP (Model Context Protocol)

### CI/CD and AI in the Development Pipeline

- Traditional vs. AI-assisted pipeline
- From development to production: error handling, edge cases, performance
- AI's role at every stage
  - Code generation and review
  - Automatic test writing
  - Commit messages and PR descriptions
  - Pipeline configuration maintenance

### Workshop

- Developing a participant's own idea into a prototype using AI
- Taking the prototype toward production in a controlled manner
  - Testing, documentation, architecture
- Presenting your own prototype
