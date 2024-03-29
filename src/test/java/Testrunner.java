import org.apache.commons.configuration.ConfigurationException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class Testrunner {

    HRM user = new HRM();

    public Testrunner() throws IOException {
    }
    //    @Test(priority = 1 )

    @Test
    public void login() throws IOException, ConfigurationException {
        user.loginapi("salman@roadtocareer.net", "1234");
        String expected = "Login successfully";
        String actual = user.getMessage();
        Assert.assertEquals("Strings should be equal", actual, expected);
    }

    //    @Test(priority = 2 )
    @Test

    public void transactionlistapi() throws IOException, ConfigurationException {
        user.transactionlistapi();
        String expected = "Transaction list";
        String actual = user.getMessage();
        Assert.assertEquals("Strings should be equal", actual, expected);
    }

    //    @Test(priority = 3 )
    @Test

    public void createcus() throws IOException, ConfigurationException {
        user.createcus();
        String expected = "User created";
        Assert.assertEquals("Strings should be equal", user.getMessage(), expected);
    }

    //    @Test(priority = 4 )
    @Test

    public void createagent() throws IOException, ConfigurationException {
        user.createagent();
        String expected = "User created";
        Assert.assertEquals("Strings should be equal", user.getMessage(), expected);
    }

    //    @Test(priority = 5 )
    @Test

    public void depagent() throws IOException, ConfigurationException {
        String agentPhoneNumber = user.createagent();
        user.depagent(agentPhoneNumber);
        String expected = "Deposit successful";
        Assert.assertEquals("Strings should be equal", user.getMessage(), expected);
    }

    //    @Test(priority = 6 )
    @Test

    public void agtocut() throws IOException, ConfigurationException {
        String customerPhoneNumber = user.createcus();
        String agentPhoneNumber = user.createagent();
        user.agtocut(agentPhoneNumber, customerPhoneNumber);
        String expected = "Deposit successful";
        Assert.assertEquals("Strings should be equal", user.getMessage(), expected);
    }

    //    @Test(priority = 7 )
    @Test

    public void agbal() throws IOException, ConfigurationException {
        String agentPhoneNumber = user.createagent();
        user.agbal(agentPhoneNumber);
        String expected = "User balance";
        Assert.assertEquals("Strings should be equal", user.getMessage(), expected);
    }

    //    @Test(priority = 8 )
    @Test

    public void cusbal() throws IOException, ConfigurationException {
        String customerPhoneNumber = user.createcus();
        user.cusbal(customerPhoneNumber);
        String expected = "User balance";
        Assert.assertEquals("Strings should be equal", user.getMessage(), expected);
    }

    //    @Test(priority = 9 )
    @Test

    public void withdraw() throws IOException, ConfigurationException {
        String customerPhoneNumber = user.createcus();
        String agentPhoneNumber = user.createagent();
        user.withdraw(agentPhoneNumber, customerPhoneNumber);
        String expected = "Withdraw successful";
        Assert.assertEquals("Strings should be equal", user.getMessage(), expected);
    }

    //    @Test(priority = 10 )
    @Test
    public void cusbals() throws IOException, ConfigurationException {
        String customerPhoneNumber = user.createcus();
        user.cusbal(customerPhoneNumber);
        String expected = "User balance";
        Assert.assertEquals("Strings should be equal", user.getMessage(), expected);
    }
//    @Test(priority = 11 )
//@Test

//public void upnum() throws IOException, ConfigurationException {
//        String id = user.createcus();
//        user.upnum(id);
//        String expected = "User updated successfully";
//        Assert.assertEquals("Strings should be equal", user.getMessage(), expected);
//    }
}
