package com.amazon.tests;

import com.amazon.utilities.Assertions;
import com.amazon.utilities.BrowserFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import static com.amazon.utilities.Assertions.verifyEquals;

public class ChromeTest {
    public static void main(String[] args) throws InterruptedException {



        WebDriver driver= BrowserFactory.getDeriver("chrome");
        driver.get("https://www.google.com");

        String googleTitle =driver.getTitle();
        System.out.println("googleTitle = " + googleTitle);

        Thread.sleep(2000);

        driver.get("https://www.amazon.com");
        String amazonTitle = driver.getTitle();
        System.out.println("amazonTitle = " + amazonTitle);

        Thread.sleep(2000);

        driver.navigate().back();

       // String title3 = driver.getTitle();

       verifyEquals(driver.getTitle(),googleTitle);         //  --> Assertions classı

        Thread.sleep(2000);

        driver.navigate().forward(); // amazon
        driver.navigate().refresh();  // amazon

        verifyEquals(driver.getTitle(),amazonTitle);

        Thread.sleep(2000);

        driver.close();

    }
}
