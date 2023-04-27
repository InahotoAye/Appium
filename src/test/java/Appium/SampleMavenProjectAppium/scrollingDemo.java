package Appium.SampleMavenProjectAppium;


import java.net.MalformedURLException;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


import io.appium.java_client.AppiumBy;



public class scrollingDemo extends BaseTestClass{
	@Test
	public void ScrollingDemoTest() throws MalformedURLException, InterruptedException
	{
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		//We can use this scrolling when we know where to scroll exactly
		//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Visiblity\"));"));
		scrollTillEnd();
		
		Thread.sleep(3000);
		
		
	}

}
