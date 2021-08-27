package com.example.successsynergyapp.model;

import java.io.Serializable;

public class  ModelServiceProvider implements Serializable {
    String email;
    String fullname;
    String chamber;
    int years_of_exp;
    String cor_profile;
    String state_justification;
    String roll_call_number;
    String uid;
    String phone_number;
    String gender;
    String dob;
    float rating;
    String description;
    String Category;
    int num_cases_solved;
    String state;
    String Address;
    Boolean approved;

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getNum_cases_solved() {
        return num_cases_solved;
    }

    public void setNum_cases_solved(int num_cases_solved) {
        this.num_cases_solved = num_cases_solved;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getChamber() {
        return chamber;
    }

    public void setChamber(String chamber) {
        this.chamber = chamber;
    }

    public int getYears_of_exp() {
        return years_of_exp;
    }

    public void setYears_of_exp(int years_of_exp) {
        this.years_of_exp = years_of_exp;
    }

    public String getCor_profile() {
        return cor_profile;
    }

    public void setCor_profile(String cor_profile) {
        this.cor_profile = cor_profile;
    }

    public String getState_justification() {
        return state_justification;
    }

    public void setState_justification(String state_justification) {
        this.state_justification = state_justification;
    }

    public String getRoll_call_number() {
        return roll_call_number;
    }

    public void setRoll_call_number(String roll_call_number) {
        this.roll_call_number = roll_call_number;
    }
}
