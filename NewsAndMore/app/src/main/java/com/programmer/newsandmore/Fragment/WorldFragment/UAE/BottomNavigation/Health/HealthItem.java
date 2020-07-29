package com.programmer.newsandmore.Fragment.WorldFragment.UAE.BottomNavigation.Health;

public class HealthItem {

    public String healthImageUrl;
    public String healthTitle;
    public String healthDesc;
    public String healthUrl;
    public String healthpublished;


    public HealthItem(String healthImageUrl, String healthTitle, String healthDesc, String healthUrl, String healthpublished) {
        this.healthImageUrl = healthImageUrl;
        this.healthTitle = healthTitle;
        this.healthDesc = healthDesc;
        this.healthUrl = healthUrl;
        this.healthpublished = healthpublished;
    }


    public String getHealthImageUrl() {
        return healthImageUrl;
    }

    public String getHealthTitle() {
        return healthTitle;
    }

    public String getHealthDesc() {
        return healthDesc;
    }

    public String getHealthUrl() {
        return healthUrl;
    }

    public String getHealthpublished() {
        return healthpublished;
    }
}
