package org.takeway.org.takeway.test;

public class GlobalDeclaration {
	
	public static  String URL = "";
	public static  String Browser = "";
	
	//Address	
	public static  String Address = "";
	
	// 	PostCode
		public static  String PostCode = "";
	//City
	public static  String City = "";
	
	//Name			
	public static  String Name = "";
	
	//PhoneNum		
	//public static  CharSequence[] PhoneNum = null;
	
	public static  double PhoneNum = 0;

	//e-mail
	public static  String eMail = "";
	
	//LocationToSearch	
	public static  String LocationToSearchText = "8888";
	
	// searchText
		public static String searchText = "8888 Alpha";
	
		// Track Enter Text to search Area
	public static Boolean blnELocationToSearchText = false;
	
	public static Boolean blnELocationToSearchTextEntered = false;
	
	
	public static boolean errorOccured = true;
	
	// Public global declaration file
	public static String globalDeclarationFile = System.getProperty("user.dir")+"\\inputDataFiles\\globalvariable.xlsx";
	
	// chromeExePath
	public static String chromeExePath = System.getProperty("user.dir")+"\\driverExe\\chrome\\chromedriver.exe";
	
	// IEExePath
	public static String ieExePath = System.getProperty("user.dir")+"\\driverExe\\ie\\IEDriverServer.exe";
	
	// FirefoxExePath
	public static String fireFoxExePath = System.getProperty("user.dir")+"\\driverExe\\firefox\\geckodriver.exe";
	
	
	
	//Search RestaurantType
	public static String RestaurantType = "All";
	
	//
	//public static String RestaurantName = "POS Test";
	// Check Restaurant Exist
	
	public static Boolean blnRestaurantExist = false;
	
	public static String RestaurantName = "";
	
	// Item Selection 1
	
	//public static String menuItem1 = "Cheese burger";
	
	public static String menuItem1 = "";
	
	public static String menuItem2 = "";
	
	public static String menuItem3 ="";
	
	public static String menuItem4 = "";

	//SteakhouseDSE
	//public static String RestaurantName = "SteakhouseDSE";
	//TEST Restaurant Selenium
	//public static String RestaurantName = "TEST Restaurant Selenium";
	/*
	public String getURL() {
		return this.URL;
	}
	public void setURL(String uRL) {
		this.URL = uRL;
		System.out.println("setURL " + this.URL);
	}
	public String getBrowser() {
		return this.Browser;
	}
	public void setBrowser(String browser) {
		this.Browser = browser;
	}
	*/
	
		

}
