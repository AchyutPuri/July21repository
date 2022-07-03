package com.demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoDatePicker {

	public static void main(String[] args) {

    WebDriverManager.chromedriver().setup();
    WebDriver driver=new ChromeDriver();
    driver.get("https://www.goibibo.com");
    
    driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[2]/div[2]/div[1]/div[1]/div[3]/div[1]/p[1]/span[1]")).click();
    
    while(!driver.findElement(By.xpath("//div[@class='DayPicker-Caption']/div")).getText().contains("October"))
    {
       driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[2]/div[2]/div[1]/div[1]/div[3]/div[2]/div[2]/div[1]/div[1]/div[1]/span[2]")).click();
	}

   List<WebElement> elements= driver.findElements(By.xpath("//div[@class='DayPicker-Body']/div/div[@class='DayPicker-Day']"));
   
   System.out.println("size of aaraylist is:"+elements.size());
   
   int count=elements.size();
   
   for(int i=0;i<count;i++)
   {
	   String datetext=driver.findElements(By.xpath("//div[@class='DayPicker-Body']/div/div[@class='DayPicker-Day']")).get(i).getText();
	   
	   System.out.println("datetext is:"+datetext);
	   if(datetext.equalsIgnoreCase("2"))
	   {
		   driver.findElements(By.xpath("//div[@class='DayPicker-Body']/div/div[@class='DayPicker-Day']")).get(i).click();
		   break;
	   }
	}
    }
}
