package testcase;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.Homepage;
import pages.Login1;
import pages.MyAccountpage;
import testbase.WebTestBase;
public class TC02 extends WebTestBase {
	//each cls is created for each webpage
	MyAccountpage myAccountPage;
	Homepage homePage;
Login1 loginPage;
	
	
	//loading the config  file
	
	public TC02(){
		//property or confing file loading
        super();
    }
	@BeforeMethod//it will be cl only onces before all testcase are called
	public void BeforeMethod()
	{
		//Loading the driver file and eatablishing the connection ,loading the url
	initialization();
	//create obj for each cls
	myAccountPage=new MyAccountpage();
	homePage=new Homepage();
	loginPage=new Login1();
}
	@Test
	public void verifyLoginWithValidCredential()
	{
		//softassert==>check the condition
		SoftAssert softAssert = new SoftAssert();
		//login will be clicked
	     homePage.userSearchClick();
	     loginPage.login(prop.getProperty("mobile"), prop.getProperty("password"));
	     System.out.println("verify");
	     softAssert.assertEquals(myAccountPage.getTextOFMYAccountPage(), "My Account", "My Account text should be match");
	     softAssert.assertAll();
	}
	@Test
	public void verifySearchBar(){
	     SoftAssert softAssert = new SoftAssert();
	     myAccountPage.search();
	     System.out.println(myAccountPage.getTextOfSearch());
	     softAssert.assertEquals(myAccountPage.getTextOfSearch(), "Showing results for \"nick vujicic\"\n" +
	             "53 results found","Showing results for \"nick vujicic\"\n" +
	             "53 results found text should be match");
	    myAccountPage.selectDropDown("byVisibleText", "Best Seller");
	     softAssert.assertAll();
	 }
	@Test
	public void verifyMouseHover(){
	     SoftAssert softAssert = new SoftAssert();
	     myAccountPage.mouseHover();
	     softAssert.assertAll();
	 }
	@Test
	//to scroll 
	 public void verifyScrollUP(){
	     SoftAssert softAssert = new SoftAssert();
	     myAccountPage.scrollUP();
	     softAssert.assertAll();
	 }
	@Test
	//to scroll 
	 public void verifyScrollDown(){
	     SoftAssert softAssert = new SoftAssert();
	     myAccountPage.scrollDown();
	     softAssert.assertAll();
	 }
	@Test
	//to scroll doun up utube image icon
	 public void verifyScrollDown1(){
	     SoftAssert softAssert = new SoftAssert();
	     myAccountPage.scrollDownMethod();
	     softAssert.assertAll();
	 }
	
	@Test
	 public void verifyGetWindowHandle(){
	     SoftAssert softAssert = new SoftAssert();
	     myAccountPage.windowHandle();
	     softAssert.assertAll();
	 }
	
    @Test
	public void verifyclickone() {
		SoftAssert softAssert = new SoftAssert();
	     myAccountPage.click5();
	     softAssert.assertAll();
	}
	
	@Test
	public void check()
	{
		System.out.println("hai");
		}
	
	
}