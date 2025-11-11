# GForms-Automation
🚀 Automated Testing Framework built using Selenium, Java, and TestNG, designed for testing web applications efficiently.
It includes reusable wrapper methods, structured TestNG test cases, and Gradle build configuration for seamless execution and reporting.

✨ Features:
Modular Wrappers class for reusable Selenium actions (click, type, select, etc.)
TestNG-based test cases with configurable testng.xml suite
Gradle integration for build automation and dependency management
Checkstyle support for maintaining code quality
Custom logging and browser management setup

🧩 Tech Stack:
Language: Java
Framework: TestNG
Automation Tool: Selenium WebDriver
Build Tool: Gradle
Browser: Google Chrome

📁 Project Structure
📦 project-root
 ┣ 📂 src
 ┃ ┣ 📂 main
 ┃ ┃ ┗ 📂 java
 ┃ ┃ ┃ ┗ 📂 demo
 ┃ ┃ ┃ ┃ ┗ 📜 App.java
 ┃ ┣ 📂 test                    -> Test Source Root Directory 
 ┃ ┃ ┣ 📂 java
 ┃ ┃ ┃ ┗ 📂 demo
 ┃ ┃ ┃ ┃ ┣ 📂 wrappers
 ┃ ┃ ┃ ┃ ┃ ┗ 📜 Wrappers.java   -> Common reusable methods (check for duplicates)
 ┃ ┃ ┃ ┃ ┗ 📜 TestCases.java    -> Test steps automated here
 ┃ ┃ ┗ 📂 resources
 ┣ 📜 .gitignore
 ┣ 📜 assessment_result.json
 ┗ 📜 build.gradle

🧪 Purpose:
This project automates Google Form submissions and demonstrates QA test automation practices including element interactions, waits, data handling, and structured test design.
