Selenium TestNG Automation – OrangeHRM & Shaadi.com

📌 Project Overview

This project demonstrates Selenium WebDriver automation using TestNG framework with:

Data-Driven Testing (@DataProvider)

Parameterization from testng.xml (@Parameters)

Cross-browser-ready setup

Reusable test data for Login & Registration

The project covers:

OrangeHRM Login Automation – validates login and logout with multiple credentials.

Shaadi.com Registration Automation – simulates registration workflow with multiple user datasets.


🛠️ Tools & Technologies

Programming Language: Java

Automation Tool: Selenium WebDriver

Testing Framework: TestNG

Build Tool: Maven

Browser: Chrome

IDE: Eclipse / IntelliJ IDEA


📂 Project Structure
src/test/java/com/gqt/testngtestcases
│
├── OrhmLoginDatas.java        # DataProvider for OrangeHRM login credentials
├── OrhmLoginTest.java         # TestNG test class for OrangeHRM login
│
├── ShadiRegisterDatas.java    # DataProvider for Shaadi registration test data
├── ShadiRegisterTestNg.java   # TestNG test class for Shaadi registration
│
└── testng.xml                 # Central TestNG configuration (parameters, suite)


⚙️ Key Features
✅ OrangeHRM Login Test (OrhmLoginTest.java)

Accepts XPath locators from testng.xml (@Parameters).

Uses @DataProvider (OrhmLoginDatas) to test login with multiple credentials:

Admin / admin123

Manager / manager123

Developer / developer123

Performs Login → Profile → Logout validation.

✅ Shaadi.com Registration Test (ShadiRegisterTestNg.java)

Reads test data from ShadiRegisterDatas (@DataProvider).

Supports multiple registration datasets (name, gender, email, password).

Handles dropdowns (DOB, Religion, Education, Country).

Submits registration form for each dataset.
