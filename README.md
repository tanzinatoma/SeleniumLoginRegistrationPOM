# SeleniumLoginRegistrationPOM
This is a selenium template for testing any login and registration function of any system (udemy here as an example). This is created to automate the testing and run all the prepared test cases with all possible scenerios.


## Packages

In this project, there are 2 different packages. 

1. `admin.pages` package contains classes that have the locators and actions of a particular admin page.
*Package Contains*: 
- LoginPage 
- RegistrationPage
##### Example
`LoginPage.java` contains the locators username field, password field and login buttons. It also has the actions to be performed using these locators eg. type username, type password and click login.

2. `admin.tests` package contains the tests that needs to be performed on the pages in admin panel. Tests are divided into modules according to functions.
*Package Contains*: 
- LoginTests
- RegistrationTests
##### Example
`LoginTests.java` contains the methods which are used to test every cases. Each method is a test case for that particular page. Each method name is self-explanatory and shows the inputs given in that particular test case.
e.g.: `login_submission_password_field_empty()` method tests a case where login attempt is made without submitting password.

## Appendix
- Maven Project
- Testing Frameworks - Selenium, TestNG

chromedriver is in 'drivers' folder, need to only change the path in class.
`pom.xml` file contains all the dependencies.
