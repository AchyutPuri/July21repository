package com.jarvis;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		String date="12";
		String month="dec";
		String year="2022";
		
		driver.findElement(By.id("onward_cal")).click(); //click on date picker
		
		while(true)
		{
			String monthyear=driver.findElement(By.xpath("//td[@class='monthTitle']")).getText();
			String[] my=monthyear.split(" ");
			String m=my[0];
			String y=my[1];
			
			if(m.equalsIgnoreCase(month) && y.equals(year))
			{
				break;
			}
			
			else
			{
				driver.findElement(By.xpath("//tbody/tr[1]/td[3]")).click();
			}
		}
		
		List<WebElement> datelist=driver.findElements(By.xpath("//table[@class='rb-monthTable first last']//td"));
		
		for(WebElement e:datelist)
		{
			String d=e.getText();
			if(d.equals(date))
			{
				e.click();
				break;
			}
		}
	}

}
