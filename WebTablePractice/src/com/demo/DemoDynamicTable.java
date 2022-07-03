package com.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoDynamicTable {

	public static void main(String[] args) {
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://money.rediff.com/gainers");
		
		driver.manage().window().maximize();
		
		String str=driver.findElement(By.xpath("//div[@id='leftcontainer']/table/tbody/tr[8]/td[4]")).getText();
		System.out.println("current price is"+str);

	}

}
