package com.urlbuilder.url;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class URLCreationLogicTest {

    @Test
    public void sample() {
        int expected = 1;
        int actual = 1;
        Assert.assertEquals(expected, actual);
    }

    @Test
    /**
     * it should remove leading forward slash
     */
    public void removeLeadingForwardSlashA() {
        URLCreationLogic testInstance = new URLCreationLogic();
        String mockLeadingForwardSlash = "/something/something";
        String expected = "something/something";
        String actual = testInstance.removeLeadingForwardSlash
                (mockLeadingForwardSlash);
        Assert.assertEquals(expected, actual);
    }

}
