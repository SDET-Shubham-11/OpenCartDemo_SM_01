# 🧪 Selenium Java Hybrid Automation Framework

## 🚀 Project Summary
This is a complete **hybrid automation testing framework** built using **Java**, **Selenium WebDriver**, and **TestNG**, designed for scalable and maintainable end-to-end UI automation. 
The test cases are executed on the **Demo OpenCart website**: [https://demo.opencart.com](https://demo.opencart.com)

---

## 📦 Tech Stack & Tools Used

- **Language:** Java  
- **Testing Framework:** TestNG  
- **Build Tool:** Maven  
- **Design Pattern:** Page Object Model (POM)  
- **Data-Driven Testing:** Apache POI for Excel  
- **Reporting:** ExtentReports  
- **Screenshots:** Captured on test failures  
- **Browser Drivers:** Managed via WebDriverManager (Optional)

---

## ✅ Test Scenarios Covered

1. **Add to Cart** – Validate that a product is successfully added to the cart.  
2. **End-to-End Purchase Flow** – Simulate a complete purchase flow.  
3. **Contact Us Form Submission** – Fill and submit the 'Contact Us' form.  
4. **Count Menu Items on Hover** – Count and verify submenu items under header menus.

---

## 📁 Project Structure
├── src
│ ├── main
│ │ └── java
│ │ └── base # Browser setup, config
│ │ └── pages # POM classes for different pages
│ │ └── utilities # Reusable methods, Excel reader
│ ├── test
│ │ └── java
│ │ └── tests # TestNG test classes
│
├── test-output # Reports generated after test execution
├── reports # Screenshots & ExtentReport
├── pom.xml
└── README.md
