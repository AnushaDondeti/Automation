package flipkartpages;

import org.openqa.selenium.By;

import Testcases.TestBase;
import Testcases.WebActions;

public class login extends TestBase {

	WebActions action = new WebActions();

	// =============login===============

	By mobileno = By.xpath("//input[@class='_2IX_2- VJZDxU']");
	By pwd = By.xpath("//input[@type='password']");
	By loginbtn = By.xpath("(//button[contains(@type,'submit')])[2]");
	// ==================logout===================
	By Myacunt = By.xpath("//div[text()='My Account']");
	By logout = By.xpath("//a[contains(.,'Logout')]");

	public void login() {

		action.sendKeys(mobileno, "9951157871");
		action.sendKeys(pwd, "flipkart");
		action.click(loginbtn, "loginbutton");
	}

	public void logout() {
		action.mousehover(Myacunt, "myacnt");
		action.click(logout, "logout");
	}

}
