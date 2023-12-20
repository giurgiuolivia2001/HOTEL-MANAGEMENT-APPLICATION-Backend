package ro.fortech.project.Pages.Registration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

    private WebDriver driver;

    @FindBy(how = How.CSS, using = "input[type=text]:nth-child(2)")
    private WebElement firstNameInputField;

    @FindBy(how = How.CSS, using = "input[type=text]:nth-child(3)")
    private WebElement lastNameInputField;

    @FindBy(how = How.CSS, using = "input[type=text]:nth-child(4)")
    private WebElement userNameInputField;

    @FindBy(how = How.CSS, using = " input[type=email]:nth-child(5)")
    private WebElement emailInputField;

    @FindBy(how = How.CSS, using = "#password")
    private WebElement passwordInputField;

    @FindBy(how = How.ID, using = "confirm-password")
    private WebElement confirmPasswordInputField;

    @FindBy(how = How.CSS, using = "#root > div > div > button")
    private WebElement submitBtn;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void writeFirstName(String input) {
        firstNameInputField.sendKeys(input);
    }

    public void writeLastName(String input) {
        lastNameInputField.sendKeys(input);
    }

    public void writeUserName(String input) {
        userNameInputField.sendKeys(input);
    }

    public void writeEmail(String input) {
        emailInputField.sendKeys(input);
    }

    public void writePassword(String input) {
        passwordInputField.sendKeys(input);
    }

    public void writeConfirmPassword(String input) {
        confirmPasswordInputField.sendKeys(input);
    }

    public void registerANewUser(String firstName,
                                 String lastName,
                                 String userName,
                                 String email,
                                 String password,
                                 String confirmPassword) {
        writeFirstName(firstName);
        writeLastName(lastName);
        writeUserName(userName);
        writeEmail(email);
        writePassword(password);
        writeConfirmPassword(confirmPassword);
    }

    public void submitRegForm() {
        submitBtn.click();
    }
}
