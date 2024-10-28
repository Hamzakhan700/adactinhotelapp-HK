package stepDefinitions;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.*;
import com.aventstack.extentreports.*;

import java.io.FileReader;
import java.io.Reader;
import java.time.Duration;
import java.util.List;
import java.lang.reflect.Type;

public class HotelBookingSteps {
    private WebDriver driver;
    private LoginPage loginPage;
    private SearchHotelPage searchHotelPage;
    private SelectHotelPage selectHotelPage;
    private BookingPage bookingPage;
    private static ExtentReports extent;
    private static ExtentTest test;
    private List<TestCase> testCases;
    private String uName;
    private String pass;

    public HotelBookingSteps(){
        loatTestCases();
    }

    public void loatTestCases(){
        try (Reader reader = new FileReader("src/test/resources/testdata/testdata.json")) {
            Type testCaseListType = new TypeToken<List<TestCase>>() {}.getType();
            testCases = new Gson().fromJson(reader, testCaseListType);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Before
    public void setUp() {
        extent = new ExtentReports();
        test = extent.createTest("Hotel Booking Test");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        searchHotelPage = new SearchHotelPage(driver);
        selectHotelPage = new SelectHotelPage(driver);
        bookingPage = new BookingPage(driver);
    }

//    @Given("Loading test Data")
//    public void loadTestDat() {
//        driver.get("https://adactinhotelapp.com/");
//        test.info("Navigated to login page");
//    }

    @Given("the user is on the login page")
    public void userIsOnLoginPage() {
        driver.get("https://adactinhotelapp.com/");
        test.info("Navigated to login page");
    }

    @When("the user enters username through testData")
    public void userEntersCredentials() {
        loginPage.enterUsername(testCases.get(0).getUsername());
        loginPage.enterPassword(testCases.get(0).getPassword());
        loginPage.clickLogin();
        test.info("Entered credentials");
    }

    @Then("the user should be redirected to the search hotel page")
    public void userShouldBeOnSearchHotelPage() {
        Assert.assertTrue(driver.getTitle().contains("Search Hotel"));
        test.pass("User successfully redirected to search hotel page");
    }

    @When("the user enters {string}, {string}, and {string}")
    public void userEntersHotelDetails(String location, String checkin, String checkout) {
        searchHotelPage.enterLocation(location);
        searchHotelPage.enterCheckinDate(checkin);
        searchHotelPage.enterCheckoutDate(checkout);
        searchHotelPage.clickSearch();
        test.info("Entered hotel search details");
    }

    @Then("the user should see available hotels")
    public void userShouldSeeAvailableHotels() {
        Assert.assertTrue(driver.findElement(By.className("login_title")).isDisplayed());
        test.pass("Available hotels are displayed");
    }

    @When("the user selects a hotel")
    public void userSelectsHotel() {
        selectHotelPage.selectHotel();
        selectHotelPage.ClickContinue();
        test.info("Selected hotel");
    }

    @Then("the user should be redirected to the booking page")
    public void userShouldBeOnBookingPage() {
        Assert.assertTrue(driver.getTitle().contains("Book A Hotel"));
        test.pass("User successfully redirected to booking page");
    }
//    the user enters personal details and credit card information with name <name> , last name <lastName> , credit card <creditCard> , address <address> , credit card type <CreditCardType> , expiry Month <Expirymonth> , expiry year <Expiryyear> and CVV no <cvvnumber>
//    @When("the user enters personal details and credit card information with name {string} and credit card {string}")
    @When("the user enters personal details and credit card information with name {string} , last name {string} , credit card {string} , address {string} , credit card type {string} , expiry Month {string} , expiry year {string} and CVV no {string}")
    public void userEntersBookingDetails(String fullName, String LastName,String cardNumber,String address,String CreditCardType,String Expirymonth,String Expiryyear,String cvvnumber) {
        bookingPage.enterName(fullName);
        bookingPage.SetLastName(LastName);
        bookingPage.Setaddress(address);
        bookingPage.enterCreditCard(cardNumber);
        bookingPage.SetCreditCardType(CreditCardType);
        bookingPage.SetExpiryMonth(Expirymonth);
        bookingPage.SetExpiryYear(Expiryyear);
        bookingPage.SetCvvNumber(cvvnumber);
        bookingPage.clickBookNow();
        test.info("Entered booking details");
    }

    @Then("the booking confirmation should be displayed")
    public void bookingConfirmationShouldBeDisplayed() throws InterruptedException {
        //Assert.assertTrue(bookingPage.isConfirmationDisplayed());
        Thread.sleep(9000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        By btnCheck = By.id("my_itinerary");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(btnCheck));
        Assert.assertTrue(driver.getTitle().contains("Hotel Booking Confirmation"));
        test.pass("Booking confirmation displayed");
    }

    @After
    public void tearDown() {
        driver.quit();
        extent.flush();
    }


//    public void runAllTests() {
//        for (TestCase testCase : testCases) {
//            userIsOnLoginPage();
//            userEntersCredentials(testCase.getUsername(),testCase.getPassword());
//        }
//    }

}