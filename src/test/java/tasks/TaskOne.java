package tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TaskOne {
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

        Thread.sleep(3000);

        //3.Locate to "email adress input box" and enter an email
        WebElement emailInputBox = driver.findElement(By.id("email_create"));
        emailInputBox.sendKeys("aliveli4950@gmail.com");

        //4. Click on Create an Account button.
        WebElement createAnAccountButton = driver.findElement(By.xpath("//button[@class='btn btn-default button button-medium exclusive']"));
        createAnAccountButton.click();

        Thread.sleep(5000);

        //5.Locate information input boxes and send information
        WebElement genderButton = driver.findElement(By.cssSelector("#id_gender1"));
        genderButton.click();
        WebElement firstNameInput = driver.findElement(By.id("customer_firstname"));
        firstNameInput.sendKeys("Ali");
        WebElement lastNameInput = driver.findElement(By.xpath("//*[@id='customer_lastname']"));
        lastNameInput.sendKeys("Veli");
        WebElement passwordInput = driver.findElement(By.id("passwd"));
        passwordInput.sendKeys("1234");
        WebElement dayButton = driver.findElement(By.id("days"));
        dayButton.click();
        //can not locate numbers of the days
        WebElement newsLetterChckBx = driver.findElement(By.cssSelector("[name='newsletter']"));
        Assert.assertFalse(newsLetterChckBx.isSelected(),"NewsLetter CheckBox is SELECTED");
        WebElement specialOfferChckBx = driver.findElement(By.id("optin"));
        Assert.assertFalse(specialOfferChckBx.isSelected(),"Special Offer Check Box is SELECTED");
        newsLetterChckBx.click();
        specialOfferChckBx.click();






    }
    @BeforeMethod
    public void openChromeBrowser(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();

    }


}
