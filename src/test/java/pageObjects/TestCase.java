package pageObjects;

public class TestCase {
    private String username;
    private String password;

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public void setUsername(String userName){
        this.username = userName;
    }

    public void setPassword(String password){
        this.password = password;
    }
}
