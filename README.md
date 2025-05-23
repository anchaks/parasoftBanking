# Banking Web Application - Selenium Test Automation Framework

This is a Selenium-based TestNG automation framework built in Java to automate key workflows of a banking web application. It supports phased automation for account registration, login validation, new account creation, and Excel-based reporting using Apache POI.

## 📌 Project Highlights

- **Phase 1**: Automates account registration and saves new account details to an Excel file.(`UserAccountCreated_.xlsx`)
- **Phase 2**: Automates login using registered credentials.
- **Phase 3**: Reads existing account numbers from Excel(`UserAccountCreated_.xlsx`), automates the "open new account" process, and generates a new Excel report (`UpdatedUserAccountDetails_.xlsx`).

## ✅ Features

- End-to-end functional automation for banking operations
- Uses PageFactory design pattern
- Generates and updates Excel reports at each phase
- Parameterized testing using TestNG
- Clean project structure using Maven
- Browser compatibility (Chrome, Firefox, Edge, Safari)

## 🔧 Technologies Used

- Java
- Selenium WebDriver
- TestNG
- Maven
- Apache POI (for Excel)
- ExtentReports (for HTML test reporting)
- PageFactory (Selenium)

## 📁 Project Structure

```
banking-automation/
├── src/
│   ├── main/java/
│   │   └── pageObjects/
│   │   └── utilities/
│   └── test/java/
│       └── phase1/
│       └── phase2/
│       └── phase3/
├── testng.xml
├── pom.xml
├── config.properties
└── README.md
```

## 🚀 Getting Started

### Clone the Repository

```bash
git clone https://github.com/yourusername/banking-automation.git
cd banking-automation
```

### Import the Project

- Open in VSCode or IntelliJ as a Maven project.
- Ensure Java SDK and Maven are correctly configured.

## 🧪 Running Tests

Run all test phases:

```bash
mvn clean test
```

```

## 📊 Reports

- HTML reports are generated with ExtentReports at:  
  `test-output/

- Excel reports are generated/updated for:
  - `UserAccountCreated_.xlsx` (after Phase 1)
  - `UpdatedUserAccountDetails_.xlsx` (after Phase 3)

## 📸 Screenshots

Screenshots of passed and failed tests are auto-saved in:
```
screenshots/
```
