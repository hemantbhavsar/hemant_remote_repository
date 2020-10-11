package org.takeway.org.takeway.test;

import org.apache.poi.xssf.usermodel.XSSFSheet;

public class RestaurantOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		XSSFSheet globalDeclarationSheet = null;
		
		//GlobalDeclaration globalVariable = new GlobalDeclaration();
		
		RestaurantCommonFunction function = new RestaurantCommonFunction();
		
		try
		{
			globalDeclarationSheet=function.ReadExcelFile(GlobalDeclaration.globalDeclarationFile);
			
			int intTotalRows = globalDeclarationSheet.getLastRowNum();
			
			// iterate through execel  file to find execution flag
			
			for (int intRow=1;intRow<=intTotalRows;intRow++)
			{
				//Check execution flag
				String ExecutionFlag = globalDeclarationSheet.getRow(intRow).getCell(16).getStringCellValue();
				
				if (ExecutionFlag.equalsIgnoreCase("Yes"))
				{
					// First check which scenario from Global declaration need to execute
					// We need to make execution Flag cilumn in glabaldeclation file to Yes. All other columns should be No
					
					// set the url					
					GlobalDeclaration.URL  = globalDeclarationSheet.getRow(intRow).getCell(0).getStringCellValue();
					// set Browser
					GlobalDeclaration.Browser  = globalDeclarationSheet.getRow(intRow).getCell(1).getStringCellValue();
					
					// Restaurant and meni items
					GlobalDeclaration.RestaurantName  = globalDeclarationSheet.getRow(intRow).getCell(2).getStringCellValue();
					
					GlobalDeclaration.menuItem1  = globalDeclarationSheet.getRow(intRow).getCell(3).getStringCellValue();
					GlobalDeclaration.menuItem2  = globalDeclarationSheet.getRow(intRow).getCell(4).getStringCellValue();
					GlobalDeclaration.menuItem3  = globalDeclarationSheet.getRow(intRow).getCell(5).getStringCellValue();
					GlobalDeclaration.menuItem4  = globalDeclarationSheet.getRow(intRow).getCell(6).getStringCellValue();
					
					//Address		10
					GlobalDeclaration.Address  = globalDeclarationSheet.getRow(intRow).getCell(10).getStringCellValue();
					//PostCode
					GlobalDeclaration.PostCode  = globalDeclarationSheet.getRow(intRow).getCell(11).getStringCellValue();
					//City			11
					GlobalDeclaration.City  = globalDeclarationSheet.getRow(intRow).getCell(12).getStringCellValue();
					//Name			12
					GlobalDeclaration.Name  = globalDeclarationSheet.getRow(intRow).getCell(13).getStringCellValue();
					//PhoneNum		13	
					GlobalDeclaration.PhoneNum  = (int) globalDeclarationSheet.getRow(intRow).getCell(14).getNumericCellValue();
					//e-mail			14
					GlobalDeclaration.eMail  = globalDeclarationSheet.getRow(intRow).getCell(15).getStringCellValue();
					
				}//if (globalDeclarationSheet.getLastRowNum()>0)
			}//for (int intRow=1;intRow<=intTotalRows;intRow++)
		}
		catch(Exception e)
		{
			System.out.println("Please set global declaraton file");
		}
		// Function to launch the  application and set the Browser
		function.LaunchApplicationAndSetDriver(GlobalDeclaration.Browser);
		
		function.LocationToSearch(GlobalDeclaration.LocationToSearchText);
		
		 if(GlobalDeclaration.errorOccured==false)
		 {
			 function.SearchExactLocationFromList(GlobalDeclaration.searchText);
		 }
		 if(GlobalDeclaration.errorOccured==false)
		 {
			 function.DisplayRestaurantByType(GlobalDeclaration.RestaurantType);
		 }
		 
		 if(GlobalDeclaration.errorOccured==false)
		 {
			 function.checkAnyRestaurantExistForSelectedLocation();
		 
			 function.SelectRestaurantAndDisplayMenu(GlobalDeclaration.RestaurantName);
		 }
		 if(GlobalDeclaration.errorOccured==false)
		 {
			if(!GlobalDeclaration.menuItem1.equals(""))
			{
				function.ItemSelection(GlobalDeclaration.menuItem1);
			}
			if(!GlobalDeclaration.menuItem2.equals(""))
			{
				function.ItemSelection(GlobalDeclaration.menuItem2);
			}
			if(!GlobalDeclaration.menuItem3.equals(""))
			{
				function.ItemSelection(GlobalDeclaration.menuItem3);
			}
			if(!GlobalDeclaration.menuItem4.equals(""))
			{
				function.ItemSelection(GlobalDeclaration.menuItem4);
			}
			function.PlaceOrder();
		 }
		 if(GlobalDeclaration.errorOccured==false)
		 {
			 function.FillFormDetailsAndOrderPay();
		 }
		function.getOrderReference();
		function.ReleaseAllResources();
		

	}//public static void main(String[] args) {

}//public class RestaurantOrder {
