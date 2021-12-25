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

        Thread.sleep(2000);

        //2.Locate to "sign in" link and click
        WebElement signInButton = driver.findElement(By.cssSelector(".login"));
        signInButton.click();

     //   Thread.sleep(3000);

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
        passwordInput.sendKeys("12345");
        WebElement dayButton = driver.findElement(By.id("days"));
        dayButton.click();
        //can not locate numbers of the days
        WebElement newsLetterChckBx = driver.findElement(By.cssSelector("[name='newsletter']"));
        Assert.assertFalse(newsLetterChckBx.isSelected(),"NewsLetter CheckBox is SELECTED");
        WebElement specialOfferChckBx = driver.findElement(By.id("optin"));
        Assert.assertFalse(specialOfferChckBx.isSelected(),"Special Offer Check Box is SELECTED");
        newsLetterChckBx.click();
        specialOfferChckBx.click();
        WebElement companyName = driver.findElement(By.id("company"));
        companyName.sendKeys("Apple");
        WebElement addressInput1 = driver.findElement(By.id("address1"));
        addressInput1.sendKeys("5. street No:5 Apple Co. 5689 PB");
        WebElement addresInput2 = driver.findElement(By.cssSelector("#address2"));
        addresInput2.sendKeys("5.floor");
        WebElement cityInput = driver.findElement(By.xpath("//*[@id='city']"));
        cityInput.sendKeys("San Fransisco");
        WebElement postCode = driver.findElement(By.id("postcode"));
        postCode.sendKeys("456124");
        WebElement mobilePhone = driver.findElement(By.cssSelector("#phone_mobile"));
        mobilePhone.sendKeys("+905555555555");
        WebElement registerButton = driver.findElement(By.xpath("//span[text()='Register']"));
        registerButton.click();
        WebElement errorMessage = driver.findElement(By.cssSelector("div[class='alert alert-danger']"));
        System.out.println("errorMessage.getText() = " + errorMessage.getText());
        WebElement passwordBox = driver.findElement(By.id("passwd"));
        Assert.assertEquals(passwordBox.getText(), "", "password box is NOT empty");
        driver.findElement(By.id("postcode")).clear();
        driver.findElement(By.id("postcode")).sendKeys("45612");
        passwordBox.sendKeys("123456");
        driver.findElement(By.xpath("//span[text()='Register']")).click();
        System.out.println("driver.findElement(By.cssSelector(\"div[class='alert alert-danger']\")).getText() = " + driver.findElement(By.cssSelector("div[class='alert alert-danger']")).getText());


    }
    @BeforeMethod
    public void openChromeBrowser(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();

    }
    @Test
    public void test2(){
        driver.get("https://google.com");
    }


}
