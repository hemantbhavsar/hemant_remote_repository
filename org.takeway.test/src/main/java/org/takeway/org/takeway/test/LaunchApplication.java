package org.takeway.org.takeway.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class LaunchApplication {
	
		public WebDriver launchBrowser(String strBrowserName)
		 {
			 WebDriver mdriver = null;
			
			try
			{
				System.out.println("BrowserName  " + strBrowserName);
			
				 if(strBrowserName.equalsIgnoreCase("ie"))
				 {
					 System.setProperty("webdriver.ie.driver", GlobalDeclaration.ieExePath);
					 
					 mdriver = new InternetExplorerDriver();
				 }
				 else if (strBrowserName.equalsIgnoreCase("firefox"))
				 {
					 System.setProperty("webdriver.gecod.driver", GlobalDeclaration.fireFoxExePath);
					 
					 FirefoxOptions op = new FirefoxOptions(); 
					 op.addPreference("geo.enabled", false); 	
					 op.addPreference("dom.disable_beforeunload", true);
					 
					 //to disable teh cookies but code is not working so commented
					// op.addPreference("network.cookie.cookieBehavior", 2);
					 
					 
					 mdriver = new FirefoxDriver(op);
					 
				 }
				 else if (strBrowserName.equalsIgnoreCase("chrome"))
				 {
					 System.setProperty("webdriver.chrome.driver", GlobalDeclaration.chromeExePath);
					 
					 
					 mdriver = new ChromeDriver();
				 }
				 //Launch the URL here 
				 
				// System.out.println(" URL before launch :   " + globaldeclaration.getURL());
				 mdriver.get(GlobalDeclaration.URL);
				 
				
				 
				 //Maximize the window
				 mdriver.manage().window().maximize();
				  
				  //Handle pop up
				  
				  // wait to pop display
				  
				  Thread.sleep(10000);
				  
				  
				  
						  
					  
				  GlobalDeclaration.errorOccured=false;
				  
				  
			}
			catch(Exception e)
			{
				System.out.println("Application unable to launch successly. Please check");
				GlobalDeclaration.errorOccured=true;
			}
			return mdriver;
	}//public void launchBrowser(String strBrowserName)

}//public class LaunchApplication {
