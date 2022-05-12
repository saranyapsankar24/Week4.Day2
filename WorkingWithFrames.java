package week4.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingWithFrames {
	public static void main(String[] args) {
		//Open a chrome browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		//switching to first frame 
		driver.switchTo().frame("frame1");
		//Enter some text in the frame 1 text box
		driver.findElement(By.xpath("//b[text()='Topic :']/following-sibling::input")).sendKeys("We are in frame one");
		//Switch to Frame 3
		driver.switchTo().frame("frame3");
		//Select the checkbox
		driver.findElement(By.id("a")).click();
		//Verify whether the check box is selected ot not
		if(driver.findElement(By.id("a")).isSelected()) {
			System.out.println("Check box inside frame 3 is selected");
		}
		//Switch back to the main page
		driver.switchTo().defaultContent();
		//Switch to frame 2
		driver.switchTo().frame("frame2");
		System.out.println(driver.findElement(By.xpath("//b[text()='Animals :']")).getText());
		driver.findElement(By.id("animals")).sendKeys("Big Baby Cat");
		//Close the browser
		driver.close();

	}

}
