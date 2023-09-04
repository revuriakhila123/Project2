package pages;

import java.io.IOException;

import org.apache.poi.xdgf.util.Util;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility1.util;
import testbase.WebTestBase;


public class MyAccountpage extends WebTestBase {
	@FindBy(xpath = "//h1[text()='My Account']")
    WebElement accountTitle;
	
	 @FindBy(xpath = "//input[@id='inputbar']")
	    WebElement searchTextBox;

	    @FindBy(id = "btnTopSearch")
	    WebElement searchBtn;

	    @FindBy(xpath = "//div[@class='search-summary search-heading']")
	    WebElement searchTitle;
	    
	    @FindBy(xpath = "//select[@class='styled']")
	    WebElement dropDown;

	    @FindBy(xpath = "//span[@class='usernametext']")
	    WebElement hover;
	    
	    @FindBy(xpath = "//*[@id=\"ctl00_libestseller\"]/a")
	    WebElement seller;
	   
	    @FindBy(xpath = "//img[@alt='Youtube']")
	    WebElement youtubeOption;
	     
	    @FindBy(xpath = "//*[@id=\"newtrend\"]/div[2]/a/img")
	    WebElement trendingone;
	     
	   
	public MyAccountpage(){
        PageFactory.initElements(driver, this);
    }
	public String getTextOFMYAccountPage(){
        return accountTitle.getText();
    }
	public void search(){
        searchTextBox.click();
        searchTextBox.sendKeys("nick vujicic");
        searchTextBox.sendKeys(Keys.ENTER);
        searchBtn.click();
    }
	public void selectDropDown(String term, String value) {
		dropDown.click();
		util.selectValue(dropDown,term,value);
	}
	public void mouseHover() {
		util.mouseHover(driver,hover);
	}
	public void click5() {
		util.mouseHover(driver,seller);
		seller.click();
	}
	public String getTextOfSearch() {
		//getting the result of search text
		return searchTitle.getText();
	}
	
	public static void scrollDown(){
	    JavascriptExecutor js=(JavascriptExecutor)driver;
	    js.executeScript("window.scrollBy(0,500)");
	}
	public static void scrollUP() {
	    JavascriptExecutor js=(JavascriptExecutor)driver;
	    js.executeScript("window.scrollBy(0,500)");
	}
	public void scrollDownMethod() {
		util.scrollDownByElement(driver, youtubeOption);
		youtubeOption.click();
	}
	
	public void windowHandle() {
		util.scrollDownByElement(driver, youtubeOption);
		youtubeOption.click();
		util.switchToWindows(driver);
}
	
	public void getCookiesHandle() {
		util.getCookies();
	}
	 
	
}	
	


