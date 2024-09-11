# Automated Testing of Login Functionality - Selenium with TestNG

## Description

This project automates the testing of the login functionality for the web application hosted at [Germany Is Calling](https://app.germanyiscalling.com/). The test suite includes multiple scenarios for both valid and invalid login attempts	 to ensure the robustness of the login system.

## Prerequisites

Before you can run the tests, you need to have the following tools installed:

- **Java Development Kit (JDK)**
- **Apache Maven** (for managing dependencies and running tests)
- **Google Chrome** browser
- **ChromeDriver**, which allows Selenium to control Chrome for browser automation.

Additionally, you should configure the TestNG framework, which is used to organize and run the test cases.

## Test Execution Steps

### 1. **Install ChromeDriver**
   - Download ChromeDriver from [here](https://googlechromelabs.github.io/chrome-for-testing/#stable) according to your Chrome version.
   - Place the downloaded `chromedriver.exe` in a known location on your computer (e.g., `C:/drivers/`).

### 2. **Set ChromeDriver Path**
   - In the `setUp()` method of the test script, update the ChromeDriver path. It should look something like this:
     ```java
     System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\Downloads\\drivers\\chromedriver.exe");
     ```

### 3. **Clone the Repository**
   - Clone this repository to your local machine using:
     ```bash
     git clone https://github.com/Nandan198/Germany-Is-Calling
     ```

### 4. **Import into an IDE**
   - Open an IDE like Eclipse.
   - Import the project as a Maven project. Maven will automatically manage dependencies like Selenium and TestNG.

### 5. **Running the Tests**
   - To run the tests, you can:
     - Run them directly from the IDE by right-clicking the test class and selecting "Run As TestNG Test."
      

### 6. **Check Test Results**
   - The results of the tests will be visible either in the TestNG tab of your IDE or in the console.

## Assumptions

- The user has valid credentials to test the successful login scenario.
- The Chrome browser and ChromeDriver versions match to avoid compatibility issues.
- The application’s login page structure (element IDs and XPaths) will not change frequently, as the tests depend on these.

## Test Cases

### 1. **Valid Login:**
   - The script enters a valid email and password and checks if the user is redirected to the home page after successful login.
   
### 2. **Invalid Password:**
   - The script inputs a valid email but an incorrect password, then verifies that the system displays the appropriate error message.

### 3. **Invalid Email:**
   - The script enters an incorrect email with a valid password, checking that the appropriate error message appears.

### 4. **Both Invalid Credentials:**
   - The script inputs an invalid email and password to verify that the system displays the appropriate error message.

### 5. **Empty Email:**
   - The script leaves the email field empty and submits the form, verifying if the system displays error message like Email: This field is required..

### 6. **Empty Password:**
   - The script enters a valid email but leaves the password field empty, and checks if the correct error message is displayed like 
Password: This field is required..

### 7. **Both Fields Empty:**
   - The script leaves both the email and password fields empty, and checks for the appropriate error message is displayed like Email: This field is required.

Password: This field is required..

## Additional Information

### Limitations:
- The test scripts are limited to testing in Google Chrome. If needed, they can be extended to support other browsers like Firefox or Safari.
- Currently, the tests only validate the front-end behavior of the login system. They do not cover API testing, performance testing, or security testing.

### Challenges:
- One challenge I faced was setting System.setProperty for the ChromeDriver. Since I was using an older version, it was important to ensure the correct path to chromedriver.exe was provided.
  This required careful configuration to avoid compatibility issues.
- Another challenge was comparing the different error messages on the login page. Depending on the input, the actual error message needed to match the expected one, which required careful handling.
- I also faced some issues with locating dynamic elements on the page using XPaths and CSS selectors.
- Finally, I had to manage page load delays by adding waits to make sure the elements were fully loaded before interacting with them.

### Improvements:
- **UI Improvement for the Login Button**: The login button could be more responsive and visually consistent, especially across different screen sizes like Laptop L (1440px), Laptop (1020px), and Tablet (768px). Making sure it reacts quickly and looks good on all these devices would improve the user experience.
---

