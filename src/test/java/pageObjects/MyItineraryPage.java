package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyItineraryPage {
    public WebDriver driver;

    By logoutButton = By.xpath("//a[text()='Logout']");

    public MyItineraryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLogout() {
        driver.findElement(logoutButton).click();
    }
}