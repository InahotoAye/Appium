package Appium.SampleMavenProjectAppium;


import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;



public class AppiumBasics extends BaseTestClass{
	@Test
	public void WifiSettingName() throws MalformedURLException
	{
		
		
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		String Actualtext =driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(Actualtext, "WiFi settings");
		driver.findElement(By.id("android:id/edit")).sendKeys("HelloTesting");
		driver.findElement(By.id("android:id/button1")).click();
		
		
	
	}

}
