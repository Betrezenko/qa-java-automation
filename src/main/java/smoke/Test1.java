package smoke;

import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test1 {

    @Test (retryAnalyzer = Retry.class)
    public void test1() {
        System.out.println("test 1 ");
        Assert.fail();
    }

}

