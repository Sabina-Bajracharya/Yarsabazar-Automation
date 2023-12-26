# YarsaBazar Automated Testing

This repository contains automated tests for the YarsaBazar website using WebDriver in Java. The tests are designed to ensure that the website's key features and functionalities including dashboard, login, signup, search, and footer,  work as expected.

## Prerequisites

Before running the tests, make sure you have the following prerequisites set up:
- Intellij
- Java Development Kit (JDK)
- Selenium WebDriver
- TestNG
- Chrome WebDriver
- Edge WebDriver
- Extent Reports
- YarsaBazar website URL
- Maven Dependencies
- Microsoft Excel

## Installation
1. Install the "IntelliJ IDEA Community Edition" version of Intellij from this link https://www.jetbrains.com/idea/download/?section=windows based on your OS.
2. Install JDK version 21 bin file from https://www.oracle.com/java/technologies/downloads/#jdk21-windows based on your OS.
3. Install latest Google Chrome browser on your device.
4. Install the Chrome driver from https://chromedriver.chromium.org/downloads. Make sure the chrome driver version is compatible with Chrome browser.

## Getting Started 
1. Clone the project from the Github.
2. Open Intellij and choose the Maven Project.
3. Open the cloned project on Intellij.
4. Open pom.xml file to load the Maven Dependencies
5. Click on Maven symbol shown on the image below to load all the presented Maven Dependencies.
6. The Maven Dependencies consist of  Selenium Webdriver, junit, testng, and extent reports.
7. Optional -> [If required you can search for maven dependencies from this link https://mvnrepository.com/ ]
8. Copy the full path of your chrome driver and edge driverfrom your local device. 
9. Replace the current paths for the Chrome driver and Edge driver with the respective paths on your local machine. 
10. Select the preferred browser for execution and replace it with the current browser option in @parameter section. 
11. Run the test by right-clicking on YarsabazarTest and click on run. 
12. Leave the automation browser till it closes itself to generate the real time report. 
13. If the automated browser is closed before finishing the automation, the real time report will not overwrite. 
14. Right Click on Extentreport.html then click on open in browser to see the html report.

## Running Tests

The main test class to execute is `YarsaBazarTest`.
The vendor test class to execute is `YarsaBazarVendorTest`.

## Test Structure

The tests are organized into different classes within the `test` package:

YarsaBazarTest: The main test class containing test methods for different features of the YarsaBazar website.
YarsaBazarVendorTest: The test class containing test methods for vendor dashboards only.
Each test class corresponds to a specific feature or page of the website.

## Data Providers

Data providers are used to parameterize test methods. Data for test cases can be found within the same test class.

getSignUpData: Provides data for testing the sign-up process.
getLoginData: Provides data for testing the login process.
getSearchData: Provides data for testing the search functionality.

A data provider employs the Faker library for creating simulated data and relies on an Excel sheet to extract information from an integrated Excel file.

For Excel data, information is stored in a Microsoft Excel file named YBtestCredentials.xlsx.