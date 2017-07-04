import MyCode.Validator;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class Tests {
    Validator myValidator;

    @DataProvider(name = "TestData")
    public Object[][] createData(){
        return new Object[][] {
                {"6000", Boolean.TRUE},
                {"6000,1", Boolean.FALSE},
                {"6000,10000", Boolean.TRUE},
                {"6000.10", Boolean.TRUE}
        };
    }

    @DataProvider(name = "EmailTest")
    public Object[][] emails() {
        return new Object[][]{
                {"testuser1@gmail.com", Boolean.TRUE},
                {"testuser2gmail.com", Boolean.FALSE},
                {"testuser3@yandex.com", Boolean.FALSE},
                {"testuser@@gmail.com", Boolean.FALSE}
        };
    }

    @BeforeTest
    void setUp(){
        System.out.println("Created Object");
        myValidator = new Validator();
    }

    @Test(dataProvider = "TestData", description = "Test for Numbers Validation")
    void Positive(String testString, Boolean expectedResult){
        System.out.println(testString);
        Assert.assertEquals( (Boolean) myValidator.numbers(testString), expectedResult,"Bad input " + testString);
    }

    @Test(dataProvider = "EmailTest", description = "Test for gmail validation")
    void checkMails(String mails, Boolean expectedResult){
        System.out.println(mails);
        Assert.assertEquals((Boolean) myValidator.emails(mails), expectedResult, "Done" + mails);
    }

    @AfterMethod
    void afterM(ITestResult testResult){
        System.out.println(testResult.isSuccess());
        System.out.println(testResult.getMethod().getDescription());
    }
}
