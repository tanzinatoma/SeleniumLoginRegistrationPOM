package pages;

import org.openqa.selenium.*;

public class RegistrationPage {

	WebDriver driver = null;

	public RegistrationPage(WebDriver driver){
		this.driver = driver;
	}

	By name = By.xpath("//*[@id='email--1']");
	By email = By.xpath("//*[@id='id_password']");
	By pass = By.xpath("//*[@id='submit-id-submit']");
	By signup = By.xpath("//*[@id='submit-id-submit']");
	By warning_message = By.xpath("/html/body/div[1]/div[3]/div[1]/div/div[2]/form/div[3]/div/div[2]/div/div[2]");

	public void timer(){
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void type_name(String text){
		timer();
		driver.findElement(name).sendKeys(text);
	}

	public void type_email(String text){
		timer();
		driver.findElement(email).sendKeys(text);
	}
	
	public void type_pass(String text){
		timer();
		driver.findElement(pass).sendKeys(text);
	}
	
	public void click_signup_button(){
		timer();
		driver.findElement(signup).click();
	}
	
	public String get_warning_message(){
		String warning = driver.findElement(warning_message).getText();
		return warning;
	}


}
