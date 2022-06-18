package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTests {
		
		static WebDriver driver = null;
		static String url = "https://www.udemy.com/join/login-popup/";
		static String expPageTitle = "https://www.udemy.com/";
		
		@BeforeTest
		public void test_setup(){
			System.setProperty("webdriver.chrome", "C:\\Users\\toma\\OneDrive\\Desktop\\Automation\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		@Test
		public void login_success_case(){

			driver.get(url);
			LoginPage login = new LoginPage(driver);
			login.type_username("udemy@gmail.com");
			login.type_password("123456");
			login.click_login_button();

			login.timer();
			
			if (driver.getCurrentUrl().equalsIgnoreCase(expPageTitle)) {
				System.out.println("login_success_case(): Test Passed, logged in to udemy and directed to dashboard with correct id-password");
			}else{
				System.out.println("login_success_case(): Test Failed, did not login to udemy even with correct id-password");
			}
		}

		@Test
		public void login_submission_both_empty_fields(){

			driver.get(url);
			LoginPage login = new LoginPage(driver);
			login.type_username("");
			login.type_password("");
			login.click_login_button();

			login.timer();
			if (driver.getCurrentUrl().equalsIgnoreCase(expPageTitle)) {
				System.out.println("login_submission_both_empty_fields(): Test Failed, logged in to udemy and directed to dashboard without any id-password");
			}else{
				System.out.println("login_submission_both_empty_fields(): Test Passed, did not login to udemy without any id-password");
			}
		}

		@Test
		public void login_submission_password_field_empty(){

			driver.get(url);
			LoginPage login = new LoginPage(driver);
			login.type_username("udemy@gmail.com");
			login.type_password("");
			login.click_login_button();

			login.timer();
			if (driver.getCurrentUrl().equalsIgnoreCase(expPageTitle)) {
				System.out.println("login_submission_password_field_empty(): Test Failed, logged in to udemy and directed to dashboard without password");
			}else{
				System.out.println("login_submission_password_field_empty(): Test Passed, did not login to udemy without password");
			}
		}

		@Test
		public void login_submission_username_field_empty(){

			driver.get(url);
			LoginPage login = new LoginPage(driver);
			login.type_username("");
			login.type_password("123456");
			login.click_login_button();

			login.timer();
			if (driver.getCurrentUrl().equalsIgnoreCase(expPageTitle)) {
				System.out.println("login_submission_username_field_empty(): Test Failed, logged in to udemy and directed to dashboard without id");
			}else{
				System.out.println("login_submission_username_field_empty(): Test Passed, did not login to udemy without id");
			}
		}

		@Test
		public void login_non_existent_user(){

			driver.get(url);
			LoginPage login = new LoginPage(driver);
			login.type_username("xyz@gmail.com");
			login.type_password("789654");
			login.click_login_button();

			login.timer();
			if (driver.getCurrentUrl().equalsIgnoreCase(expPageTitle)) {
				System.out.println("login_with_non_existent_user(): Test Failed, logged in to udmey even without being registered");
			}else{
				System.out.println("login_with_non_existent_user(): Test Passed, did not login to udemy with unregistered user");
			}
		}


		@Test
		public void login_correct_username_wrong_password(){
			
			driver.get(url);
			LoginPage login = new LoginPage(driver);
			login.type_username("admin");
			login.type_password("789654");
			login.click_login_button();
			
			login.timer();
			if (driver.getCurrentUrl().equalsIgnoreCase(expPageTitle)) {
				System.out.println("login_correct_username_wrong_password(): Test Failed, logged in to udemy even with wrong password");
			}else{
				System.out.println("login_correct_username_wrong_password(): Test Passed, did not login to udemy with wrong password");
			}
			
		}
		
		@AfterTest
		public void close_browser(){
			driver.close();
		}
		

	}

