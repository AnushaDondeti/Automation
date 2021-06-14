package flipkartpages;

import org.openqa.selenium.By;

import Testcases.TestBase;
import Testcases.WebActions;
import utilities.ConfigReader;

public class Telivisionpage  extends TestBase{
	WebActions actions = new WebActions();
	By crsbtn = By.xpath("//button[text()='✕']");
	By Appliances = By.xpath("(//img[@class='_396cs4 _3exPp9'])[7]");
	By telivisons = By.xpath("//a[@class='_6WOcW9 _2-k99T']");
	By All = By.xpath("//a[@class='_6WOcW9 _3YpNQe'][contains(.,'All')]");
	By Brand = By.xpath("//div[text()='Brand']");
	By BrandSearch = By.xpath("//input[@class='_34uFYj']");
	By BrandCheckBox = By.xpath("//div[text()='SAMSUNG']");
//	By ScroolElent = By.xpath("//div[text()='Connectivity Features']");
	By OperatingSystem = By.xpath("//div[text()='Operating System']");
	By OStype = By.xpath("//div[text()='Tizen']");
	By Sort = By.xpath("//div[text()='Price -- High to Low']");

//	=================================product selection==================================

	By firstLink = By.xpath("//a[@title='SAMSUNG Series 8 189 cm (75 inch) Ultra HD (4K) LED Smart TV']");
	By vText = By.xpath("//span[@class='B_NuCI']");

//	=============================Add to cart================================================
	By AddToCard = By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']");
	By CartPro = By.xpath("//a[@class='_2Kn22P gBNbID']");
	By PlaceOrder = By.xpath("//span[text()='Place Order']");
	By mobileno = By.xpath("//input[contains(@type,'text')]");
	By con = By.xpath("//span[contains(.,'CONTINUE')]");
	By pwd = By.xpath("//input[contains(@type,'password')]");
	By lgn = By.xpath("(//span[contains(.,'Login')])[2]");
    //By Radio = By.xpath("(//input[@type=\"radio\"])[1]");
    By deliver = By.xpath("//button[text()='Deliver Here']");
    By text1= By.xpath("//span[@class=\"_263yGF\"]");
	
//	===========================Login=====================================================
	By Username = By.xpath("//input[@class='_2IX_2- _17N0em']");
	
	
	
	/**
     * =============================================================================
     * Method: create| Author: Anusha Dondeti| Date:25 May 2020 |
     * Description: This method will select the category and filters to the category
     * the selected product
     * | Parameters: locator | Return: element
     * =============================================================================
     */
	public void create() throws Throwable {
		actions.click(crsbtn, "cancel button");
		actions.MoveToElement(Appliances);
		actions.MoveToElement(telivisons);
		actions.click(All, "All list");
		actions.ScrollDown(Brand);
		actions.sendKeys(BrandSearch, "Samsung");
		actions.click(BrandCheckBox, "Samsung brand");
//		actions.ScrollDown(OperatingSystem);
		actions.Scrolldown2();
		actions.click(OperatingSystem, "Operating System");
		actions.click(OStype, "Tizen");
		Thread.sleep(2000);
		actions.click(Sort, "Price high to low");
	}
	
	/**
     * =============================================================================
     * Method:select| Author: Anusha Dondeti| Date:25 May 2020 |
     * Description: This method will verify the product and adding  to the cart
     * the selected product
     * | Parameters: locator | Return: element
     * =============================================================================
     */
	public void select() throws Throwable {

		Thread.sleep(2000);
		actions.click(firstLink, "First product from the list");
		actions.window_handling2(vText);
		String SElectedProduct = actions.getText(vText);
//		System.out.println("==== "+SElectedProduct);
		String Expected1 = "SAMSUNG Series 8 189 cm (75 inch) Ultra HD (4K) LED Smart TV  (UA75NU8000KXXL)";
		actions.verifyText(SElectedProduct, Expected1);
		actions.click(AddToCard, "Add to cart");
		Thread.sleep(2000);
		String CartProductText = actions.getText(CartPro);
		System.out.println(CartProductText);
		String Expected = "SAMSUNG Series 8 189 cm (75 inch) Ultra HD (4K) LED Smart TV";
//		SAMSUNG Series 8 189 cm (75 inch) Ultra HD (4K) LED Smart TV  (UA75NU8000KXXL)
		actions.verifyText(CartProductText, Expected);
		actions.click(PlaceOrder, "Place order");
		Thread.sleep(2000);
		actions.sendKeys(mobileno, ConfigReader.getValue("Phonenumber"));
		Thread.sleep(2000);
		actions.click(con, "continue");
		Thread.sleep(2000);
		actions.sendKeys(pwd, ConfigReader.getValue("Password"));
		Thread.sleep(2000);
		actions.click(lgn, "login");
		//actions.click(Radio,"radiobutton");
		//actions.click(deliver, "deliveryadress");
		String actual1 = actions.getText(text1);
		System.out.println(actual1);
		String expected1 = "The following item is Not Deliverable at 500033. You can change the address and check the serviceability.";
		actions.verifyText(actual1, expected1);
		
		
	}
	


}


