package com.themis.address;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.themis.member.Member;
import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity(name = "Address")
@Table(name="address")
public class Address {
    @Id
    @SequenceGenerator(
            name ="address_sequence",
            sequenceName = "address_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "address_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;
    @Column(
            name = "city",
            columnDefinition = "TEXT"
    )
    private String city;
    @Column(
            name = "street",
            columnDefinition = "TEXT"
    )
    private String street;
    @Column(
            name = "street_number",
            columnDefinition = "TEXT"
    )
    private String streetNumber;
    @Column(
            name = "post_code",
            columnDefinition = "TEXT"
    )
    private String postCode;
    @JsonBackReference
    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER // default on 1 to 1
    )
    @JoinColumn(
            name = "member_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "address_member_id_fk")
    )
    private Member member;

    public Address() {
    }

    public Address(String city,
                   String street,
                   String streetNumber,
                   String postCode,
                   Member member) {
        this.city = city;
        this.street = street;
        this.streetNumber = streetNumber;
        this.postCode = postCode;
        this.member = member;
    }

    public Address(String city,
                   String street,
                   String streetNumber,
                   String postCode) {
        this.city = city;
        this.street = street;
        this.streetNumber = streetNumber;
        this.postCode = postCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                ", postCode='" + postCode + '\'' +
                ", member=" + member +
                '}';
    }
}
