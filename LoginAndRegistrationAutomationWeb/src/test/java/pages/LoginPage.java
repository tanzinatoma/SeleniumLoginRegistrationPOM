package pages;
import org.openqa.selenium.*;

public class LoginPage {
	WebDriver driver = null;

	public LoginPage(WebDriver driver){
		this.driver = driver;
	}

	By username = By.xpath("//*[@id='email--1']");
	By pass = By.xpath("//*[@id='id_password']");
	By login = By.xpath("//*[@id='submit-id-submit']");

	public void timer(){
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void type_username(String text){
		timer();
		driver.findElement(username).sendKeys(text);
	}

	public void type_password(String text){
		timer();
		driver.findElement(pass).sendKeys(text);
	}

	public void click_login_button(){
		timer();
		driver.findElement(login).click();
	}

}
