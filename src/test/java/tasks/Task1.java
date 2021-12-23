package tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task1 {
    /*  I randomly selected this case from https://www.techlistic.com/2020/06/automate-ecommerce-website.html ,
    the website recommended by our mentor. We can change it, if you like.
     */
    /*
    1. Test Case - Automate User Registration process of e-commerce website.

    Steps to Automate:
    1. Open this url  http://automationpractice.com/index.php
    2. Click on sign in link.
    3. Enter your email address in 'Create and account' section.
    4. Click on Create an Account button.
    5. Enter your Personal Information, Address and Contact info.
    6. Click on Register button.
    7. Validate that user is created.
     */

    WebDriver driver;
    @Test
    public  void test1() throws InterruptedException {
        //1.Navigate to url:  http://automationpractice.com/index.php
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();

        //2.Locate to "sign in" link and click
        WebElement signInButton = driver.findElement(By.cssSelector(".login"));
        signInButton.click();

        //It takes some time so it will be better to wait for 2 seconds
        Thread.sleep(2000);

        //Enter your email address in 'Create and account' section.
       // WebElement emailBox = driver.findElement(By.cssSelector("#email_create"));
       // emailBox.sendKeys("bkuysal@yahoo.com");

        //3.Locate to "email adress input box" and enter an email
        WebElement emailInputBox = driver.findElement(By.id("email_create"));
        emailInputBox.sendKeys("aliveli4950@gmail.com");

        //Click to create account button
        driver.findElement(By.id("SubmitCreate")).click();
        Thread.sleep(2000);


    }
    @BeforeMethod
    public void openChromeBrowser(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();

        //nice work!
        //new added from onur
        //another function
    }


}
