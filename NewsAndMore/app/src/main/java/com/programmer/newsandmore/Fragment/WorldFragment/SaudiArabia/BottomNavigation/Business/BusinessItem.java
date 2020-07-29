package com.programmer.newsandmore.Fragment.WorldFragment.SaudiArabia.BottomNavigation.Business;

public class BusinessItem {

    public String businessImageUrl;
    public String businessTitle;
    public String businessDesc;
    public String businessUrl;
    public String businessPublished;

    public BusinessItem(String businessImageUrl, String businessTitle, String businessDesc, String businessUrl, String businessPublished) {
        this.businessImageUrl = businessImageUrl;
        this.businessTitle = businessTitle;
        this.businessDesc = businessDesc;
        this.businessUrl = businessUrl;
        this.businessPublished = businessPublished;
    }


    public String getBusinessImageUrl() {
        return businessImageUrl;
    }

    public String getBusinessTitle() {
        return businessTitle;
    }

    public String getBusinessDesc() {
        return businessDesc;
    }

    public String getBusinessUrl() {
        return businessUrl;
    }

    public String getBusinessPublished() {
        return businessPublished;
    }
}
