package com.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.Test;
import com.domainobjects.MMTObjectsClass;
import com.generic.GenericMMT;
import com.utility.PropertyUtility;

public class BookingTest extends MasterMMTTest {

	public String day;
	public Integer month;
	public String year;
	
	public static Map<Integer,String> calMonthList=new HashMap<Integer,String>();

	static{

		calMonthList.put(1, "January");

		calMonthList.put(2, "February");

		calMonthList.put(3, "March");

		calMonthList.put(4, "April");

		calMonthList.put(5, "May");

		calMonthList.put(6, "June");

		calMonthList.put(7, "July");

		calMonthList.put(8, "August");

		calMonthList.put(9, "September");

		calMonthList.put(10, "October");

		calMonthList.put(11, "November");

		calMonthList.put(12, "December");


	}
	
	@Test
	public void testBooking() throws IOException, InterruptedException
	{
	    
	    String departureCity = PropertyUtility.readPropertyFile("./mmt.properties", "departureCity");
	    String arrivalCity = PropertyUtility.readPropertyFile("./mmt.properties", "arrivalCity");
	    String departureDate = PropertyUtility.readPropertyFile("./mmt.properties", "departureDate");
	    String returnDate = PropertyUtility.readPropertyFile("./mmt.properties", "returnDate");
	    
	    String monthXpath = PropertyUtility.readPropertyFile("./mmt.properties", "monthXpath");
	    String dateSelectXpath = PropertyUtility.readPropertyFile("./mmt.properties", "dateSelectXpath");

	    
	    MMTObjectsClass mmt = new MMTObjectsClass(driver);
	    
	    Thread.sleep(3000);
	    mmt.clickFlightOption();
	    
	    Thread.sleep(2000);
	    mmt.clickDeptCityLayout();
    
	    Thread.sleep(2000);
	    mmt.enterDeptCityForSearch(departureCity);
	    
	    Thread.sleep(2000);
	    mmt.selectDeptArrivalCity();

	    Thread.sleep(2000);
	    mmt.clickArrCityLayout();
	    
	    Thread.sleep(2000);
	    mmt.enterDeptCityForSearch(arrivalCity);
	    
	    Thread.sleep(2000);
	    mmt.selectDeptArrivalCity();
	    
	    Thread.sleep(3000);
	    mmt.clicklayoutDeptDate();
	    
	    String[] dateSplit = departureDate.split("-");
	    day = dateSplit[0];
	    System.out.println(day);
	    
	    month = Integer.parseInt(dateSplit[1]);
	    System.out.println(month);
	    
	    year = dateSplit[2];
	    System.out.println(year);
	    
	    String monthYear = calMonthList.get(month)+" "+year;
	    
		String monthXpathDynamic = monthXpath + monthYear+"']";
		String dateSelectXpathDynamic = dateSelectXpath + day+"']";

	    
	    System.out.println(monthYear);
	    GenericMMT.swipeAndSelctDate(driver, monthXpathDynamic, dateSelectXpathDynamic);
	    
		Thread.sleep(2000);
	    mmt.clickOkButtonInCal();
	    
	    
	    Thread.sleep(2000);
	    mmt.clicklayoutReturnDate();
	    
	    String[] ReturnDateSplit = returnDate.split("-");
	    
	    day = ReturnDateSplit[0];
	    System.out.println(day);
	    
	    month = Integer.parseInt(ReturnDateSplit[1]);
	    System.out.println(month);
	    
	    year = ReturnDateSplit[2];
	    System.out.println(year);
	    
	    monthYear = calMonthList.get(month)+" "+year;
	    
	    monthXpathDynamic = monthXpath + monthYear+"']";
	    dateSelectXpathDynamic = dateSelectXpath + day+"']";
	  
	    GenericMMT.swipeAndSelctDate(driver, monthXpathDynamic, dateSelectXpathDynamic);
	    
	    GenericMMT.explicitWait(driver, mmt.getBtnOkInCalendar(), 25);
	 	mmt.clickOkButtonInCal();
	    
	 	GenericMMT.explicitWait(driver, mmt.getBtnSearch(), 25);
	    mmt.clickSearchButton();
	    
	    GenericMMT.explicitWait(driver, mmt.getBtnBook(), 40);
	    mmt.clickBookButton();
	    
	    Thread.sleep(10000);
	   	
	}
	
}
