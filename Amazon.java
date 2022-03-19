package assignment.week4;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement element = driver.findElement(By.id("twotabsearchtextbox"));
		element.sendKeys("oneplus 9 pro");
		element.sendKeys(Keys.ENTER);
		String text = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
		System.out.println(text);
		String text2 = driver.findElement(By.xpath("(//span[@class='a-size-base s-underline-text'])[1]")).getText();
		System.out.println(text2);
		//String text3 = driver.findElement(By.xpath("(//a[contains(@title,'5 stars')])[3]")).getText();
		//System.out.println(text3);
		driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
		 ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
		    //switch to new tab
		    driver.switchTo().window(newTb.get(1));
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowhandlesList=new ArrayList<String>(windowHandles);
		driver.switchTo().window(windowhandlesList.get(1));
	 WebElement element2 = driver.findElement(By.xpath("(//span[@id='attach-accessory-cart-subtotal'])[1]"));
		
	//	WebElement starElement = driver.findElement(By.xpath("(//a[@role='button']//i)[2]"));
	//	Actions builder = new Actions(driver);
	//	builder.click(starElement).perform();
	//	WebElement ratingPercent = driver.findElement(By.linkText("55%"));
	//	String text4= ratingPercent.getText();
	//	System.out.println("Percentage for 5 star "+text4);
		String text4 = element2.getText();
		System.out.println(text4);
		String replaceAll = text4.replaceAll("['a-zA-Z?']", "");
		if(text.equals(replaceAll))
		{
			System.out.println("Price Equal");
		}
		
	}

		
	}


	
