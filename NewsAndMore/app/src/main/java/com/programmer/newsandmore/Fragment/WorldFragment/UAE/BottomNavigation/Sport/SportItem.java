package com.programmer.newsandmore.Fragment.WorldFragment.UAE.BottomNavigation.Sport;

public class SportItem {

    public String sportImageUrl;
    public String sportTitle;
    public String sportDesc;
    public String sportUrl;
    public String sportPublished;

    public SportItem(String sportImageUrl, String sportTitle, String sportDesc, String sportUrl, String sportPublished) {
        this.sportImageUrl = sportImageUrl;
        this.sportTitle = sportTitle;
        this.sportDesc = sportDesc;
        this.sportUrl = sportUrl;
        this.sportPublished = sportPublished;
    }


    public String getSportImageUrl() {
        return sportImageUrl;
    }

    public String getSportTitle() {
        return sportTitle;
    }

    public String getSportDesc() {
        return sportDesc;
    }

    public String getSportUrl() {
        return sportUrl;
    }

    public String getSportPublished() {
        return sportPublished;
    }
}
