Tricentis Test Automation


- Overview

This repository contains an automated test suite for the Tricentis website, 
built using Java Selenium and TestNG. 
The test suite verifies the normal working flow of the application.


- Project Structure

tricentis_test/
│-- src/
    ├── main/
│   ├── test/
│       ├── java/tricentis_dev (Test scripts)
│       ├── resources/ (Configuration and test data)
│-- pom.xml (Maven dependencies and build settings)
│-- testng.xml (TestNG configuration file)
│-- index.html (Test execution report)
│-- testng-results.xml (TestNG test result summary)
│-- README.md (Project documentation)
│-- .gitignore (Excludes unnecessary files)


- Prerequisites

Ensure you have the following installed:
Java JDK 8+
Maven Repositories
Selenium WebDriver
TestNG Plugin (for IDE like Eclipse/IntelliJ)


- Reporting

index.html: Detailed HTML report generated after execution.
testng-results.xml: XML-based report with test execution summary.
