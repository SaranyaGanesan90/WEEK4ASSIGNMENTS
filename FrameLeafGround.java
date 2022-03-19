package assignment.week4;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameLeafGround {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 driver.get("http://leafground.com/pages/frame.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
		List<WebElement> frameList=driver.findElements(By.tagName("iframe"));
		System.out.println(frameList.size());
		driver.switchTo().frame(0);
	
	
	
	
	driver.findElement(By.xpath("(//button[text()='Click Me'])[1]")).click();
	//int size = driver.findElements(By.tagName("iframe")).size();
	//System.out.println("Total Frames:" + size);
	//driver.switchTo().frame(0);
	}

}
