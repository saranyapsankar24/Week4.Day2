package week4.day2;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundDropdowns {
	public static void main(String[] args) {
		//Open a chrome browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//Launch the url
		driver.get("http://www.leafground.com/pages/Dropdown.html");
		//Find the first dropdown
		WebElement dropdown1 = driver.findElement(By.id("dropdown1"));
		//Use the select class and select the dropdown value using Index
		Select dd1=new Select(dropdown1);
		dd1.selectByIndex(2);
		//Find the second dropdown
		WebElement dropdown2 = driver.findElement(By.name("dropdown2"));
		//Use the select class and select the dropdown value using text
		Select dd2=new Select(dropdown2);
		dd2.selectByVisibleText("UFT/QTP");
		//Find the third dropdown
		WebElement dropdown3 = driver.findElement(By.id("dropdown3"));
		//Use the select class and select the dropdown value using value
		Select dd3=new Select(dropdown3);
		dd3.selectByValue("4");

		//Find the fourth dropdown 
		WebElement dropdown4 = driver.findElement(By.xpath("//select[@class='dropdown']")); 
		//Get the number of dropdown options 
		Select dd4=new Select(dropdown4);
		List<WebElement>dropdown4Options=dd4.getOptions();
		System.out.println("Available options in Dropdown 4 are  : " +
				dropdown4Options); for (WebElement eachOptions : dropdown4Options) {
					System.out.println(eachOptions.getText());

				}

				//Select a value from dropdown using send keys
				driver.findElement(By.xpath("//div[@id='contentblock']/section[1]/div[5]/select[1]")).sendKeys("Selenium");
				//Find the sixth dropdown
				WebElement multiselectDropdown = driver.findElement(By.xpath("(//select)[6]"));
				Select dd6=new Select(multiselectDropdown);
				dd6.selectByValue("3");
				dd6.selectByValue("4");
				List<WebElement> selectedValues=dd6.getAllSelectedOptions();
				for (WebElement values : selectedValues) {
					System.out.println(values.getText());
				}

				//Close the browser
				driver.close();

	}

}
