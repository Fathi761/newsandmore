package com.programmer.newsandmore.Fragment.WorldFragment.USA.BottomNavigation.Entertainment;

public class EntertainmentItem {

    public String entertainmentImageUrl;
    public String entertainmentTitle;
    public String entertainmentDesc;
    public String entertainmentUrl;
    public String entertainmentpublished;

    public EntertainmentItem(String entertainmentImageUrl, String entertainmentTitle, String entertainmentDesc, String entertainmentUrl, String entertainmentpublished) {
        this.entertainmentImageUrl = entertainmentImageUrl;
        this.entertainmentTitle = entertainmentTitle;
        this.entertainmentDesc = entertainmentDesc;
        this.entertainmentUrl = entertainmentUrl;
        this.entertainmentpublished = entertainmentpublished;
    }

    public String getEntertainmentImageUrl() { return entertainmentImageUrl; }

    public String getEntertainmentTitle() {
        return entertainmentTitle;
    }

    public String getEntertainmentDesc() {
        return entertainmentDesc;
    }

    public String getEntertainmentUrl() {
        return entertainmentUrl;
    }

    public String getEntertainmentpublished() {
        return entertainmentpublished;
    }
}
