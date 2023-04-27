package Appium.SampleMavenProjectAppium;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class Ecommerce_EndToEnd extends BaseTestClass{
	
	
	@Test
	public void FillingForms() throws InterruptedException
	{
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		Thread.sleep(2000);
		//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Inahoto Aye");
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(2000);
		String toastMessage= driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		System.out.println(toastMessage);
		Assert.assertEquals(toastMessage, "Please enter your name");
		
	}
	
	

}
