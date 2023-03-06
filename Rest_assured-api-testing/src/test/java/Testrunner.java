import org.apache.commons.configuration.ConfigurationException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class Testrunner {

    @Test
    public void login() throws IOException, ConfigurationException {
        HRM user = new HRM();
        user.loginapi("salman@roadtocareer.net", "1234");
        String expected = "Login successfully";
        String actual = user.getMessage();
        Assert.assertEquals("Strings should be equal", actual, expected);
    }
    @Test
    public void transactionlistapi() throws IOException {
        HRM user = new HRM();
        String expected = "Transaction list";
        String actual = user.getMessage();
        Assert.assertEquals("Strings should be equal", actual, expected);
    }
    @Test
    public void createcus() throws IOException {
        HRM user = new HRM();
        String expected = "User created";
        String actual = user.getMessage();
        Assert.assertEquals("Strings should be equal", actual, expected);
    }
    @Test
    public void createagent() throws IOException {
        HRM user = new HRM();
        String expected = "User created";
        Assert.assertEquals("Strings should be equal", user.getMessage(), expected);
    }
    @Test
    public void upnum() throws IOException {
        HRM user = new HRM();
        String expected = "User updated successfully";
        Assert.assertEquals("Strings should be equal", user.getMessage(), expected);
    }
    @Test
    public void depagent() throws IOException {
        HRM user = new HRM();
        String expected = "Deposit successful";
        Assert.assertEquals("Strings should be equal", user.getMessage(), expected);
    }
    @Test
    public void agtocut() throws IOException {
        HRM user = new HRM();
        String expected = "Deposit successful";
        Assert.assertEquals("Strings should be equal", user.getMessage(), expected);
    }
    @Test
    public void agbal() throws IOException {
        HRM user = new HRM();
        String expected = "User balance";
        Assert.assertEquals("Strings should be equal", user.getMessage(), expected);
    }
    @Test
    public void cusbal() throws IOException {
        HRM user = new HRM();
        String expected = "User balance";
        Assert.assertEquals("Strings should be equal", user.getMessage(), expected);
    }
    @Test
    public void withdraw() throws IOException {
        HRM user = new HRM();
        String expected = "Withdraw successful";
        Assert.assertEquals("Strings should be equal", user.getMessage(), expected);
    }
}
