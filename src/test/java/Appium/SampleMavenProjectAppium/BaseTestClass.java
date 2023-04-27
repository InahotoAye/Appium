package Appium.SampleMavenProjectAppium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;
		
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
		
public class BaseTestClass {
		
public AndroidDriver driver;
public AppiumDriverLocalService service;
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException
	{		
				//Starting the Appium server
							
				service = new AppiumServiceBuilder().withAppiumJS(new File
				("C://Users//inahoto//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
				service.start();
				
				//Configuration Mobile app details
						
				UiAutomator2Options options = new UiAutomator2Options();
				options.setDeviceName("Pixel3a");
				
				//options.setApp("c://Users//inahoto//eclipse-workspace//SampleMavenProjectAppium//src//test//java//resources//ApiDemos-debug.apk");
				options.setApp("c://Users//inahoto//eclipse-workspace//SampleMavenProjectAppium//src//test//java//resources//General-Store.apk");
				driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				 	
				
	}					
			
			
	public void longPressAction(WebElement ele) {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) ele).getId(),"duration", 2000 ));
		
	}	
		
	//using Do while loop to scroll continuously till the end
	public void scrollTillEnd()
	{	
		boolean canScrollMore;
		do {		
		 canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			    "left", 100, "top", 100, "width", 200, "height", 200,
			    "direction", "down",
			    "percent", 3.0
			));			
		 			
		}while(canScrollMore);
					
	}				
					
	public void swipingGestureAction(WebElement imagesFocused, String direction) 
	{				
		
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement)imagesFocused).getId(),
			    "direction", direction,
			    "percent", 0.75 
			));
		
	}	
	
	public Double getFormatedAmount(String StringAmount) 
	{
		double ActualPrice = Double.parseDouble(StringAmount.substring(1));
		return ActualPrice;
		
	}
		
	@AfterClass
	public void TearDown() {
		//Quieting app and Stoping Appium server
				driver.quit();
				service.stop();
	}
	
}
