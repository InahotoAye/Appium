package Appium.SampleMavenProjectAppium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.functions.ExpectedCondition;

public class Ecommerce_EndToEnd3 extends BaseTestClass{
	
	
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
		// Clicking on Add to Cart twice for adding 2 products
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		//Waiting until the cart page is fully loaded.
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")),"text","Cart"));
		
		// fetching the prices of 2 product and Sum up.
		List<WebElement> ProductPrices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		int Countprice = ProductPrices.size();
		double SumPrice =0;
		for(int i=0;i<Countprice;i++) 
		{
			String StringAmount = ProductPrices.get(i).getText();
			double ActualPrice = Double.parseDouble(StringAmount.substring(1));
			SumPrice = SumPrice + ActualPrice; //160.97+120 =280.97
		}
		
		String TotalPurchaseAmount = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		Double ActualTotalPurchaseAmount = getFormatedAmount(TotalPurchaseAmount);
		
		// Validation with Assertion 
		Assert.assertEquals(SumPrice, ActualTotalPurchaseAmount);
		
		
		// Performing Long Press and then selecting Proceed to Buy Option
		
		WebElement ele = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		longPressAction(ele);
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(2000);	
		
		
	}
}
