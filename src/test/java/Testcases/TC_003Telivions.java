package Testcases;

import org.testng.annotations.Test;

import flipkartpages.Telivisionpage;

public class TC_003Telivions  extends TestBase{
	@Test
	public void telivisions() throws Throwable {
		log = extent.createTest("TC_003Telivison");
		Telivisionpage tel = new Telivisionpage();
		tel.create();
		tel.select();
	}
}
