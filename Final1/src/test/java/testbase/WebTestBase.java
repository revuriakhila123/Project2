package testbase;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class WebTestBase {
	public static WebDriver driver;
	public static Properties prop;
	
	public WebTestBase()
	{
		try
		{
			//reading a prop file
			//user.dir:it will take the current path
			FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"//properties//config.properties");
			prop = new Properties();//create obj for prop //loading prop file
			prop.load(fileInputStream);//we can read the input stream
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void initialization()
	 {
		//this for reading the property
        String browserName = prop.getProperty("browser");//chrome
        
        
        if (browserName.equals("chrome")){
        	//loading the driver
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();		
    		options.addArguments("--remote-allow-origins=*");
    		
    		//creating object for chrome driver 
    	     driver = new ChromeDriver(options);
    	    driver.navigate().to(prop.getProperty("url"));
           driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
           driver.manage().window().maximize();
           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
           driver.manage().deleteAllCookies();
        }
}
}

