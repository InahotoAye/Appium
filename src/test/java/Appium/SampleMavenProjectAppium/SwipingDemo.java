package Appium.SampleMavenProjectAppium;


import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;



public class SwipingDemo extends BaseTestClass{
	@Test
	public void SwipingGesture() throws MalformedURLException, InterruptedException
	{
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='1. Photos']")).click();
		
		WebElement imagesFocused = driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
		
		swipingGestureAction(imagesFocused,"left");
		
		Thread.sleep(3000);
	}

}
