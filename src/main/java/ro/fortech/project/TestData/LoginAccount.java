package ro.fortech.project.TestData;
public class LoginAccount {



    public String getUserName() {
        return userName;
    }



    public String getPassword() {
        return password;
    }



    private String userName;
    private String password;


    public LoginAccount(
            String userName,
            String password) {

        this.userName = userName;
        this.password = password;

    }
}

