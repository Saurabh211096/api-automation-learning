# Agile Scrum Terminology

**1. Agile Scrum:** A framework where software is built and tested in small, continuous cycles rather than waiting months for one massive release.

**2. Sprint:** A strict timebox (usually 2 weeks) where the team commits to building and testing a specific set of features. When the 2 weeks end, those features must be 100% bug-free and ready for production.

**3. Backlog:** The master list of every feature, idea, and bug for the entire software. The Product Manager prioritizes this list.

**4. User Story:** A single feature pulled from the Backlog into a Sprint. It is written from the user's perspective. 
*Format:* "As a [type of user], I want [some feature] so that [some reason]."
*Example:* "As a customer, I want to search for a pet by ID so that I can view its availability."

**5. Daily Standup:** A 15-minute team meeting every morning. Every person answers 3 questions:
- What did you do yesterday?
- What are you doing today?
- Are you blocked by anything? (e.g., "I am blocked because the QA environment is down.")

**6. Retrospective:** A meeting at the very end of the Sprint. The team discusses: What went well? What failed? How do we improve in the next Sprint?

---

## Jira Basics for QA

**1. Jira Board:** A visual representation of the current Sprint. It is divided into columns, typically:
`To Do` ➔ `In Progress` ➔ `In QA / Testing` ➔ `Done`

**2. Issue Types:** Every item on the board is called an "Issue". There are 3 main types you will handle:
- **Story (Green Icon):** A new feature. (e.g., "Build the POST /pet endpoint").
- **Task (Blue Icon):** Technical work. (e.g., "Write REST Assured automation for POST /pet").
- **Bug (Red Icon):** A defect. (e.g., "BUG-001: API returns 200 instead of 201").

**3. The QA Daily Workflow:**
1. Open Jira in the morning. Look at the `To Do` column for Tasks assigned to your name.
2. Drag a Task into the `In Progress` column.
3. Open Eclipse, write your REST Assured Java code, and push it to GitHub.
4. Drag the Task into the `Done` column.
5. If you find a defect while testing a Story, click "Create", select Issue Type "Bug", paste your Bug Report Template, assign it to a developer, and drop it in the `To Do` column.