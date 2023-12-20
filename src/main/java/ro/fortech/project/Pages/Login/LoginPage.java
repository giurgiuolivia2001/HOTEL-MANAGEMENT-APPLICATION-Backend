package ro.fortech.project.Pages.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
public class LoginPage {

    private WebDriver driver1;


    @FindBy(how = How.CSS, using = "input[type=text]:nth-child(2)")
    private WebElement userNameInputField;


    @FindBy(how = How.CSS, using = "input[type=password]:nth-child(3)")
    private WebElement passwordInputField;


    @FindBy(how = How.CSS, using = "#root > div > div > button")
    private WebElement submitBtn;

    public LoginPage(WebDriver driver1) {
        this.driver1 = driver1;
        PageFactory.initElements(driver1, this);
    }


    public void writeUserName(String input) {
        userNameInputField.sendKeys(input);
    }


    public void writePassword(String input) {
        passwordInputField.sendKeys(input);
    }


    public void loginAUser(
            String userName,
            String password) {

        writeUserName(userName);
        writePassword(password);

    }

    public void submitLogForm() {
        submitBtn.click();
    }

}

