package com.programmer.newsandmore.Fragment.WorldFragment.Egypt;

public class EgyptItem {
    private String egyptImageUrl;
    private String egyptTitle;
    private String egyptDesc;
    private String egyptUrl;
    private String egyptPublished;

    public EgyptItem(String imageUrl, String title, String desc, String url, String published) {
        egyptImageUrl = imageUrl;
        egyptTitle = title;
        egyptDesc = desc;
        egyptUrl = url;
        egyptPublished = published;
    }

    public String getEgyptImageUrl() {
        return egyptImageUrl;
    }

    public String getEgyptTitle() {
        return egyptTitle;
    }

    public String getEgyptDesc() {
        return egyptDesc;
    }

    public String getEgyptUrl() {
        return egyptUrl;
    }

    public String getEgyptPublished() {
        return egyptPublished;
    }
}
