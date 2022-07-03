package com.jarvis;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		String date="23";
		String month="sept";
		String year="2022";
		
		driver.findElement(By.id("onward_cal")).click(); //opens the date picker
		
		while(true)
		{
			String monthy=driver.findElement(By.xpath("//td[@class='monthTitle']")).getText();
			//System.out.println("monthyear is : "+monthy);
			String[] my=monthy.split(" ");
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
		
		List<WebElement> lisDates=driver.findElements(By.xpath("//table[@class='rb-monthTable first last']//td"));
		
		for(WebElement el:lisDates)
		{
			String dt=el.getText();
			
			if(dt.equals(date))
			{
				el.click();
				break;
			}
			
		}
		
	}

}
