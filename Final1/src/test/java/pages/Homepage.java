package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.WebTestBase;

public class Homepage extends WebTestBase {
	//id for my account in the home page
	@FindBy(id = "ctl00_lblUser")
    WebElement usersearch;//cls variable is==>usersearch
//creaating web elements
	//initializing the page obj
    public Homepage(){
    	//for connecting to the driver
    	//this:current obj
    	//pagefactory:it is inbuilt desing pattern
    	//init 
        PageFactory.initElements(driver,this);
    }
//clicking my account
    public void userSearchClick(){
        usersearch.click();
    }
}


