package com.demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		driver.manage().window().maximize();
		
		List<WebElement> helements=driver.findElements(By.xpath("//table[@id='customers']/tbody/tr/th"));
		System.out.println("no of hrows are:"+helements.size());
		
		List<WebElement> relements=driver.findElements(By.xpath("//table[@id='customers']/tbody/tr"));
		System.out.println("no of rows are:"+relements.size());
		
		
		for (WebElement webElement : helements) 
		{
			String htext=webElement.getText();
			System.out.println(htext);
				
		}
		
		for (WebElement webElement : relements) 
		{
			/*String rtext=webElement.getText();
			System.out.println(rtext);*/
			
			String text=webElement.getText();
			if(text.equals("Island"))
			{
			System.out.println(text);
			}
			
			
			
		}
		
	}

}
