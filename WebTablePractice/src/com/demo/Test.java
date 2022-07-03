package com.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		String baseUrl = "http://demo.guru99.com/test/newtours/";
		WebDriver driver = new ChromeDriver();

		driver.get(baseUrl);
		String innerText = driver.findElement(By.xpath("//font[contains(text(),'York to Chicago')]")).getText();		
		System.out.println("Text on table is:"+innerText); 
		
		//driver.quit();

	}

}
