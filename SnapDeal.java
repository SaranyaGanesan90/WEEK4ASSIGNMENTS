package assignment.week4;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		 WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement mensfashion = driver.findElement(By.xpath("(//span[@class='catText'])[1]"));
		Actions builder=new Actions(driver);
		builder.moveToElement(mensfashion).perform();
		
		driver.findElement(By.xpath("(//span[@class='linkTest'])[1]")).click();
		String count = driver.findElement(By.xpath("//span[@class='category-name category-count']")).getText();
		System.out.println(count);
		driver.findElement(By.xpath("(//div[@class='child-cat-name '])[2]")).click();
driver.findElement(By.xpath("//div[@class='sort-selected']")).click();
	

	/*List<WebElement> beforefilterprice = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
	// extract the prices from the price elements and store in a List	
	List<Integer> beforefilterpriceList = new ArrayList<Integer>();
		for (WebElement p : beforefilterprice)
		{
			//replace the RS value and convert it into integer and store it in list
			beforefilterpriceList.add(Integer.valueOf(p.getText().replace("Rs","")));
		}

		
		driver.findElement(By.xpath("//li[@data-sorttype='plth']")).click();
		Thread.sleep(3000);
		List<WebElement> afterfilterprice = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));

		List<Integer> afterfilterpriceList = new ArrayList<Integer>();
		
		for (WebElement p : afterfilterprice)
		{
	
			//replace the RS value and convert it into integer and store it in list
			afterfilterpriceList.add(Integer.valueOf(p.getText().replace("Rs","")));
			
		}
		
	//	compare the values (first we need to sort the values of beforefilter price)
		Collections.sort(beforefilterpriceList);//sort the values in the list 
		if(afterfilterpriceList.equals(beforefilterpriceList))
				{
			System.out.println("Low to High");
				}
		else
		{
			System.out.println("High to Low");
			
		}*/
List<WebElement> shoesPrice = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
List<Integer> val=new ArrayList<Integer>();
for (int i = 0; i < shoesPrice.size(); i++) {
	String text = shoesPrice.get(i).getText();
	//System.out.println(text);
	String replaceAll = text.replaceAll("\\D", "");
	//System.out.println(replaceAll);
	int parseInt = Integer.parseInt(replaceAll);
	//System.out.println(parseInt);
	val.add(parseInt);
}

System.out.println(val);
Collections.sort(val);
System.out.println(val);
driver.findElement(By.xpath("//li[@data-sorttype='plth']")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("//label[@for='Color_s-Navy']")).click();
Thread.sleep(2000);
WebElement findElement2 = driver.findElement(By.xpath("(//img[@class='product-image wooble'])[1]"));
builder.moveToElement(findElement2).perform();
Thread.sleep(2000);
driver.findElement(By.xpath("(//div[contains(@class,'center quick-view-bar')])[1]")).click();
Thread.sleep(2000);
String text = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
System.out.println("The discount price is "+text);

File screenshot= driver.getScreenshotAs(OutputType.FILE);


  

// Create an image file to store the screen shot
File image = new File("./snaps/sanpdeal.jpg");
// Merging temp screenshot and image file together
FileUtils.copyFile(screenshot, image);
driver.quit();



}


		
}



