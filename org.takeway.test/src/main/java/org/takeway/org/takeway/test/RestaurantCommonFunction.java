package org.takeway.org.takeway.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.sun.xml.bind.v2.schemagen.xmlschema.List;

public class RestaurantCommonFunction{
	
	public WebDriver driver = null;
	
	// Method to call method LaunchApplication and setDriver
	public void LaunchApplicationAndSetDriver(String pBrowserName)
	{
		try
		{
			LaunchApplication setDriver = new LaunchApplication();
			driver = setDriver.launchBrowser(pBrowserName);
			GlobalDeclaration.errorOccured=false;
		}
		catch(Exception e)
		{
			GlobalDeclaration.errorOccured=true;
			System.out.println("Error occured in method LaunchApplicationAndSetDriver");
		 }
	} //public void LaunchApplicationAndSetDriver(String pBrowserName)
		
	// Read Excel file
	 public XSSFSheet ReadExcelFile(String strExcelFilePath)
	 {
		 
		 File file =null;
		 XSSFWorkbook workbook = null;
		 try
		 {
			 file = new File(strExcelFilePath);
		 
		 //
			 FileInputStream fis = null;
		 
				 try {
					 fis = new FileInputStream(file);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
				
				try {
					workbook = new XSSFWorkbook(fis);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 }
		 catch(Exception e)
		 {
			System.out.println("Problem in reading the global declaration file");
			GlobalDeclaration.errorOccured=true;
		 }
		 
				
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		return sheet;
	 } // public XSSFSheet ReadExcelFile(String strExcelFilePath)
	 
	 // Need to delete this method after moving all code in main 
	 public void LocationToSearch(String  pstrLocationToSearch)
	 {
		 try
		 {
			 // calling function to insert the text to search
			 
			 InsertTextToSearchLocation(pstrLocationToSearch);
	
			 // it is displayed again then handle it
			 
			 if(GlobalDeclaration.errorOccured==false)
			 {
			 
				 ClickSubmitButtonToSEarchExactLocation();
			 }
			 
			 try
			 {
				 //syso
				 // Check if search location screen appear again again as it will appear some time 
				 if(GlobalDeclaration.errorOccured==false)
				 {
					// InsertTextToSearchLocation(pstrLocationToSearch);
				 }
				 if(GlobalDeclaration.errorOccured==false)
				 {
					ClickSubmitButtonToSEarchExactLocation();
					SearchExactLocationFromList(GlobalDeclaration.searchText);
				 }
				 
				
			 }
			 catch(Exception e)
			 {
				 
				 System.out.println("Error occured in method LocationToSearch");
			 }
			
			 
		 }
		 catch(Exception e)
		 {
			 System.out.println("Error occured in LocationToSearch");
			 //e.printStackTrace();
		 }
		 
	 } // public void LocationToSearch(String  pstrLocationToSearch)
	 
	 // Function to applyExplicit wait
	 
	 public void applyExplicitWait(String condition , By element , int waitingTime)
	 {
		 try
		 {
			 WebDriverWait wait = new WebDriverWait(driver,waitingTime);
			 if (condition.contains("visible"))
			 {
				wait.until(ExpectedConditions.visibilityOfElementLocated(element));
			 }
			 else if (condition.contains("clickable"))
			 {
				 wait.until(ExpectedConditions.elementToBeClickable(element));
			 }
	
		 }
		 catch (Exception e)
		 {
			 //System.out.println("Error occured in applyExplicitWait");
		 }
	 }// public void applyExplicitWait(St
	 
	 public void SearchExactLocationFromList(String pSearchText)
	 {
		
		 try
		 {
			 By searchTextBy = By.linkText(pSearchText);
			 
			 applyExplicitWait("clickable", searchTextBy,20);
			 
			 driver.findElement(searchTextBy).click();
			 GlobalDeclaration.errorOccured=false;
		 }
		 catch (Exception e)
		 {
			 GlobalDeclaration.errorOccured=false;
			 
			//e.printStackTrace();
			 
		 }
		 
	 }
	 
	 //Method for display the restaurant by type
	 
	 public void DisplayRestaurantByType(String pRestaurantType)
	 {
		 clickCookieOKButton();
		 try
		 {
			 By searchTextBy = By.linkText(pRestaurantType);
			 
			 applyExplicitWait("clickable", searchTextBy,20);
			 
			 driver.findElement(searchTextBy).click();
			 GlobalDeclaration.errorOccured=false;
		 }
		 catch (Exception e)
		 {
			 GlobalDeclaration.errorOccured=true;
			 System.out.println("Getting to problem to search a location in method DisplayRestaurantByType");
			// e.printStackTrace();
			 
		 }
		 
	 }// public void DisplayRestaurantByType(String pRestaurantType)
	 
	 // Select the particular restaurant and display the menu items
	 public void SelectRestaurantAndDisplayMenu(String pRestaurantName)
	 {
		 try
		 {
			 By RestaurantNameBy = By.linkText(pRestaurantName);
			 
			 applyExplicitWait("clickable", RestaurantNameBy, 20);
			 
			 WebElement	RestaurantNameByElement = driver.findElement(RestaurantNameBy);
			 RestaurantNameByElement.click();
			 GlobalDeclaration.errorOccured=false;
		 }
		 catch(Exception e)
		 {
			 GlobalDeclaration.errorOccured=true;
			 System.out.println("Getting to problem to search a location in method SelectRestaurantAndDisplayMenu");
		 }
		 
		 
	 }//public void SelectRestaurantAndDisplayMenu(String pRestaurantName)
	 
	 //Select the particular items
	 public void ItemSelection(String pItemName)
		{
		   try
		   {
		 		List<WebElement> allItems = driver.findElements(By.tagName("span"));
				 
				 WebElement ItemElementFound = null;
				 
				 for(WebElement singleItem:allItems)
				 {
					 String singleItemText = singleItem.getText();
					 if(singleItemText.equalsIgnoreCase(pItemName))
					 {
						 						 
							ItemElementFound = singleItem;
							
							WebElement parentElement = singleItem.findElement(By.xpath("./.."));
							 
							 /// find span tag from parent elemet -- start
							List<WebElement>  parentElementspans = parentElement.findElements(By.tagName("span"));
							  
							/// find span tag from parent element -- end
							 
							WebElement SecondparentElement = parentElement.findElement(By.xpath("./.."));
							 				  
							WebElement ThirdparentElement = SecondparentElement.findElement(By.xpath("./.."));
								
							WebElement FourparentElement = ThirdparentElement.findElement(By.xpath("./.."));
								 
							List<WebElement> fourparentElementspans = FourparentElement.findElements(By.tagName("span"));
								  
							// click on particular items
							singleItem.click();
							
							// wait fot some particular time as sometime getting an error
							
							try {
								Thread.sleep(5000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						 
						 // dclick on price button
						 List<WebElement> priceButtons =  FourparentElement.findElements(By.tagName("button"));
						 
						 for(WebElement button:priceButtons)
						 {
							 
							 if(button.getText().contains("€"))
							 {
								 button.click();
								 break;
							 }
						
						 }// for(WebElement button:priceButtons)
		 
					 }// if(singleItemText.equalsIgnoreCase(pItemName))
				 } //for(WebElement singleItem:allItems)
		   } // try
		   catch(Exception e)
		   {
			   System.out.println("");
		   }
	
		} //public void ItemSelection(String pItemName)
	 
	// method to click clickCookieOKButton
	 public void clickCookieOKButton()
	 {
		 
		 try
		 {
			List<WebElement> allbutton = driver.findElements(By.tagName("button"));
			
			for(WebElement btn:allbutton)
			{
				String strbtnText = btn.getText();
				if(strbtnText.equals("OK"))
				{
					btn.click();
					break;
				}
			}
			 
		 }
		 catch(Exception e)
		 {
			 System.out.println("");
		 }
	 }//public void clickCookieOKButton()
	 
	
	 //Method to place the order
	 public void PlaceOrder()
	 {
		 try
		 {
			
			 By OrderButtonBy = By.cssSelector("button[class='basket__order-button cartbutton-button']");
			 applyExplicitWait("clickable", OrderButtonBy, 20);
			 WebElement OrderButton = driver.findElement(OrderButtonBy);
			
			 OrderButton.click();
			 
		 }
		 catch(Exception e)
		 {
			 GlobalDeclaration.errorOccured=true;
			 System.out.println("Getting to problem to search a location in method PlaceOrder");
		 }
	 }// public void PlaceOrder()
	 
	 // method to search the address
	 
	 public void InsertTextToSearchLocation(String pstrLocationToSearch)
	 {
		 try
		 {
				 By searchAddressElementBy = By.id("imysearchstring");
				 
				 applyExplicitWait("clickable", searchAddressElementBy,20);
				 
				 clickCookieOKButton();
			
				 // check frame avaiable - end
				
				
				if (GlobalDeclaration.blnELocationToSearchTextEntered==false)
				{
					WebElement searchAddressElement = driver.findElement(searchAddressElementBy);
					//searchAddressElement.sendKeys(" ");
					
					searchAddressElement.sendKeys(Keys.BACK_SPACE);
					searchAddressElement.sendKeys(Keys.chord(Keys.CONTROL, "a"));
					searchAddressElement.sendKeys(Keys.DELETE);
					searchAddressElement.sendKeys(pstrLocationToSearch);
					 
					
					//searchAddressElement.sendKeys(pstrLocationToSearch);
					GlobalDeclaration.blnELocationToSearchTextEntered = false;
				}
		 } //try
		 catch(Exception e)
		 {
			 GlobalDeclaration.errorOccured=true;
			 System.out.println("Error occured in method InsertTextToSearchLocation");
		 }
	 }// public void InsertTextTOSearchLocation()
	 
	 public void ClickSubmitButtonToSEarchExactLocation()
	 {
		 try
		 {
			// apply explict wait on submitElement
			 By submitElementBy = By.id("submit_deliveryarea");
			 
			 applyExplicitWait("clickable", submitElementBy,30);
			 
			 // click on submit_deliveryarea
			 			 
			 WebElement submitElement = driver.findElement(By.id("submit_deliveryarea"));
			 submitElement.click();
			 GlobalDeclaration.errorOccured=false;
		 }
		 catch(Exception e)
		 {
			 GlobalDeclaration.errorOccured=false;
			 System.out.println("Error occured in method ClickSubmitButtonToSEarchExactLocation");
		 }
	 }// public void CLickSubmitButtonToSEarchExactLocation()
	 
	 public void ReleaseAllResources()
	 {
		 GlobalDeclaration.errorOccured=false;
		 driver.quit();
		 driver = null;
		 
	 }//public void ReleaseAllResources()
	 
	 public void FillFormDetailsAndOrderPay()
	 {
		 try
		 {
			 // Address
			 
			 WebElement AddressEle= driver.findElement(By.id("iaddress"));
			 AddressEle.sendKeys(GlobalDeclaration.Address);
			 
			 //PostCode
			 WebElement PostCodeEle= driver.findElement(By.id("ipostcode"));
			 
			 PostCodeEle.sendKeys(Keys.BACK_SPACE);
			 PostCodeEle.sendKeys(Keys.chord(Keys.CONTROL, "a"));
			 PostCodeEle.sendKeys(Keys.DELETE);
			 PostCodeEle.sendKeys(GlobalDeclaration.PostCode);
			 
			 //City
			 WebElement CityEle= driver.findElement(By.id("itown"));
			 CityEle.sendKeys(GlobalDeclaration.City);
			 
			 //email
			 
			 WebElement emailEle= driver.findElement(By.id("iemail"));
			 emailEle.sendKeys(GlobalDeclaration.eMail);
			 
			 // Name
			 //
			 WebElement nameEle= driver.findElement(By.id("isurname"));
			 nameEle.sendKeys(GlobalDeclaration.eMail);
			 
			 //PhoneNumber
			 
			 WebElement PhoneNumberEle= driver.findElement(By.id("iphonenumber"));
			 PhoneNumberEle.sendKeys(Double.toString(GlobalDeclaration.PhoneNum));
			 
			 // check box
			 //inewsletter
			// By OrderAndPayBy = By.cssSelector("input[value='Order and pay']");
			 
			 //input[class='button_form cartbutton-button']
			 By OrderAndPayBy = By.cssSelector("input[class='button_form cartbutton-button']");
			 
			 applyExplicitWait("clickable", OrderAndPayBy, 20);
			 
			 WebElement OrderAndPayEle= driver.findElement(OrderAndPayBy);
			 
			 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", OrderAndPayEle);
			 
			 OrderAndPayEle.click();
			 GlobalDeclaration.errorOccured=false;
		 }
		 catch(Exception e)
		 {
			 GlobalDeclaration.errorOccured=true;
			 System.out.println("Error occured in method FillFormDetailsAndOrderPay");
		 }
		 
	 }// public void FillFormDetails()
	 
	 public void getOrderReference()
	 {
		 try
		 {
			 //div[class='order-reference']
			 By OrderReferenceBy = By.cssSelector("div[class='order-reference']");
			 
			 applyExplicitWait("visible", OrderReferenceBy, 10);
			 
			 WebElement OrderReferenceEle = driver.findElement(OrderReferenceBy);
			 
			 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", OrderReferenceEle);
			 String strOrderReference = OrderReferenceEle.getText();
			 
			 System.out.println("Order Reference is : " + strOrderReference);
		 }
		 catch(Exception e)
		 {
			 GlobalDeclaration.errorOccured=false;
			 System.out.println("Error occured in method getOrderReference");
		 }
		 
	 }// public void getOrderReference()
	 
	 public void checkAnyRestaurantExistForSelectedLocation()
	 {
		 try
		 {
		 //Check whether restaurant is exist
			By checkRestaurantExistBy = By.cssSelector("h2[class='restaurantname']");
			
			applyExplicitWait("clickable", checkRestaurantExistBy,20);
			
			WebElement checkRestaurantExist = driver.findElement(checkRestaurantExistBy);
			
			List<WebElement> checkAnyLinkRestaurant = checkRestaurantExist.findElements(By.tagName("a"));
			int intnumberRestaurantElement = checkAnyLinkRestaurant.size();
			
			if(intnumberRestaurantElement>0)
			{
				GlobalDeclaration.blnRestaurantExist= true;
				System.out.println("Restaurant verified :Restaurant are available for search location " + GlobalDeclaration.searchText);
				
				
			}
			else
			{
				System.out.println("Restaurant Not Exist");
				GlobalDeclaration.blnRestaurantExist= false;
				
			}
		 }
		 catch(Exception e)
		 {
			 //System.out.println("Restaurant is not esist");
			 GlobalDeclaration.blnRestaurantExist= false;
			 System.out.println("Error occured in method checkAnyRestaurantExistForSelectedLocation");
		 }
	 }

}//public class RestaurantCommentFunction {
