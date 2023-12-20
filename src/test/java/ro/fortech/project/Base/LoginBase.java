package ro.fortech.project.Base;

import ro.fortech.project.TestData.LoginAccount;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.time.Duration;

public class LoginBase {
    public static WebDriver driver1;
    public static String url = "http://localhost:3000/login";

    @BeforeMethod
    public void setUp() {
        String driverChrome = "webdriver.chrome.driver";
        String chromeDriverAddress = "C:\\Program Files\\Google\\Chrome\\Application\\chromedriver.exe";
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--no-sandbox");
        System.setProperty(driverChrome, chromeDriverAddress);

        driver1 = new ChromeDriver(chromeOptions);
        driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver1.get(url);
    }

    @DataProvider(name = "invalid-username")
    public Object[][] returnInvalidUserNameAccount(){
        return new Object[][] {
                {new LoginAccount(  "      ", "Test@1234567")}
        };
    }
}
