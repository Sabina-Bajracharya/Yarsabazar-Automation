# YarsaBazar Automated Testing

This repository contains automated tests for the YarsaBazar website using WebDriver in Java. The tests are designed to ensure that the website's key features and functionalities including dashboard, login, signup, search, and footer,  work as expected.

## Prerequisites

Before running the tests, make sure you have the following prerequisites set up:

- Java Development Kit (JDK)
- Selenium WebDriver
- TestNG
- Chrome WebDriver
- Extent Reports
- YarsaBazar website URL
- Maven Dependencies

2. Download the ChromeDriver and specify its path in the test code.

3. Install the necessary maven dependencies, including Selenium WebDriver, TestNG, and Extent Reports.

4. Ensure the YarsaBazar website is accessible at the URL specified in the "actualBrowserURL" variable.

## Running Tests

The main test class to execute is `YarsaBazarTest`.

## Test Structure

The tests are organized into different classes within the `test` package:

YarsaBazarTest: The main test class containing test methods for different features of the YarsaBazar website.

Each test class corresponds to a specific feature or page of the website.

## Data Providers

Data providers are used to parameterize test methods. Data for test cases can be found within the same test class.

getSignUpData: Provides data for testing the sign-up process.
getLoginData: Provides data for testing the login process.
getSearchData: Provides data for testing the search functionality.


