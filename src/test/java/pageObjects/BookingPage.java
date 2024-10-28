package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookingPage {
    WebDriver driver;

    By name = By.id("first_name");
    By lastname = By.id("last_name");
    By Address = By.id("address");
    By Credit_Card_Type = By.id("cc_type");
    By Expiry_month  = By.id("cc_exp_month");
    By Expiry_year  = By.id("cc_exp_year");
    By cvv_number  = By.id("cc_cvv");
    By creditCard = By.id("cc_num");
    By bookNowButton = By.id("book_now");
    By confirmationMessage = By.id("confirmation");

    public BookingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterName(String fullName) {
        driver.findElement(name).sendKeys(fullName);
    }
    public void SetLastName(String LastName) {
        driver.findElement(lastname).sendKeys(LastName);
    }
    public void Setaddress(String address) {
        driver.findElement(Address).sendKeys(address);
    }
    public void SetCreditCardType(String CreditCardType) {
        driver.findElement(Credit_Card_Type).sendKeys(CreditCardType);
    }
    public void SetExpiryMonth(String Expirymonth) {
        driver.findElement(Expiry_month).sendKeys(Expirymonth);
    }
    public void SetExpiryYear(String Expiryyear) {
        driver.findElement(Expiry_year).sendKeys(Expiryyear);
    }
    public void SetCvvNumber(String cvvnumber) {
        driver.findElement(cvv_number).sendKeys(cvvnumber);
    }
    public void enterCreditCard(String cardNumber) {
        driver.findElement(creditCard).sendKeys(cardNumber);
    }

    public void clickBookNow() {
        driver.findElement(bookNowButton).click();
    }

    public boolean isConfirmationDisplayed() throws InterruptedException {
        Thread.sleep(5000);
        return driver.findElement(confirmationMessage).isDisplayed();
    }
}