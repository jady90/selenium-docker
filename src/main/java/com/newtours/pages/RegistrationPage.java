package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class RegistrationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "firstName")
    private WebElement txtFirstName;

    @FindBy(name = "lastName")
    private WebElement txtLastName;

    @FindBy(name = "email")
    private  WebElement txtUsername;

    @FindBy(name = "password")
    private WebElement txtPassword;

    @FindBy(name = "confirmPassword")
    private WebElement txtConfirmPassword;

    @FindBy(name = "register")
    private WebElement btnSubmit;

    public RegistrationPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void goTo(){
        this.driver.get("https://vins-udemy.s3.amazonaws.com/docker/docker-book-flight.html");
        this.wait.until(ExpectedConditions.visibilityOf(this.txtFirstName));
    }

    public void enterUserDetails(String firstName, String lastName){
        this.txtFirstName.sendKeys(firstName);
        this.txtLastName.sendKeys(lastName);
    }

    public void enterUserCredentials(String username, String password){
        this.txtUsername.sendKeys(username);
        this.txtPassword.sendKeys(password);
        this.txtConfirmPassword.sendKeys(password);
    }

    public void submit(){
        this.btnSubmit.click();
    }
}
