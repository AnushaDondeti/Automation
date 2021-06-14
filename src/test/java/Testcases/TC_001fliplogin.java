package Testcases;

import org.testng.annotations.Test;

import flipkartpages.login;



public class TC_001fliplogin extends TestBase {
	@Test
	public void Reg() throws Throwable {
		log=extent.createTest("TC_001fliplogin");
		login l1 = new login();
		l1.login();
		l1.logout();
		
	}
	
}
