package com.themis.membership;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.themis.member.Member;
import com.themis.payment.Payment;
import jakarta.persistence.*;


import static jakarta.persistence.GenerationType.*;

@Entity(name = "Membership")
@Table(name ="membership")
public class Membership {
    @Id
    @SequenceGenerator(
            name ="membership_sequence",
            sequenceName = "membership_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "membership_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;
    @Column(
            name = "membershipType",
            columnDefinition = "TEXT"
    )
    private String membershipType;
    @Column(
            name = "period",
            columnDefinition = "TEXT"
    )
    private String period;
    @Column(
            name = "active"
    )
    private boolean active;
    @JsonBackReference
    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER // default on 1 to 1
    )
    @JoinColumn(
            name = "member_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "membership_member_id_fk")
    )
    private Member member;

    @JsonManagedReference

    @OneToOne(
            mappedBy = "membership",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE}
    ) // Bidirectional Relationship
    private Payment payment;

    public Membership() {
    }

    public Membership(String membershipType,
                      String period,
                      boolean active
    ) {
        this.membershipType = membershipType;
        this.period = period;
        this.active = active;
    }

    public Membership(String membershipType,
                      String period,
                      boolean active,
                      Member member
    ) {
        this.membershipType = membershipType;
        this.period = period;
        this.active = active;
        this.member = member;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Membership{" +
                "id=" + id +
                ", membershipType='" + membershipType + '\'' +
                ", period='" + period + '\'' +
                ", active=" + active +
                ", member=" + member +
                '}';
    }
}
