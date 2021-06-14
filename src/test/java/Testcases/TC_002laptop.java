package Testcases;

import org.testng.annotations.Test;

import flipkartpages.laptops;
import flipkartpages.login;

public class TC_002laptop extends TestBase {
	
	@Test
	public void Reg() throws Throwable {
		log=extent.createTest("TC_002laptop");
		//login l1 = new login();
		//l1.login();
		laptops lp = new laptops();
		lp.laptops();
		lp.filters();
		lp.validation();
		lp.addtocart();
		//l1.logout();
}
}
