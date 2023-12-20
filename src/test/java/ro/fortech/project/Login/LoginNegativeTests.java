package ro.fortech.project.Login;

import ro.fortech.project.Base.LoginBase;
import ro.fortech.project.Pages.Login.LoginPage;
import ro.fortech.project.TestData.LoginAccount;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginNegativeTests extends LoginBase {




    @Test(description = "Test user cannot login with invalid username", dataProvider = "invalid-username", dataProviderClass = LoginBase.class)
    public void testEmptyUsername(LoginAccount user) {
        LoginPage loginPage = new LoginPage(driver1);
        loginPage.loginAUser( user.getUserName(), user.getPassword());
        loginPage.submitLogForm();

        String expectedUrl = "http://localhost:3000/login";
        String actualUrl = driver1.getCurrentUrl();

        Assert.assertEquals(actualUrl, expectedUrl);
    }
}

