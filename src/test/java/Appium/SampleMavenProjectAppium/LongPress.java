package Appium.SampleMavenProjectAppium;


import java.net.MalformedURLException;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


import io.appium.java_client.AppiumBy;



public class LongPress extends BaseTestClass{
	@Test
	public void LongPressGesture() throws MalformedURLException, InterruptedException
	{
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Expandable Lists']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='1. Custom Adapter']")).click();
		WebElement element = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		longPressAction(element);
		Thread.sleep(3000);
		
		String peopleTextActual = driver.findElement(By.xpath("//android.widget.TextView[@text='Sample menu']")).getText();
		Assert.assertEquals(peopleTextActual, "Sample menu");
		Assert.assertTrue(driver.findElement(By.xpath("//android.widget.TextView[@text='Sample menu']")).isDisplayed());
		
		
		
		
	}

}
