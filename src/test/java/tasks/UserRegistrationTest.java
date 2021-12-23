package tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

public class UserRegistrationTest {


  /*  1. Test Case - Automate User Registration process of e-commerce website.
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

    @BeforeMethod
    public void startBrowser(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @Test
    public void signIn(){
        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.xpath("//*[@class='login']")).click();
        WebElement emailBox=driver.findElement(By.cssSelector("#email_create"));
        emailBox.sendKeys("benjamin2955@gmail.com");
        driver.findElement(By.cssSelector("#SubmitCreate>span")).click();
    }
















}









