package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {
	public static void main(String[] args) throws InterruptedException {
		//Open a chrome browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		//Load the URL: http://leaftaps.com/opentaps/control/main
		driver.get("http://leaftaps.com/opentaps/control/login");
		//Enter Username as Demosalesmanager
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		//Enter Password as crmsfa
		driver.findElement(By.name("PASSWORD")).sendKeys("crmsfa");
		//Click on  Login Button
		driver.findElement(By.className("decorativeSubmit")).click(); 
		//Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();
		//Click on contacts Button
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		//Click on Merge Contacts using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		//Click on Widget of From Contact
		driver.findElement(By.xpath("//input[@id='partyIdFrom']//following::a[1]")).click();
		//Get the first window
		String parentWindow = driver.getWindowHandle();
		//Handle multiple windows
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles);
		//Convert set into list to interact  with the second window
		List<String> totalWindowList=new ArrayList<String>(windowHandles);
		String newWIndow=totalWindowList.get(1);
		driver.switchTo().window(newWIndow);
		//Click on First Resulting Contact
		//driver.findElement(By.xpath("//input[@name='id']")).sendKeys("Test");
		driver.findElement(By.xpath("//table[@class='x-grid3-row-table']//tr[1]//td[1]//a")).click();
		//Switch back to the parent window
		driver.switchTo().window(parentWindow);
		// Click on Widget of To Contact
		driver.findElement(By.xpath("//input[@id='partyIdTo']//following::a[1]")).click();
		//Get the current window
		String parentWindow2 = driver.getWindowHandle();
		//Handle multiple window
		Set<String> childWindow = driver.getWindowHandles();
		//Convert set into list to interact  with the second window
		List<String> toContactWindows=new ArrayList<String>(childWindow);
		//Get the new window
		String toContactChildWindow=toContactWindows.get(1);
		//Switch to the new window
		driver.switchTo().window(toContactChildWindow);
		//Click on Second Resulting Contact
		driver.findElement(By.xpath("(//table[@class='x-grid3-row-table'])[2]//tr[1]//td[1]//a")).click();
		//Switch to the parent window
		driver.switchTo().window(parentWindow2);
		//Click on Merge button using Xpath Locator
		driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
		//Accept the Alert
		Alert alert = driver.switchTo().alert();
		alert.accept();
		//Verify the title of the page
		System.out.println("Page title is " + driver.getTitle());
		if(driver.getTitle().contains("View Contact")) {
			System.out.println("The merge of two contacts was successful");
		}
		//Close all the browsers
		driver.quit();


	}

}
