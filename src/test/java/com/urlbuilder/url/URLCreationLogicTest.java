package com.urlbuilder.url;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class URLCreationLogicTest {

    private URLCreationLogic testInstance;

    @Before
    /**
     * ensure test instance available in each test.
     */
    public void instantiateClassUnderTest() {
        testInstance = new URLCreationLogic();
    }

    @Test
    /**
     * it should remove a single leading forward slash
     */
    public void removeLeadingForwardSlashesA() {
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
        String mockLeadingForwardSlash = "something/something///";
        String expected = "something/something";
        String actual = testInstance.removeTrailingForwardSlashes
                (mockLeadingForwardSlash);
        Assert.assertEquals(expected, actual);
    }

    @Test
    /**
     * it should add a single custom parameter
     */
    public void createCustomParamsA() {
        HashMap<String, String> fakeParam
                = new HashMap<String, String>();
        fakeParam.put("someParamKey", "someParamValue");

        URL url = new URL(
                "http",
                "www.example.com",
                "/some-landing",
                "facebook",
                "ads",
                "some-campaign",
                null,
                true,
                fakeParam
        );

        String expected = "&utm_someParamKey=someParamValue";
        String actual = testInstance.createCustomParams(url);
        Assert.assertEquals(expected, actual);
    }

    @Test
    /**
     * it should add multiple custom parameters
     */
    public void createCustomParamsB() {
        HashMap<String, String> fakeParams
                = new HashMap<String, String>();
        fakeParams.put("someParamKey", "someParamValue");
        fakeParams.put("someParamKey2", "someParamValue2");
        fakeParams.put("someParamKey3", "someParamValue3");

        URL url = new URL(
                "http",
                "www.example.com",
                "/some-landing",
                "facebook",
                "ads",
                "some-campaign",
                null,
                true,
                fakeParams
        );

        String expected
                = "&utm_someParamKey3=someParamValue3"
                        + "&utm_someParamKey2=someParamValue2"
                        + "&utm_someParamKey=someParamValue";

        String actual = testInstance.createCustomParams(url);
        Assert.assertEquals(expected, actual);
    }

    @Test
    /**
     * it should add custom UTM prefix delimiter if its present
     */
    public void createUTMParamA() {
        URL url = new URL(
                "http",
                "www.example.com",
                "/some-landing",
                "facebook",
                "ads",
                "some-campaign",
                "custom_",
                true,
                null
        );

        String expected = "&custom_source=facebook";
        String actual = testInstance.createUTMParam(url, "source", url
                .getSource());
        Assert.assertEquals(expected, actual);
    }

    @Test
    /**
     * it should add default UTM prefix delimiter if custom one not present.
     */
    public void createUTMParamB() {
        URL url = new URL(
                "http",
                "www.example.com",
                "/some-landing",
                "facebook",
                "ads",
                "some-campaign",
                null,
                true,
                null
        );

        String expected = "&utm_source=facebook";
        String actual = testInstance.createUTMParam(url, "source", url
                .getSource());
        Assert.assertEquals(expected, actual);
    }
}
