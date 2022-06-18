package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.RegistrationPage;

public class RegistrationTests {
	static WebDriver driver = null;
	static String url = "https://www.udemy.com/join/signup-popup/";
	static String expPageTitle = "redirect page url";
	
	@BeforeTest
	public void test_setup(){
		System.setProperty("webdriver.chrome", "C:\\Users\\toma\\OneDrive\\Desktop\\Automation\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void reg_success_case(){

		driver.get(url);
		RegistrationPage reg = new RegistrationPage(driver);
		reg.type_name("Username");
		reg.type_email("udemy@gmail.com");
		reg.type_pass("123456");
		reg.click_signup_button();

		reg.timer();
		
		if (driver.getCurrentUrl().equalsIgnoreCase(expPageTitle)) {
			System.out.println("reg_success_case(): Test Passed, registered to udemy with all correct data");
		}else{
			System.out.println("login_success_case(): Test Failed, did not register to udemy with all correct data");
		}
	}
	
	@Test
	public void reg_all_empty_data(){

		driver.get(url);
		RegistrationPage reg = new RegistrationPage(driver);
		reg.type_name("");
		reg.type_email("");
		reg.type_pass("");
		reg.click_signup_button();

		reg.timer();
		
		if (driver.getCurrentUrl().equalsIgnoreCase(expPageTitle)) {
			System.out.println("reg_success_case(): Test Failed, registered to udemy with no data");
		}else{
			System.out.println("login_success_case(): Test passed, did not register to udemy without any data");
		}
	}
	
	@Test
	public void reg_weak_password(){

		driver.get(url);
		RegistrationPage reg = new RegistrationPage(driver);
		reg.type_name("Username");
		reg.type_email("udemy@gmail.com");
		reg.type_pass("123456");
		reg.click_signup_button();
		
		reg.timer();
		
		String warn = reg.get_warning_message();
		
		if (warn.equalsIgnoreCase("Too weak")) {
			System.out.println("reg_success_case(): Test Failed, registered to udemy with no data");
		}else{
			System.out.println("login_success_case(): Test passed, did not register to udemy without any data");
		}
	}

}
