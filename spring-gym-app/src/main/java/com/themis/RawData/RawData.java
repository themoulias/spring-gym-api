package com.themis.RawData;

import java.time.LocalDate;

public class RawData {

    // member
    private Long memberId;
    private String name;
    private String email;
    private String phone;
    private LocalDate dob;
    private String gender;
    // membership
    private Long membershipId;
    private String membershipType;
    private String period;
    private boolean active;
    // address
    private Long addressId;
    private String city;
    private String street;
    private String streetNumber;
    private String postCode;
    // payment
    private Long paymentId;
    private float amount;
    private float signupFee;
    private LocalDate paymentDate;
    private String paymentMethod;

    public RawData(String name,
                   String email,
                   String phone,
                   LocalDate dob,
                   String gender,
                   String city,
                   String street,
                   String streetNumber,
                   String postCode,
                   String membershipType,
                   String period,
                   boolean active,
                   float amount,
                   float signupFee,
                   LocalDate paymentDate,
                   String paymentMethod
    ) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.dob = dob;
        this.gender = gender;
        this.membershipType = membershipType;
        this.period = period;
        this.active = active;
        this.city = city;
        this.street = street;
        this.streetNumber = streetNumber;
        this.postCode = postCode;
        this.amount = amount;
        this.signupFee = signupFee;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
    }

    public RawData(Long memberId,
                   String name,
                   String email,
                   String phone,
                   LocalDate dob,
                   String gender,
                   Long membershipId,
                   String membershipType,
                   String period,
                   boolean active,
                   Long addressId,
                   String city,
                   String street,
                   String streetNumber,
                   String postCode,
                   Long paymentId,
                   float amount,
                   float signupFee,
                   LocalDate paymentDate,
                   String paymentMethod
    ) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.dob = dob;
        this.gender = gender;
        this.membershipId = membershipId;
        this.membershipType = membershipType;
        this.period = period;
        this.active = active;
        this.addressId = addressId;
        this.city = city;
        this.street = street;
        this.streetNumber = streetNumber;
        this.postCode = postCode;
        this.paymentId = paymentId;
        this.amount = amount;
        this.signupFee = signupFee;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
    }

    public RawData() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }



    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getSignupFee() {
        return signupFee;
    }

    public void setSignupFee(float signupFee) {
        this.signupFee = signupFee;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "RawData{" +
                "memberId=" + memberId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", dob=" + dob +
                ", gender='" + gender + '\'' +
                ", membershipId=" + membershipId +
                ", membershipType='" + membershipType + '\'' +
                ", period='" + period + '\'' +
                ", active=" + active +
                ", addressId=" + addressId +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                ", postCode='" + postCode + '\'' +
                ", paymentId=" + paymentId +
                ", amount=" + amount +
                ", signupFee=" + signupFee +
                ", paymentDate=" + paymentDate +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }
}
