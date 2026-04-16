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

| Theme | Content |
| -------------------------------------------------- | ------------------------------------------------------------------------------------------------- |
| **AI as a Developer's Working Tool** | What generative AI and LLMs mean in practical software development. How models produce answers, why they make mistakes, and where they are useful. The developer's role shifts from implementer to director, evaluator, and quality assurer. Includes an AI-native development model: requirement -> context -> generation -> validation -> iteration. |
| **AI Tools, Models, and Selection Criteria** | Main categories of AI tools: chat-based tools, IDE assistants, and agent-style development environments. Examples include Claude, ChatGPT/Codex-style use, GitHub Copilot, Cursor, and IntelliJ IDEA AI features. Practical differences between models: analysis vs. fast generation, long context vs. lightweight editor assistance, cloud service vs. local model. How to choose the right tool and model for the right task. |
| **Prompting and Context Management** | Structure of a good prompt: role, objective, context, constraints, acceptance criteria, and desired output format. Common mistakes: vague requests, missing context, too much in one task, and lack of validation. Building project context for AI: describing the codebase, architecture, interfaces, and business rules so AI can work more reliably. |
| **AI-Assisted Development in Greenfield and Brownfield Environments** | The difference between building a new system and modernizing an existing one. In greenfield work, AI supports planning, initial implementation, interpretation of specifications, and test scaffolding. In brownfield work, AI supports legacy-code understanding, refactoring, documentation, and change-risk identification. Making the codebase documented in an AI-navigable way. |
| **Spec-Driven and Test-Driven Development with AI** | The difference between a prototype and a production solution. Spec-driven development: requirement -> technical description -> implementation -> tests -> review. Test-driven work with AI: generating tests from specifications, using tests as guardrails during AI-assisted implementation, and validating AI-generated code against acceptance criteria. |
| **Systematic AI-Assisted Code Review and Production Hardening** | Systematic code review with AI support: reviewing pull requests, identifying bugs, security issues, and design problems. How to critically assess AI-generated code instead of accepting it as-is. Debugging with AI assistance. Moving from working code to production-ready code: error handling, edge cases, performance, and documentation. |

## Training 2: Building AI Solutions and Agent-Based Development (2 days)

| Theme | Content |
| -------------------------------------------------- | ------------------------------------------------------------------------------------------------- |
| **AI in Applications and Integrations** | How AI is integrated into real applications and development processes. Using AI interfaces from an application, request/response thinking, the place of an AI component in system architecture, and integration with backend systems and external services. Roles of Java and Python: Java for production integrations, Python for rapid prototyping and agent logic. |
| **AI Tool Use and Workflows** | Using AI to drive tools: function calls, APIs, databases, files, and other external actions. A multi-step workflow where the model does not just answer but uses tools and returns a structured result. Chaining tools and managing workflows in practice. |
| **Retrieval-Based AI Solutions** | Practical RAG thinking: how AI can use an organization's or project's own knowledge. Using documentation, guides, and technical descriptions in answers. When retrieval is needed, when direct context is enough, and when both should be combined. |
| **Integration Strategies, Model Choices, and Implementation Options** | Comparing and selecting integration strategies: direct API calls, SDK-based integration, MCP-based tool connectivity, and embedded model pipelines. Cloud services, local models, and hybrid strategies. What it means to use your own LLM solution or a local model, when that is justified, and what limitations come with it. Choosing a model by task: fast assistant, long-context analyzer, coding assistant, or local implementation. How to match the integration approach to the use case. |
| **Reliability, Security, and Moving to Production** | Managing AI in production environments: validation, guardrails, auditing, secure interfaces, handling failure cases, and reducing the impact of hallucinations. How to move from a prototype toward production readiness in a controlled way. |
| **Agent-Based Operating Models** | Agent thinking in development: plan -> act -> evaluate. From simple helpers to task-specific specialized agents. Light multi-agent thinking: planner, implementer, tester, and reviewer as separate roles. Agent collaboration in development automation. Scaling team practices with agents: shared agent configurations, CI/CD-integrated agents, team-wide prompting standards, and governance of agent outputs across a team. How agents change team-level workflows and reduce coordination overhead. |
| **Applied Workshop: From Idea to Prototype and Toward Production** | The capstone practical section of the training. Turn an idea into a specification, build a working prototype with AI, then harden it toward production by adding tests, error handling, and security checks. Create architecture documentation and a testing approach with AI assistance. Finally, present the solution with rationale for the design choices and articulate the AI-assisted development competencies gained during the training. |
