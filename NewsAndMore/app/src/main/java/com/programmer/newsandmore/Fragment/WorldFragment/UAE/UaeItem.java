package com.programmer.newsandmore.Fragment.WorldFragment.UAE;

public class UaeItem {
    private String uaeImageUrl;
    private String uaeTitle;
    private String uaeDesc;
    public String uaeUrl;
    public String uaePublished;

    public UaeItem(String imageUrl, String title, String desc, String url, String published) {
        uaeImageUrl = imageUrl;
        uaeTitle = title;
        uaeDesc = desc;
        uaeUrl = url;
        uaePublished = published;
    }

    public String getUaeImageUrl() {
        return uaeImageUrl;
    }

    public String getUaeTitle() {
        return uaeTitle;
    }

    public String getUaeDesc() {
        return uaeDesc;
    }

    public String getUaeUrl() {
        return uaeUrl;
    }

    public String getUaePublished() {
        return uaePublished;
    }
}
