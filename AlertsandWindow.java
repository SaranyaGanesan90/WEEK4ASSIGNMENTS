package assignment.week4;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertsandWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 driver.get("https://www.irctc.co.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Set<String> windowhandles = driver.getWindowHandles();
		List<String> windowhandlesList=new ArrayList<String>(windowhandles);

		//to print the total window handle number
		System.out.println("Total window number: " + windowhandlesList.size() + "\n");
		System.out.println(windowhandles);
		//switch to the second window
		driver.switchTo().window(windowhandlesList.get(0));
       driver.findElement(By.xpath("//button[text()='OK']")).click();
    driver.findElement(By.xpath(" (//label[text()='FLIGHTS'])[2]")) .click();
    ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
    //switch to new tab
    driver.switchTo().window(newTb.get(1));
		driver.findElement(By.xpath("//button[text()='Later']")).click();
	driver.findElement(By.linkText("Contact Us")).click();
	String print = driver.findElement(By.xpath("(//a[@class='dropdown-item'])[3]")).getText();
	System.out.println(print);
		
		
		
	}

}
