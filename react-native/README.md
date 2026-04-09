# NN00GC31-3005 Introduction to Mobile Development: React Native

This course introduces cross-platform mobile development using React
Native and Expo. You will learn how to build native-feeling mobile
applications for Android and iOS using JavaScript and React.

The course consists of ten (10) mini projects with handwritten video
notes. Each mini project builds on the previous one, and the workload
is designed for a five (5) credit course.

## Prerequisites

- Good understanding of JavaScript fundamentals
- Good understanding of React fundamentals: components, props, state,
  hooks
- Basic command line usage is beneficial
- Experience with VS Code or another code editor is expected

## Agenda

### Time Usage

- Course is five (5) credits, where one (1) credit is about 27h of
  work
- Total estimated workload: 5 x 27h = 135h
- The estimate assumes you complete all assignments, watch the videos,
  write the notes, check your own features, and record the screencasts
- You can pass the course by doing only part of the assignments, but
  the whole course is planned as a 135-hour workload

| Topics | Assignment | Points | Videos + notes | Reading + self-check | Mini project | Total |
|---|---:|---:|---:|---:|---:|---:|
| Intro, Expo, core components, state | [Assignment 01](assignment01/README.md) | 14 | ~1h | ~1h | ~8h | **~10h** |
| Styling, Flexbox, reusable UI | [Assignment 02](assignment02/README.md) | 13 | ~1.5h | ~1.5h | ~8h | **~11h** |
| Forms, controlled inputs, validation | [Assignment 03](assignment03/README.md) | 13 | ~1.5h | ~1.5h | ~8h | **~11h** |
| FlatList, item actions, search, filtering | [Assignment 04](assignment04/README.md) | 15 | ~1.5h | ~1.5h | ~9h | **~12h** |
| Navigation, multi-screen apps, route params | [Assignment 05](assignment05/README.md) | 16 | ~1h | ~2h | ~10h | **~13h** |
| Images, media picking, ScrollView, polished UI | [Assignment 06](assignment06/README.md) | 13 | ~1.5h | ~1.5h | ~10h | **~13h** |
| Data fetching, search, loading, errors | [Assignment 07](assignment07/README.md) | 16 | ~1.5h | ~2h | ~10.5h | **~14h** |
| Persistence, context, theming, accessibility | [Assignment 08](assignment08/README.md) | 17 | ~1.5h | ~2h | ~10.5h | **~14h** |
| Device features, permissions, location, media | [Assignment 09](assignment09/README.md) | 18 | ~1.5h | ~2.5h | ~12h | **~16h** |
| Final project | [Assignment 10](assignment10/README.md) | 25 | ~1h | ~3h | ~17h | **~21h** |
| **Total** |  | **160** | **~13.5h** | **~18.5h** | **~103h** | **~135h** |

## Course Requirements

1. Pass the exam in exam.tuni.fi (multiple choice).
2. Watch videos and submit handwritten notes (minimum 70%).
3. Complete mini projects (minimum 50% of project points).

### How Points Work

- Each assignment page contains a feature checklist with points
- Students calculate their own points by checking completed features
- There are no automated tests in this course
- Only completed features should be counted
- Screencast, screenshots, and source code should support the claimed
  points

### Handwritten Video Notes

- Each assignment includes links to short YouTube videos
- Write handwritten notes about the videos on pen and paper
- Submit the notes as PDFs
- File format: `notes/video01.pdf`, `notes/video02.pdf`, etc.
- Numbering restarts at `video01.pdf` within each assignment folder
- Keep the notes inside the assignment folder in a `notes/` subfolder
- Language: Finnish or English
- Incorrect filenames may result in rejection

### Assignment Submission

Do not upload zip files. Submit your work through GitHub.

- Create one GitHub repository for the whole course
- Keep each assignment in its own folder:
  `assignment01/`, `assignment02/`, ..., `assignment10/`
- Share the repository with GitHub user `pohjus`
- If your repository is private, add `pohjus` as a collaborator
- The latest pushed version in the shared repository is the submitted
  version

### Repository README

You must create and maintain a `README.md` at the root of your
repository. This file must contain a summary of completed assignments
and the points you have calculated for each one. Update this file
after completing each assignment.

Use the following template:

```markdown
# React Native Course

| Assignment | Points |
|---|---:|
| Assignment 01 | /14 |
| Assignment 02 | /13 |
| Assignment 03 | /13 |
| Assignment 04 | /15 |
| Assignment 05 | /16 |
| Assignment 06 | /13 |
| Assignment 07 | /16 |
| Assignment 08 | /17 |
| Assignment 09 | /18 |
| Assignment 10 | /25 |
| **Total** | **/160** |
```

### What Each Assignment Folder Must Include

- source code
- `package.json`
- assets used in the app
- handwritten note PDFs inside `notes/`
- `README.md` with:
  - short description of the app
  - 1-3 screenshots
  - short screencast link demonstrating the solution

#### Screencast Requirement

Each mini project must include a short screencast.

- Recommended length: 2-5 minutes
- Show the app running and demonstrate the required features
- Put the screencast link in the assignment `README.md`
- Recommended: use an unlisted YouTube video link

#### Example Repository Structure

```text
studentnumber-react-native-course/
  assignment01/
    app/
      index.tsx
    package.json
    assets/
      profile.jpg
    notes/
      video01.pdf
    README.md
  assignment02/
    README.md
  assignment03/
    README.md
```

#### Common Mistakes

- Do not include `node_modules/` in the repository
- Do not include build output or cache folders such as `.expo/`
- Do not forget `package.json`
- Do not submit only screenshots without source code
- Do not forget handwritten notes
- Do not forget the screencast link in the assignment `README.md`
- Do not forget to share the repository with `pohjus`

## Assignments

- [Assignment 01](assignment01/README.md)
- [Assignment 02](assignment02/README.md)
- [Assignment 03](assignment03/README.md)
- [Assignment 04](assignment04/README.md)
- [Assignment 05](assignment05/README.md)
- [Assignment 06](assignment06/README.md)
- [Assignment 07](assignment07/README.md)
- [Assignment 08](assignment08/README.md)
- [Assignment 09](assignment09/README.md)
- [Assignment 10](assignment10/README.md)

## Running Assignments

Each project must run locally with Expo.

### Step-by-step

1. Open a terminal in the project folder.
2. Install dependencies:

   ```bash
   npm install
   ```

3. Start the development server:

   ```bash
   npx expo start
   ```

4. Run the app on:
   - Expo Go on a physical device, or
   - Android emulator, or
   - iOS simulator (macOS only)
5. Verify that:
   - the app starts without errors
   - the required features work
   - the UI is usable on a phone-sized screen
   - the feature checklist in the assignment page matches the actual app

## Grading

The course grade is determined by a compulsory multiple choice exam in
exam.tuni.fi.

To pass the course, you must return at least 70% of the handwritten
video notes and complete at least 50% of the assignment points.

### Exam Scoring

The maximum raw score is 24 points.

| Grade | Minimum raw score | % of max (24 pts) |
|---:|---:|---:|
| 1 | 9.6 pts | 40% |
| 2 | 14.4 pts | 60% |
| 3 | 16.8 pts | 70% |
| 4 | 19.2 pts | 80% |
| 5 | 21.6 pts | 90% |

Bonus points do **not** affect exam pass/fail status. You must first
achieve at least **9.6 raw points** to pass; bonus points are added
after this threshold is met.

### Assignment Bonus Points

You can earn additional points added to the exam grade by completing
assignments.

| Assignments completed | Additional points |
|---:|---:|
| 0-19% | +0 |
| 20-39% | +0.5 |
| 40-59% | +1 |
| 60-79% | +1.5 |
| 80-100% | +2 |

The final grade is the exam grade plus additional points, capped at 5.

## Tools

### Installing Node.js

Install the current LTS version of Node.js from
[nodejs.org](https://nodejs.org/).

#### Verify Installation

```bash
node --version
npm --version
```

### Installing Expo

You do not need a global Expo installation. Use:

```bash
npx create-expo-app@latest
```

### Recommended Editors

- **VS Code**
- **Zed**
- **WebStorm**
- **IntelliJ IDEA**
- **Cursor** only if AI features are fully disabled

Any plain text editor will work.

### Recommended Devices

- Android phone with Expo Go
- Android emulator
- iPhone with Expo Go
- iOS simulator on macOS

## Disabling AI Features

Many modern editors include built-in AI assistants or AI-powered code
completion. You must disable all AI-powered code suggestions and
completions before working on assignments.

- VS Code: disable or uninstall GitHub Copilot and similar extensions
- Cursor: disable all AI chat, inline suggestions, and agent features
- Zed: disable assistant and inline AI completions
- JetBrains IDEs: disable AI Assistant and related plugins

## AI Policy

It is strictly forbidden to use AI tools to complete assignments
directly.

### Allowed Uses

- Explaining concepts
- Requesting simple study examples
- Clarifying theory and terminology
- Asking for help understanding error messages without asking for a
  direct solution

### Prohibited Uses

- Asking AI to complete or solve mini projects
- Copying AI-generated code into submissions
