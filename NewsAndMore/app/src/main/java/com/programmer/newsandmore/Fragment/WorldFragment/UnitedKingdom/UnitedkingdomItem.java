package com.programmer.newsandmore.Fragment.WorldFragment.UnitedKingdom;

public class UnitedkingdomItem {

    private String unitedKingdomImageUrl;
    private String unitedKingdomTitle;
    private String unitedKingdomDesc;
    private String unitedKingdomUrl;
    private String unitedKingdomPublished;

    public UnitedkingdomItem(String imageUrl, String title, String desc, String url, String published) {
        unitedKingdomImageUrl = imageUrl;
        unitedKingdomTitle = title;
        unitedKingdomDesc = desc;
        unitedKingdomUrl = url;
        unitedKingdomPublished = published;
    }

    public String getUnitedKingdomImageUrl() {
        return unitedKingdomImageUrl;
    }

    public String getUnitedKingdomTitle() {
        return unitedKingdomTitle;
    }

    public String getUnitedKingdomDesc() {
        return unitedKingdomDesc;
    }

    public String getUnitedKingdomUrl() {
        return unitedKingdomUrl;
    }

    public String getUnitedKingdomPublished() {
        return unitedKingdomPublished;
    }
}
