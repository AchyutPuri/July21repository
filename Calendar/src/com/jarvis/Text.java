package com.jarvis;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Text {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		String monthy="December 2022";
		String date="12";
		driver.get("https://phptravels.net/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		
	   driver.findElement(By.id("departure")).click();
	   
	   while(true)
	   {
		   String my=driver.findElement(By.xpath("//body[1]/div[7]/div[1]/table[1]/thead[1]/tr[1]/th[2]")).getText();
		   System.out.println(my);
		   
		   if(monthy.equals(my))
		   {
			   break;
		   }
		   else
		   {
			   driver.findElement(By.xpath("//body[1]/div[7]/div[1]/table[1]/thead[1]/tr[1]/th[3]/i[1]")).click();
		   }
	   }
	   
	   List<WebElement> list=driver.findElements(By.xpath("//table/tbody/tr/td"));
	   
     for(WebElement e:list)
     {
    	 String str=e.getText();
    	 if(date.equals(str))
    	 {
    		 e.click();
    	 }
    	 
     }
	
	}

}
