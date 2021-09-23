package com.example.successsynergyapp.model;

import java.io.Serializable;


public class ModelAds implements Serializable {
    String imagePath, description, name_of_organization, offical_email_of_organization, official_phone_number;
    boolean expired;

    public boolean isExpired() {
            return expired;
        }
    public void setExpired(boolean expired) {
            this.expired = expired;
        }
    public String getName_of_organization() {
            return name_of_organization;
        }

    public void setName_of_organization(String name_of_organization) {
            this.name_of_organization = name_of_organization;
        }

    public String getOffical_email_of_organization() {
            return offical_email_of_organization;
        }

    public void setOffical_email_of_organization(String offical_email_of_organization) {
            this.offical_email_of_organization = offical_email_of_organization;
        }

    public String getOfficial_phone_number() {
            return official_phone_number;
        }

    public void setOfficial_phone_number(String official_phone_number) {
            this.official_phone_number = official_phone_number;
        }

    public String getImagePath() {
            return imagePath;
        }

    public void setImagePath(String imagePath) {
            this.imagePath = imagePath;
        }

    public String getDescription() {
            return description;
        }

    public void setDescription(String description) {
            this.description = description;
        }
}


