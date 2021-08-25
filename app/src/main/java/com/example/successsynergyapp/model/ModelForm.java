package com.example.successsynergyapp.model;

import java.io.Serializable;

public class ModelForm implements Serializable {
    String first_name, surname, Location, State, email_address, phone_number;
    String type_of_service, budget;
    boolean willing_to_pay, consent, ready_to_deposit, intend_to_balance;

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getType_of_service() {
        return type_of_service;
    }

    public void setType_of_service(String type_of_service) {
        this.type_of_service = type_of_service;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public boolean isWilling_to_pay() {
        return willing_to_pay;
    }

    public void setWilling_to_pay(boolean willing_to_pay) {
        this.willing_to_pay = willing_to_pay;
    }

    public boolean isConsent() {
        return consent;
    }

    public void setConsent(boolean consent) {
        this.consent = consent;
    }

    public boolean isReady_to_deposit() {
        return ready_to_deposit;
    }

    public void setReady_to_deposit(boolean ready_to_deposit) {
        this.ready_to_deposit = ready_to_deposit;
    }

    public boolean isIntend_to_balance() {
        return intend_to_balance;
    }

    public void setIntend_to_balance(boolean intend_to_balance) {
        this.intend_to_balance = intend_to_balance;
    }
}
