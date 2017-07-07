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

    @DataProvider(name = "TestData1")
    public Object[][] createData1() {
        return new Object[][]{
                {"testuser1@gmail.com", Boolean.TRUE},
                {"testuser2gmail.com", Boolean.FALSE},
                {"testuser3@yandex.com", Boolean.FALSE},
                {"testuser@@gmail.com", Boolean.FALSE}
        };
    }

    @DataProvider(name = "TestData2")
    public Object[][] createData2() {
        return new Object[][]{
                  {"testuser1@gmail.com", Boolean.TRUE},
                  {"testuser2yahoo.com", Boolean.FALSE},
                  {"testuser3@mail.com", Boolean.TRUE},
                  {"testuser@@gmail.com", Boolean.FALSE}
        };
    }

    @BeforeTest
    void setUp(){
        System.out.println("Created Object");
        myValidator = new Validator();

    }

    @Test(dataProvider = "TestData", description = "Test for Numbers Validation")
    void checkNumbers(String testString, Boolean expectedResult){
        System.out.println(testString);
        Assert.assertEquals( (Boolean) myValidator.numbers(testString), expectedResult,"Bad input " + testString);
    }

    @Test(dataProvider = "TestData1", description = "Test for Numbers Validation")
    void checkEmails(String testString, Boolean expectedResult){
        System.out.println(testString);
        Assert.assertEquals( (Boolean) myValidator.emails(testString), expectedResult,"Bad input " + testString);
    }

    @Test(dataProvider = "TestData2", description = "Test for yandex validation")
    void checkMailsReplace(String testString, Boolean expectedResult){
        Assert.assertEquals((Boolean) myValidator.testReplace(testString), expectedResult, "Bad input " + testString);
    }

    @AfterMethod
    void afterM(ITestResult testResult){
        System.out.println(testResult.isSuccess());
        System.out.println(testResult.getMethod().getDescription());
    }
}
