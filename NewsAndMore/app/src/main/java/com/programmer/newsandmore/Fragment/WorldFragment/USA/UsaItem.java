package com.programmer.newsandmore.Fragment.WorldFragment.USA;

public class UsaItem {
    private String usaImageUrl;
    private String usaTitle;
    private String usaDesc;
    private String usaUrl;
    private String usaPublished;

    public UsaItem(String imageUrl, String title, String desc, String url, String published) {
        usaImageUrl = imageUrl;
        usaTitle = title;
        usaDesc = desc;
        usaUrl = url;
        usaPublished = published;
    }

    public String getUsaImageUrl() {
        return usaImageUrl;
    }

    public String getUsaTitle() {
        return usaTitle;
    }

    public String getUsaDesc() {
        return usaDesc;
    }

    public String getUsaUrl() {
        return usaUrl;
    }

    public String getUsaPublished() {
        return usaPublished;
    }
}
