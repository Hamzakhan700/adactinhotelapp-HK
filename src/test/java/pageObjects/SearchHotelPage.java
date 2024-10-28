package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchHotelPage {
    WebDriver driver;

    By location = By.id("location");
    By checkin = By.id("datepick_in");
    By checkout = By.id("datepick_out");
    By searchButton = By.id("Submit");

    public SearchHotelPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterLocation(String loc) {
        driver.findElement(location).sendKeys(loc);
    }

    public void enterCheckinDate(String date) {
        driver.findElement(checkin).sendKeys(date);
    }

    public void enterCheckoutDate(String date) {
        driver.findElement(checkout).sendKeys(date);
    }

    public void clickSearch() {
        driver.findElement(searchButton).click();
    }
}
