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
    /**
     * it should remove a single leading forward slash
     */
    public void removeLeadingForwardSlashesA() {
        URLCreationLogic testInstance = new URLCreationLogic();
        String mockLeadingForwardSlash = "/something/something";
        String expected = "something/something";
        String actual = testInstance.removeLeadingForwardSlashes
                (mockLeadingForwardSlash);
        Assert.assertEquals(expected, actual);
    }

    @Test
    /**
     * it should remove all leading forward slashes
     */
    public void removeLeadingForwardSlashesB() {
        URLCreationLogic testInstance = new URLCreationLogic();
        String mockLeadingForwardSlash = "///something/something";
        String expected = "something/something";
        String actual = testInstance.removeLeadingForwardSlashes
                (mockLeadingForwardSlash);
        Assert.assertEquals(expected, actual);
    }

    @Test
    /**
     * it should remove a single trailing forward slash
     */
    public void removeTrailingForwardSlashesA() {
        URLCreationLogic testInstance = new URLCreationLogic();
        String mockLeadingForwardSlash = "something/something/";
        String expected = "something/something";
        String actual = testInstance.removeTrailingForwardSlashes
                (mockLeadingForwardSlash);
        Assert.assertEquals(expected, actual);
    }

    @Test
    /**
     * it should remove all trailing forward slashes
     */
    public void removeTrailingForwardSlashesB() {
        URLCreationLogic testInstance = new URLCreationLogic();
        String mockLeadingForwardSlash = "something/something///";
        String expected = "something/something";
        String actual = testInstance.removeTrailingForwardSlashes
                (mockLeadingForwardSlash);
        Assert.assertEquals(expected, actual);
    }

}
