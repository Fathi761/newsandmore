package com.programmer.newsandmore.Fragment.WorldFragment.USA.BottomNavigation.Technology;

public class TechnologyItem {
    private String technologyImageUrl;
    private String technologyTitle;
    private String technologyDesc;
    private String technologyUrl;
    private String technologyPublished;

    public TechnologyItem(String imageUrl, String title, String desc, String url, String published) {
        technologyImageUrl = imageUrl;
        technologyTitle = title;
        technologyDesc = desc;
        technologyUrl = url;
        technologyPublished = published;
    }

    public String getTechnologyImageUrl() {
        return technologyImageUrl;
    }

    public String getTechnologyTitle() {
        return technologyTitle;
    }

    public String getTechnologyDesc() {
        return technologyDesc;
    }

    public String getTechnologyUrl() {
        return technologyUrl;
    }

    public String getTechnologyPublished() {
        return technologyPublished;
    }
}
