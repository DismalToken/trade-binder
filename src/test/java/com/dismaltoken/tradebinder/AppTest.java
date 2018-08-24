package com.dismaltoken.tradebinder;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AppTest {
    @Test
    public void noArgConstructorTest() {
        App app = new App();
        Assert.assertNotNull(app);
    }
}
