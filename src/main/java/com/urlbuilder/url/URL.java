package com.urlbuilder.url;

import java.util.HashMap;

public class URL {
    private String protocol;
    private String domainName;
    private String landingPage;
    private String source;
    private String medium;
    private String campaignName;
    private String utmParamPrefix;
    public boolean isSearchCampaign;
    private HashMap<String, String> customParameters;

    public HashMap<String, String> getCustomParameters() {
        return customParameters;
    }

    public void setCustomParameters(HashMap<String, String> customParameters) {
        this.customParameters = customParameters;
    }

    public boolean isSearchCampaign() {return isSearchCampaign;}

    public void setSearchCampaign(boolean searchCampaign) {
        isSearchCampaign = searchCampaign;
    }

    public String getUtmParamPrefix() {
        return utmParamPrefix;
    }

    public void setUtmParamPrefix(String utmParamPrefix) {
        this.utmParamPrefix = utmParamPrefix;
    }

    public String getCustomParamPrefix() {
        return customParamPrefix;
    }

    public void setCustomParamPrefix(String customParamPrefix) {
        this.customParamPrefix = customParamPrefix;
    }

    public String getFullUrl() {
        return fullUrl;
    }

    public void setFullUrl(String fullUrl) {
        this.fullUrl = fullUrl;
    }

    private String customParamPrefix;
    private String fullUrl;

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getLandingPage() {
        return landingPage;
    }

    public void setLandingPage(String landingPage) {
        this.landingPage = landingPage;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

}
