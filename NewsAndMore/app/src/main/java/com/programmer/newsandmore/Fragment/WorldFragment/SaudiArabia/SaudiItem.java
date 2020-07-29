package com.programmer.newsandmore.Fragment.WorldFragment.SaudiArabia;

public class SaudiItem {
    private String saudiImageUrl;
    private String saudiTitle;
    private String saudiDesc;
    private String saudiUrl;
    private String saudiPublished;

    public SaudiItem(String saudiImageUrl, String saudiTitle, String saudiDesc, String saudiUrl, String saudiPublished) {
        this.saudiImageUrl = saudiImageUrl;
        this.saudiTitle = saudiTitle;
        this.saudiDesc = saudiDesc;
        this.saudiUrl = saudiUrl;
        this.saudiPublished = saudiPublished;
    }

    public String getSaudiImageUrl() {
        return saudiImageUrl;
    }

    public String getSaudiTitle() {
        return saudiTitle;
    }

    public String getSaudiDesc() {
        return saudiDesc;
    }

    public String getSaudiUrl() {
        return saudiUrl;
    }

    public String getSaudiPublished() {
        return saudiPublished;
    }
}
