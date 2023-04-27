package Appium.SampleMavenProjectAppium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.functions.ExpectedCondition;

public class Ecommerce_EndToEnd2 extends BaseTestClass{
	
	
	@Test
	public void FillingForms() throws InterruptedException
	{
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Inahoto Aye");
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(2000);
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan Lift Off\"));"));
		int productCount =driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		
		
		for(int i=0;i<productCount;i++) 
		{
			String productname = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			if(productname.equalsIgnoreCase("Jordan Lift Off"))
			{
				driver.findElement(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).click();
			}
		}
		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(2000);
		
		//Wait until the Cart page is fully loaded.
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")),"text","Cart"));
		
		
		//verifying if the product is added to cart page.
		//String CartPageProducts = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
		//Assert.assertEquals(CartPageProducts, "Air Jordan 9 Retro");
		
		
	}
	
	
	
}
