import org.apache.commons.configuration.ConfigurationException;
import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;

public class Testrunner {

    HRM user = new HRM();

    public Testrunner() throws IOException {
    }

    @Test
    public void login() throws IOException, ConfigurationException {
        user.loginapi("salman@roadtocareer.net", "1234");
        String expected = "Login successfully";
        String actual = user.getMessage();
        Assert.assertEquals("Strings should be equal", actual, expected);
    }
    @Test
    public void transactionlistapi() throws IOException, ConfigurationException {
        user.transactionlistapi();
        String expected = "Transaction list";
        String actual = user.getMessage();
        Assert.assertEquals("Strings should be equal", actual, expected);
    }
    @Test
    public void createcus() throws IOException, ConfigurationException {
        user.createcus();
        String expected = "User created";
        String actual = user.getMessage();
        Assert.assertEquals("Strings should be equal", actual, expected);
    }
    @Test
    public void createagent() throws IOException, ConfigurationException {
        user.createagent();
        String expected = "User created";
        Assert.assertEquals("Strings should be equal", user.getMessage(), expected);
    }
//    @Test
//    public void upnum() throws IOException, ConfigurationException {
//        user.upnum();
//        String expected = "User updated successfully";
//        Assert.assertEquals("Strings should be equal", user.getMessage(), expected);
//    }
    @Test
    public void depagent() throws IOException, ConfigurationException {
        user.depagent("");
        String expected = "Deposit successful";
        Assert.assertEquals("Strings should be equal", user.getMessage(), expected);
    }
    @Test
    public void agtocut() throws IOException, ConfigurationException {
        String customerPhoneNumber = user.createcus();
        String agentPhoneNumber = user.createagent();
        user.agtocut(agentPhoneNumber,customerPhoneNumber);
        String expected = "Deposit successful";
        Assert.assertEquals("Strings should be equal", user.getMessage(), expected);
    }
    @Test
    public void agbal() throws IOException, ConfigurationException {
        String agentPhoneNumber = user.createagent();
        user.agbal(agentPhoneNumber);
        String expected = "User balance";
        Assert.assertEquals("Strings should be equal", user.getMessage(), expected);
    }
    @Test
    public void cusbal() throws IOException, ConfigurationException {
        String customerPhoneNumber = user.createcus();
        user.cusbal(customerPhoneNumber);
        String expected = "User balance";
        Assert.assertEquals("Strings should be equal", user.getMessage(), expected);
    }
    @Test
    public void withdraw() throws IOException, ConfigurationException {
        String customerPhoneNumber = user.createcus();
        String agentPhoneNumber = user.createagent();
        user.withdraw(agentPhoneNumber,customerPhoneNumber);
        String expected = "Withdraw successful";
        Assert.assertEquals("Strings should be equal", user.getMessage(), expected);
    }
}
