package com.demo;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoDyanamicWebTable {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://datatables.net/examples/advanced_init/dt_events.html");
		
		driver.manage().window().maximize();
		
		int pageMaxSize=driver.findElements(By.cssSelector("div#example_paginate>span>a")).size();
		
		System.out.println("pages are:"+pageMaxSize);
		
		ArrayList<String> names=new ArrayList<String>();
		
		for(int i=1;i<pageMaxSize;i++)
		{
			String pageselector="div#example_paginate>span>a:nth-child("+i+")";
			
			driver.findElement(By.cssSelector(pageselector)).click();
			
			List<WebElement> elements=driver.findElements(By.cssSelector("table#example>tbody>tr>td:nth-child(1)"));
			
			for(WebElement e:elements)
			{
				names.add(e.getText());
			}
			for(String name:names)
			{
				System.out.println(name);
			}
		}
		
		System.out.println("ArrayList size is:"+names.size());
		for(String name:names)
		{
			System.out.println(name);
		}
	}

}
