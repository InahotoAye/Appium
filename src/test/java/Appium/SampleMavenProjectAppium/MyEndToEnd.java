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



public class MyEndToEnd extends BaseTestClass{
	@Test
	public void SwipingGesture() throws MalformedURLException, InterruptedException
	{
		
		driver.findElement(AppiumBy.accessibilityId("App")).click();
		driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
		driver.findElement(By.xpath("//android.widget.Button[@content-desc='OK Cancel dialog with a message']")).click();
		driver.findElement(By.id("android:id/button1")).click();
		Thread.sleep(2000);
		driver.findElement(AppiumBy.accessibilityId("Repeat alarm")).click();
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Every Wednesday']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("android:id/button1")).click();
		
		
	}

}
