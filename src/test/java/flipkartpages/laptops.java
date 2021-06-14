package flipkartpages;

import org.openqa.selenium.By;

import Testcases.TestBase;
import Testcases.WebActions;
import utilities.ConfigReader;

public class laptops extends TestBase {

	WebActions action = new WebActions();
//=============search================================
	By crsmark = By.xpath("//button[text()='✕']");
	By search = By.xpath("//input[@name=\"q\"]");

	// ===========filters==========
	By processer = By.xpath("//*[text()='Core i5']");
	By brand = By.xpath("//div[@class='_3879cV'][contains(.,'HP')]");
	By HtoL = By.xpath("//div[@class='_10UF8M'][contains(.,'Price -- High to Low')]");
	By lap = By.xpath(
			"//img[@src='https://rukminim1.flixcart.com/image/312/312/ke0a7ww0/computer/t/3/j/hp-original-imafushcajardghe.jpeg?q=70']");

	// ===============validation==============
	By text = By.xpath("//span[@class=\"B_NuCI\"]");

	// =============addtocart==========
	By add = By.xpath("//button[@class=\"_2KpZ6l _2U9uOA _3v1-ww\"]");
	By place = By.xpath("//button[@class=\"_2KpZ6l _2ObVJD _3AWRsL\"]");
	// By delivery = By.xpath("//button[text()='Deliver Here']");
	By mobileno = By.xpath("//input[contains(@type,'text')]");
	By con = By.xpath("//span[contains(.,'CONTINUE')]");
	By pwd = By.xpath("//input[contains(@type,'password')]");
	By lgn = By.xpath("(//span[contains(.,'Login')])[2]");
	// By cont = By.xpath("//button[@type=\"submit\"]");
	// By cont = By.xpath("//span[text()='CONTINUE']");
	By login = By.xpath("//button[@type=\"submit\"]");
	// By Radio = By.xpath("(//input[@type=\"radio\"])[3]");
	By deliver = By.xpath("//button[text()='Deliver Here']");
	By coun = By.xpath("//button[text()='CONTINUE']");
	// By text1= By.xpath("//span[@class=\"_263yGF\"]");
	By payments = By.xpath("//label[@for='CREDIT']");
	By Cnumber = By.xpath("//input[@name='cardNumber']");
	By month = By.xpath("//select[@name='month']");
	By yy = By.xpath("//select[@name='year']");
	By cvv = By.xpath("//input[@name='cvv']");
	By paynow = By.xpath("//button[@type='button']");
	By text1 = By.xpath("//span[text()='Not a valid card number']");

	/**
	 * =============================================================================
	 * Method: lapatops| Author: Anusha Dondeti| Date:25 May 2020 | Description:
	 * This method will serach for laptop the selected product | Parameters: locator
	 * | Return: element
	 * =============================================================================
	 */

	public void laptops() throws Throwable {
		action.click(crsmark, "crossmark");
		action.sendKeys(search, "laptops");
		Thread.sleep(3000);
		action.keybordactions(search);

	}

	/**
	 * =============================================================================
	 * Method: filters| Author: Anusha Dondeti| Date:25 May 2020 | Description: This
	 * method will apply filters for laptop the selected product | Parameters:
	 * locator | Return: element
	 * =============================================================================
	 */
	public void filters() throws Throwable {

		action.click(processer, "corei5");
		String actual1 = action.getText(processer);
		System.out.println(actual1);
		String expected1 = "Core i5";
		action.verifyText(actual1, expected1);
		action.Scrolldown1();
		action.click(brand, "hp");
		String actual2 = action.getText(brand);
		System.out.println(actual2);
		String expected2 = "HP";
		action.verifyText(actual2, expected2);
		Thread.sleep(2000);
		action.click(HtoL, "high to low");
		String actual3 = action.getText(HtoL);
		System.out.println(actual3);
		String expected3 = "Price -- High to Low";
		action.verifyText(actual3, expected3);
		Thread.sleep(2000);
		action.click(lap, "lapatop");
		action.window_handling();
	}

	/**
	 * =============================================================================
	 * Method:validation| Author: Anusha Dondeti| Date:25 May 2020 | Description:
	 * This method will validates the selected product the selected product |
	 * Parameters: locator | Return: element
	 * =============================================================================
	 */
	public void validation() {
		String actual = action.getText(text);
		System.out.println(actual);
		String expected = "HP Spectre x360 Core i5 10th Gen - (16 GB/512 GB SSD/Windows 10 Pro/4 GB Graphics) 15-eb0014tx 2 in 1 Laptop  (15.6 inch, Poseidon Blue, 1.92 kg, With MS Office)";
		action.verifyText(actual, expected);
	}

	/**
	 * =============================================================================
	 * Method:addtocart| Author: Anusha Dondeti| Date:25 May 2020 | Description:
	 * This method will add the product to cart and proceed for payment the selected
	 * product | Parameters: locator | Return: element
	 * =============================================================================
	 */
	public void addtocart() throws Throwable {
		action.click(add, "addtocart");
		/*String actual4 = action.getText(add);
		System.out.println(actual4);
		String expected4 = "ADD TO CART";
		action.verifyText(actual4, expected4);
		Thread.sleep(2000);*/
		action.click(place, "placeorder");
		action.sendKeys(mobileno, ConfigReader.getValue("Phonenumber"));		
		Thread.sleep(2000);
		action.click(con, "continue");
		Thread.sleep(2000);
		action.sendKeys(pwd, ConfigReader.getValue("Password"));
		Thread.sleep(2000);
		action.click(lgn, "login");
		// action.click(Radio, "radiobutton");
		// action.click(payments, "payments");
		// action.click(deliver, "deliveryoption");
		Thread.sleep(2000);
		action.click(coun, "continue");
		// String actual1 = action.getText(text1);
		// System.out.println(actual1);
		// String expected1 = "The following item is Not Deliverable at 500072. You can
		// change the address and check the serviceability.";
		// action.verifyText(actual1, expected1);
		Thread.sleep(2000);
		action.Scrolldown2();
		action.click(payments, "credit");
		action.sendKeys(Cnumber, "5129670405254460");
		action.selectDropDownByValue(month, "11");
		action.selectDropDownByValue(yy, "22");
		action.sendKeys(cvv, "219");
		action.click(paynow, "paynow");
		String actual1 = action.getText(text1);
		 System.out.println(actual1);
		String expected1 = "Not a valid card number";
		 action.verifyText(actual1, expected1);

	}
}
