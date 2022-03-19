package assignment.week4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameChercher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	WebElement frameElement = driver.findElement(By.id("frame1"));
	
	
	driver.switchTo().frame(frameElement);
	
	driver.findElement(By.xpath("//input")).sendKeys("Hello world");
	driver.switchTo().defaultContent();
WebElement frameElement2 = driver.findElement(By.id("frame2"));
	
	
	driver.switchTo().frame(frameElement2);
	
	
	WebElement drop = driver.findElement(By.id("animals"));
	Select dd = new Select(drop);
	dd.selectByVisibleText("Avatar");
	driver.switchTo().defaultContent();
	
//	int size = driver.findElements(By.tagName("iframe")).size();
//	System.out.println("Total Frames:" + size);
	//driver.switchTo().frame(0);
	// System.out.println (driver.findElement(By.id("frame1")).getText());

WebElement frameElement3 = driver.findElement(By.id("frame3"));
	
	
	driver.switchTo().frame(frameElement3);
	
	driver.findElement(By.xpath("//input[@type='checkbox']")).click();
	
	}

}
