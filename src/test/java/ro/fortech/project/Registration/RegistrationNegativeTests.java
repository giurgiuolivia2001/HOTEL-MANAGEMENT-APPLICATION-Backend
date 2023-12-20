package ro.fortech.project.Registration;

import ro.fortech.project.Base.RegistrationBase;
import ro.fortech.project.Pages.Registration.RegistrationPage;
import ro.fortech.project.TestData.UserAccount;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationNegativeTests extends RegistrationBase {

    @Test(description = "Test user cannot register with invalid first name", dataProvider = "invalid-firstname", dataProviderClass = RegistrationBase.class)
    public void testEmptyFirstname(UserAccount user) {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registerANewUser(user.getFirstName(), user.getLastName(), user.getUserName(), user.getEmail(), user.getPassword(), user.getConfirmPassword());
        registrationPage.submitRegForm();

        String expectedUrl = "http://localhost:3000/register";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl, expectedUrl);
    }
}


