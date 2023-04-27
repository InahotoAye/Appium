package Appium.SampleMavenProjectAppium;


import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;



public class MiscellanousAppiumTopics extends BaseTestClass{
	@Test
	public void Miscellanous() throws MalformedURLException
	{
		
		
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		
		//Landscape mode.
		DeviceRotation landscape = new DeviceRotation(0,0,90);
		driver.rotate(landscape);
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		String Actualtext =driver.findElement(By.id("android:id/alertTitle")).getText();
		
		Assert.assertEquals(Actualtext, "WiFi settings");
		driver.setClipboardText("Hello testing clipboard test");
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
		//Key events...
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.findElement(By.id("android:id/button1")).click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		
		
		
	
	}

}
