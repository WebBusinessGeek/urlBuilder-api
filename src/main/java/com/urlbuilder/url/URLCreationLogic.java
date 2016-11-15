package com.urlbuilder.url;

import org.springframework.stereotype.Component;
import java.util.HashMap;

@Component
public class URLCreationLogic {
    final String BACKSLASH = "/";

    public String createHREF(URL url) {
        return removeEndBackslash(createOrigin(url))
                + BACKSLASH
                + removeFrontBackslash(createPathname(url))
                + createSearchParams(url)
                + createCustomParams(url);
    }

    public String createOrigin(URL url) {
        final String PROTOCOL_DELIMITER = "://";
        return url.getProtocol()
                + PROTOCOL_DELIMITER
                + url.getDomainName();
    }

    public String createPathname(URL url) {
        return url.getLandingPage();
    }

    public String createSearchParams(URL url) {
        final String DYNAMIC_SEARCH_PARAMETER = "{term}";
        final String UTM_SOURCE = "source";
        final String UTM_MEDIUM = "medium";
        final String UTM_CAMPAIGN_NAME = "campaign";
        final String UTM_TERM = "term";

        String search = "?";
        if(url.getSource() != null) {
            search += createUTMParam(url, UTM_SOURCE, url.getSource());
        }
        if(url.getMedium() != null) {
            search +=  createUTMParam(url, UTM_MEDIUM, url.getMedium());
        }
        if(url.getCampaignName() != null) {
            search += createUTMParam(url, UTM_CAMPAIGN_NAME, url.getCampaignName());
        }
        if(url.isSearchCampaign) {
            search += createUTMParam(url, UTM_TERM, DYNAMIC_SEARCH_PARAMETER);
        }
        return search;
    }

    public String createUTMParam(URL url, String paramKey, String paramValue) {
        final String DEFAULT_UTM_PARAM_PREFIX = "utm_";
        final String UTM_PAIR_DELIMETER = "&";
        final String PARAMETER_DELIMITER = "=";

        String utmParamPrefix = (url.getUtmParamPrefix() == null)
                ? DEFAULT_UTM_PARAM_PREFIX
                : url.getUtmParamPrefix();

        return UTM_PAIR_DELIMETER
                + utmParamPrefix
                + paramKey
                + PARAMETER_DELIMITER
                + paramValue;
    }

    public String createCustomParams(URL url) {
        String customParams = "";
        if(url.getCustomParameters() != null) {
            HashMap<String, String> params = url.getCustomParameters();
            for(String key : params.keySet()) {
                customParams += createUTMParam(url, key, params.get(key));
            }
        }
        return customParams;
    }

    public String removeEndBackslash(String removeFrom) {
        String lastChar = removeFrom.substring(removeFrom.length() - 1);
        if(lastChar.equals(BACKSLASH)) {
            return removeFrom.substring(0, removeFrom.length() - 1);
        }
        return removeFrom;
    }

    public String removeFrontBackslash(String removeFrom) {
        String firstChar = removeFrom.substring(0, 1);
        if(firstChar.equals(BACKSLASH)) {
            return removeFrom.substring(1, removeFrom.length());
        }
        return removeFrom;
    }
}
