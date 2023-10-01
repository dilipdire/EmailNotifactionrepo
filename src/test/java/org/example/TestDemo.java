package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.*;


public class TestDemo {


   public static WebDriver driver ;

   @BeforeMethod
   public void setUp()
   {
	    WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-popup-blocking");

      
        driver.get("https://www.google.com/");
    }


    @Test
    public void test1()
    {
    	String title = driver.getTitle();
        System.out.println(title);
    }


    @AfterMethod
    public void tearDown()
    {
    //  driver.close();
    }
}
