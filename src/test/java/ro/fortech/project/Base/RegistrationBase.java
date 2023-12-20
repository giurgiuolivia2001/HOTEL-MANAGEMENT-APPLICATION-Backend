package ro.fortech.project.Base;

import ro.fortech.project.TestData.UserAccount;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.time.Duration;

public class RegistrationBase {
    public static WebDriver driver;
    public static String url = "http://localhost:3000/register";

    @BeforeMethod
    public void setUp() {
        String driverChrome = "webdriver.chrome.driver";
        String chromeDriverAddress = "C:\\Program Files\\Google\\Chrome\\Application\\chromedriver.exe";
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--no-sandbox");
        System.setProperty(driverChrome, chromeDriverAddress);

        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.get(url);
    }

    @DataProvider(name = "invalid-firstname")
    public Object[][] returnInvalidFirstNameAccount(){
        return new Object[][] {
                {new UserAccount("    ", "Popescu","WhitespacePopescu", "username@yopmail.com", "Test@1234567", "Test@1234567")}
        };
    }
}
