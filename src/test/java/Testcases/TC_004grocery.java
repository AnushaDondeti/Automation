package Testcases;

import org.testng.annotations.Test;

import flipkartpages.Grocery;

public class TC_004grocery  extends TestBase{
	
	@Test
	public void Reg() throws Throwable {
		log=extent.createTest("TC_004grocery");
		Grocery gr= new Grocery();
		gr.grocery();
	}
	
}
