package com.themis.member;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.themis.address.Address;
import com.themis.membership.Membership;
import jakarta.persistence.*;

import java.time.LocalDate;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity(name = "Member")
@Table(
        name = "member",
        uniqueConstraints = {
                @UniqueConstraint(name="member_email_unique",columnNames = "email")
        }
)
public class Member {

    @Id
    @SequenceGenerator(
            name = "member_sequence",
            sequenceName = "member_sequence",
            allocationSize = 1

    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "member_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;
    @Column(
            name = "name",
            columnDefinition = "TEXT"
    )
    private String name;
    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String email;
    @Column(
            name = "phone",
            columnDefinition = "TEXT"
            //length = 13 // +30 6912345678
    )
    private String phone;
    @Column(
            name = "dob"
    )
    private LocalDate dob;
    @Column(
            name = "gender",
            columnDefinition = "TEXT"
    )
    private String gender;
    @JsonManagedReference
    @OneToOne(
            mappedBy = "member",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE}
    ) // Bidirectional Relationship
    private Membership membership;

    @JsonManagedReference
    @OneToOne(
            mappedBy = "member",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE}
    ) // Bidirectional Relationship
    private Address address;

    public Member() {
    }

    public Member(String name, String email, String phone, LocalDate dob, String gender) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.dob = dob;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Membership getMembership() {
        return membership;
    }

    public void setMembership(Membership membership) {
        this.membership = membership;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", dob=" + dob +
                ", gender='" + gender + '\'' +
                '}';
    }

}
