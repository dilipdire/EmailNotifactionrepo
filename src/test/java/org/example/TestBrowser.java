package org.example;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBrowser {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		// WebDriverManager.firefoxdriver().setup();
		ChromeOptions opts = new ChromeOptions();
		// driver = new FirefoxDriver();
		opts.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(opts);
		driver.get("https://www.google.com/");
	}

	@Test(priority = 1)
	public void printTitle() {

		String title = driver.getTitle();
		System.out.println(title);
	}

	@Test(priority = 2)
	public void dubleClick() {
		WebElement doubleclick = driver.findElement(By.id("APjFqb"));

		Actions act = new Actions(driver);
		act.doubleClick(doubleclick).perform();
		List<WebElement> allEle = driver.findElements(By.xpath("//*[contains(@class,'OBMEnb')]/ul/li"));

		try {
			for (WebElement ele : allEle) {
				String items = ele.getText();
				System.out.println(items);

				if (items.equalsIgnoreCase("broadcom vmware layoffs")) {

					ele.click();
				}
			}
			driver.navigate().refresh();
		} catch (StaleElementReferenceException sere) {
			sere.printStackTrace();
		}
	}

	@AfterMethod
	public void tearDown() {
		// driver.close();
	}

}
