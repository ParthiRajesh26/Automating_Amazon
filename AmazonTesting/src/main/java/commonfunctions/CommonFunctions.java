package commonfunctions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class CommonFunctions {

	public static WebDriver driver=null;

	public static Properties properties=null;
	
	static org.apache.log4j.Logger logger=org.apache.log4j.Logger.getLogger(CommonFunctions.class);
	
	

	public Properties configProperties() throws IOException {

		FileInputStream fileInputStream=new FileInputStream("Config.properties");
		properties=new Properties();
		properties.load(fileInputStream);

		return properties;



	}

	@BeforeSuite
	public void OpenBrowser() throws IOException {
		
	PropertyConfigurator.configure("log4j.properties");
	
	logger.info("initializing the Amazon Web Application");
	
	logger.info("Getting Config property files");
	
	configProperties();


		String browser = properties.getProperty("browser");
		String url =properties.getProperty("url");


		if (browser.equalsIgnoreCase("chrome")) {

			logger.info("Opening the Chrome Browser");
			driver=new ChromeDriver();

		} else if(browser.equalsIgnoreCase("firefox")){
             
			logger.info("Opening the Firefox browser");
			driver=new FirefoxDriver();
		}

		
		driver.manage().window().maximize();
		
		logger.info("Hitting The Amazon site");
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}

	@AfterSuite
	public void closeBrowser() {
		
		logger.info("TearDown the Browser");
		
	//	driver.close();

	}



}
