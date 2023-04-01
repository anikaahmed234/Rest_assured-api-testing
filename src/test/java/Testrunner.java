import org.apache.commons.configuration.ConfigurationException;
import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;

public class Testrunner {

    HRM user = new HRM();
    public Testrunner() throws IOException {
    }

    @Test(priority = 1)
    public void login() throws IOException, ConfigurationException {
        user.loginapi("salman@roadtocareer.net", "1234");
        String expected = "Login successfully";
        String actual = user.getMessage();
        Assert.assertEquals("Strings should be equal", actual, expected);
    }
    @Test(priority = 2)
    public void transactionlistapi() throws IOException, ConfigurationException {
        user.transactionlistapi();
        String expected = "Transaction list";
        String actual = user.getMessage();
        Assert.assertEquals("Strings should be equal", actual, expected);
    }
    @Test(priority = 3)
    public void createcus() throws IOException, ConfigurationException {
        user.createcus();
        String expected = "User created";
        String actual = user.getMessage();
        Assert.assertEquals("Strings should be equal", actual, expected);
    }
    @Test(priority = 4)
    public void createagent() throws IOException, ConfigurationException {
        user.createagent();
        String expected = "User created";
        Assert.assertEquals("Strings should be equal", user.getMessage(), expected);
    }
    @Test(priority = 5)
    public void upnum() throws IOException, ConfigurationException {
        user.upnum();
        String expected = "User updated successfully";
        Assert.assertEquals("Strings should be equal", user.getMessage(), expected);
    }
    @Test(priority = 8)
    public void depagent() throws IOException, ConfigurationException {
        user.depagent();
        String expected = "Deposit successful";
        Assert.assertEquals("Strings should be equal", user.getMessage(), expected);
    }
    @Test(priority = 9)
    public void agtocut() throws IOException, ConfigurationException {
        user.agtocut();
        String expected = "Deposit successful";
        Assert.assertEquals("Strings should be equal", user.getMessage(), expected);
    }
    @Test(priority = 6)
    public void agbal() throws IOException, ConfigurationException {
        user.agbal();
        String expected = "User balance";
        Assert.assertEquals("Strings should be equal", user.getMessage(), expected);
    }
    @Test(priority = 7)
    public void cusbal() throws IOException, ConfigurationException {
        user.cusbal();
        String expected = "User balance";
        Assert.assertEquals("Strings should be equal", user.getMessage(), expected);
    }
    @Test(priority = 10)
    public void withdraw() throws IOException, ConfigurationException {
        user.withdraw();
        String expected = "Withdraw successful";
        Assert.assertEquals("Strings should be equal", user.getMessage(), expected);
    }
}
