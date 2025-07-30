# 🛒 Automation Testing Framework for E-Commerce Website

This is a complete test automation framework for testing an e-commerce website — [automationpractice.com](http://automationpractice.com)  
It uses Java, Selenium WebDriver, TestNG, Maven, Jenkins, Docker, and AWS EC2 to demonstrate CI/CD automation capabilities.

---

## 📌 Tools & Technologies Used

- Java
- Selenium WebDriver
- TestNG
- Maven
- Git & GitHub
- Jenkins
- Docker
- AWS EC2
- ExtentReports

---

## ✅ Features Covered

- Automated test cases for:
  - Login
  - Sign Up (Account Creation)
  - Product Search
  - Forgot Password
- Data-Driven + Modular Hybrid Framework
- TestNG with DataProvider for parameterized testing
- ExtentReports for detailed execution reports
- XPath and CSS Selectors for element handling
- Dockerized execution
- CI/CD via Jenkins on AWS EC2 instance

---

## 📁 Project Structure

```bash
Automation-testing-project/
├── .idea/                 # IDE-related files
├── ExtentReports/         # HTML test reports generated
├── Screenshots/           # Screenshots on failure
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── Files/         # External files if needed
│   │       ├── Listeners/     # TestNG listeners (for logs, reports)
│   │       ├── Pages/         # Page Object Model classes
│   │       ├── TestData/      # Data classes / Excel readers
│   │       └── Utilities/     # Utility classes (Waits, Actions, etc.)
│   └── test/
│       └── java/
│           ├── Base.java      # Base setup class (driver setup, etc.)
│           ├── CreateAccount.java
│           ├── ForgotPassword.java
│           ├── Search.java
│           └── Signin.java    # Test classes
├── Dockerfile              # Docker container setup
├── pom.xml                 # Maven configuration
└── testng.xml              # TestNG suite file


🌐 CI/CD Integration
Jenkins is configured with a GitHub webhook to trigger jobs automatically on code push.

The automation suite runs inside a Docker container on an AWS EC2 instance.

Execution reports are stored in the ExtentReports/ folder and archived via Jenkins.

📸 Reports and Screenshots
On test failure, screenshots are saved in Screenshots/.

Beautiful HTML reports generated using ExtentReports (ExtentReports/).

👨‍💻 Author
Prethumnan J
📧 prethumnan77@gmail.com
📍 Panruti, Tamil Nadu, India
