package com.jarvis;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.opencart.com/index.php?route=account/register");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		WebElement element=driver.findElement(By.id("input-country"));
		
		Select dropdown=new Select(element);
		
		dropdown.selectByIndex(16);
		
		Thread.sleep(5000);
		
		dropdown.selectByValue("7");
		
		Thread.sleep(5000);
		
		dropdown.selectByVisibleText("Bermuda");
		
	List<WebElement> allOptions= dropdown.getOptions();
	
	for(WebElement e:allOptions)
	{
		String str=e.getText();
		
		if(str.equals("Cyprus"))
		{
			e.click();
			break;
		}
	}
		
		
		
	}

}
