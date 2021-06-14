package flipkartpages;

import org.openqa.selenium.By;

import Testcases.TestBase;
import Testcases.WebActions;
import utilities.ConfigReader;

public class Grocery  extends TestBase{
	
	WebActions action = new WebActions();
	//=============grocery======================
	By crsbtn = By.xpath("//button[text()='✕']"); 
	By grocery = By.xpath("//div[@class='xtXmba'][contains(.,'Grocery')]");
	By pincode = By.xpath("//input[@title='Enter pincode']");
	By stapels = By.xpath("(//div[@class='xtXmba'])[1]");
	By dal = By.xpath("(//a[contains(.,'Ghee & Oils')])[2]");
	By oil = By.xpath("(//div[contains(@class,'_1MbXnE')])[1]");
	By addtobckt = By.xpath("//button[contains(.,'ADD TO BASKET')]");
	By gobkt = By.xpath("//div[@class='_3nHuRA']");
	By placeorder = By.xpath("//span[contains(.,'Place Order')]");
	By mobileno = By.xpath("//input[contains(@type,'text')]");
	By con = By.xpath("//span[contains(.,'CONTINUE')]");
	By pwd = By.xpath("//input[contains(@type,'password')]");
	By lgn = By.xpath("(//span[contains(.,'Login')])[2]");
	By name = By.xpath("//input[contains(@tabindex,'1')]");
	By mobile = By.xpath("//input[contains(@tabindex,'2')]");
	By pin = By.xpath("//input[contains(@tabindex,'3')]");
	By local = By.xpath("//input[contains(@tabindex,'4')]");
	By adr = By.xpath("//textarea[contains(@tabindex,'5')]");
	By city = By.xpath("//input[contains(@tabindex,'6')]");
	By state = By.xpath("(//div[contains(.,'State')])[18]");
	By hom = By.xpath("(//div[contains(@class,'1XFPmK')])[2]");	
	By del = By.xpath("(//button[contains(@type,'button')])[2]");
	By time = By.xpath("(//div[@class='_1XFPmK'])[3]");
	By Cbtn = By.xpath("//button[contains(.,'CONTINUE')]");
	By credit = By.xpath("(//input[@type='radio'])[5]");
	By Cnum = By.xpath("//input[contains(@name,'cardNumber')]");
	By month = By.xpath("//select[@class='_2t2oBT _1wEi1H _9IYuSq']");
	By yy = By.xpath("//select[@class='_2t2oBT _1wEi1H']");
	By cvv= By.xpath("//input[contains(@type,'password')]");
	By paynow = By.xpath("//button[@type='button']");
	By text1 = By.xpath("//span[text()='Not a valid card number']");
			
			
	
	
	
	public void grocery() throws Throwable {
		action.click(crsbtn, "crossmark");
		action.click(grocery, "grocery");
		action.sendKeys(pincode, "500033");
		Thread.sleep(2000);
		action.keybordactions(pincode);
		action.mousehover(stapels, "grocery");
		Thread.sleep(2000);
		action.click(dal, "gheendoil");
		Thread.sleep(2000);
		action.click(oil, "orgpanut");
		action.window_handling();
		action.Scrolldown2();
		Thread.sleep(2000);
		action.click(addtobckt, "addtobacket");
		Thread.sleep(2000);
		action.click(gobkt, "gotobacket");
		Thread.sleep(2000);
		action.click(placeorder, "placeorder");
		Thread.sleep(2000);
		action.sendKeys(mobileno, ConfigReader.getValue("Phonenumber"));
		Thread.sleep(2000);
		action.click(con, "continue");
		Thread.sleep(2000);
		action.sendKeys(pwd, ConfigReader.getValue("Password"));
		Thread.sleep(2000);
		action.click(lgn, "login");
		action.sendKeys(name, "anusha");
		action.sendKeys(mobile, ConfigReader.getValue("Phonenumber"));
		action.sendKeys(pin, "500033");
		action.sendKeys(local, "madhapur");
		action.sendKeys(adr, "Madhapur Metro Station, Jubilee Hills,Rangareddy District, Telangana — 500033,");
		//action.sendKeys(city, "hyderabad");
		//action.click(state, "state");
		//action.selectDropDownByValue(state, "Telangana");
		action.Scrolldown2();
		action.click(hom, "home");
		Thread.sleep(2000);
		action.click(del, "deliverytype");
		Thread.sleep(2000);
		action.click(time, "time");
		Thread.sleep(2000);
		action.click(Cbtn, "conbtn");
		Thread.sleep(2000);
		action.click(credit, "credit");
		action.sendKeys(Cnum, "5129670405254460");
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
