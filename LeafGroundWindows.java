package week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundWindows {
	public static void main(String[] args) throws InterruptedException {
		//Open a chrome browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//Load the URL: http://www.leafground.com/pages/Window.html
		driver.get("http://www.leafground.com/pages/Window.html");
		//Click on Open Home Page button
		driver.findElement(By.id("home")).click();
		//Get the parent window
		String parentWindow = driver.getWindowHandle();
		//Handle multiple windows
		Set<String> totalNumberOfWindows = driver.getWindowHandles();
		//Convert the set into list
		List<String> totalWindows=new ArrayList<String>(totalNumberOfWindows);
		//Get the child window
		String childWindow=totalWindows.get(1);
		//Switch to the child window
		driver.switchTo().window(childWindow);
		//Get the page title
		System.out.println("Child window page title is  " +  driver.getTitle());
		driver.close();
		driver.switchTo().window(parentWindow);
		System.out.println("Parent window page title is  " + driver.getTitle());
		System.out.println("************************************************************");
		//Find the total number of opened windows
		driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowsList=new ArrayList<String>(windowHandles);
		System.out.println("Total number of opened windows are : " + windowsList.size());
		System.out.println("**************************************************************");
		//To close all the child windows
		driver.findElement(By.xpath("//button[text()='Do not close me ']")).click();
		List<String> windowlist=new ArrayList<String>(driver.getWindowHandles());
		for(int i=driver.getWindowHandles().size()-1;i>=1;i--) {
			driver.switchTo().window(windowlist.get(i)).close();
		}
		driver.switchTo().window(windowlist.get(0));
		System.out.println(driver.getTitle());
		//click on the button and wait for 5 seconds to see there are more windows opened
		driver.findElement(By.id("color")).click();
		Thread.sleep(5000);
		List<String> windowsOpened =new ArrayList<String>(driver.getWindowHandles());
		System.out.println("Number of windows opened after 5 seconds are : " + windowsOpened.size());
		//Close all the browsers
		driver.quit();


	}

}
