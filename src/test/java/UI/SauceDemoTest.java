package UI;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

/** Тест на "SauceDemo"*/
public class SauceDemoTest extends BaseTest {

    @Test
    public void mock(){
        int first = 1;
        int second = 2;
        Assert.assertEquals(first + second,3);
    }
}
