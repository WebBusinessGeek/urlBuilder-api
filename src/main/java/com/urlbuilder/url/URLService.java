package com.urlbuilder.url;

import org.apache.tomcat.jni.Error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class URLService {
    @Autowired
    private URLCreationLogic urlCreationLogic;

    public String createUrl(URL url) {
        return urlCreationLogic.createHREF(url);
    }
}
