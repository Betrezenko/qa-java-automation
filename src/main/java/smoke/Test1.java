package smoke;

import org.testng.annotations.Test;

public class Test1 {

    @Test (groups = {"smokeTest", "regress"})
    public void test1() {
        System.out.println("test 1");
    }

    @Test (groups = {"regress"})
    public void test11() {
        System.out.println("test 11");
    }

    @Test (groups = {"regress"})
    public void test111() {
        System.out.println("test 111");
    }

}
