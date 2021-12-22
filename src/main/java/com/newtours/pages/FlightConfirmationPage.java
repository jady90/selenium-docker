package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FlightConfirmationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//font[contains(text(), 'Flight Confirmation')]")
    private WebElement headerFlightConfirmation;

    @FindBy(xpath = "//font[contains(text(), 'USD')]")
    private List<WebElement> prices;

    @FindBy(linkText = "SIGN-OFF")
    private WebElement linkSignOff;

    public FlightConfirmationPage(WebDriver driver){
        this.driver = driver;
        this.wait =new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public String getPrice(){
        this.wait.until(ExpectedConditions.visibilityOf(this.headerFlightConfirmation));
        System.out.println(this.headerFlightConfirmation.getText());
        System.out.println(this.prices.get(1).getText());
        String price = this.prices.get(1).getText();
        this.linkSignOff.click();
        return price;
    }

}
