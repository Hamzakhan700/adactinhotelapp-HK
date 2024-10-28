package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SelectHotelPage {
    WebDriver driver;

    By selectHotelButton = By.id("radiobutton_1");
    By ContinueBtn= By.id("continue");

    public SelectHotelPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectHotel() {
        driver.findElement(selectHotelButton).click();
    }

    public void ClickContinue() {
        driver.findElement(ContinueBtn).click();
    }
}