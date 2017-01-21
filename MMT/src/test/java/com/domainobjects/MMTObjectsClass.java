package com.domainobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MMTObjectsClass {

	
	//flight Image
	@FindBy(id="com.makemytrip:id/activity_home_lc_flights_txtvw")
	private WebElement txtFlight;
	
	//dept city layout
	@FindBy(id="com.makemytrip:id/depCity")
	private WebElement layoutDeptCity;
	
	//common txt box for entering search
	@FindBy(id="com.makemytrip:id/city_edit_text")
	private WebElement txtSearchDeptArrivalCity;
	
	//common select city
	@FindBy(id="com.makemytrip:id/cityName")
	private WebElement selectDeptArrivalCity;
	
	@FindBy(id="com.makemytrip:id/arrCity")
	private WebElement layoutArrivalCity;
	
	@FindBy(id="com.makemytrip:id/depDateLayout")
	private WebElement layoutDeptDate;
	
	
	
	@FindBy(id="com.makemytrip:id/calOK")
	private WebElement btnOkInCalendar;
	
	@FindBy(id="com.makemytrip:id/returnDateLayout")
	private WebElement layoutReturnDate;
	
	@FindBy(id="com.makemytrip:id/searchFlights")
	private WebElement btnSearch;
	
	@FindBy(id="com.makemytrip:id/split_book_btn")
	private WebElement btnBook;
	
	public MMTObjectsClass(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getTxtFlight() {
		return txtFlight;
	}

	public WebElement getLayoutDeptCity() {
		return layoutDeptCity;
	}

	public WebElement getTxtSearchDeptArrivalCity() {
		return txtSearchDeptArrivalCity;
	}

	public WebElement getSelectDeptArrivalCity() {
		return selectDeptArrivalCity;
	}

	public WebElement getLayoutArrivalCity() {
		return layoutArrivalCity;
	}

	public WebElement getLayoutDeptDate() {
		return layoutDeptDate;
	}

	public WebElement getBtnOkInCalendar() {
		return btnOkInCalendar;
	}

	public WebElement getLayoutReturnDate() {
		return layoutReturnDate;
	}

	public WebElement getBtnSearch() {
		return btnSearch;
	}
	
	public WebElement getBtnBook() {
		return btnBook;
	}
	
	public void clickFlightOption()
	{
		txtFlight.click();
	}
	
	public void clickDeptCityLayout()
	{
		layoutDeptCity.click();
	}
	
	public void clickArrCityLayout()
	{
		layoutArrivalCity.click();
	}
	
	public void enterDeptCityForSearch(String deptCity)
	{
		txtSearchDeptArrivalCity.sendKeys(deptCity);
	}
	
	public void selectDeptArrivalCity()
	{
		selectDeptArrivalCity.click();
	}
	
	public void clicklayoutDeptDate()
	{
		layoutDeptDate.click();
	}
	
	public void clicklayoutReturnDate()
	{
		layoutReturnDate.click();
	}
	
	public void clickOkButtonInCal()
	{
		btnOkInCalendar.click();
	}
	
	public void clickSearchButton()
	{
		btnSearch.click();
	}
	
	public void clickBookButton()
	{
		btnBook.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
