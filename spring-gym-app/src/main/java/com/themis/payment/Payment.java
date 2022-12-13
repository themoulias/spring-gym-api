package com.themis.payment;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.themis.membership.Membership;
import jakarta.persistence.*;

import java.time.LocalDate;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity(name = "Payment")
@Table(name = "payment")
public class Payment {
    @Id
    @SequenceGenerator(
            name ="payment_sequence",
            sequenceName = "payment_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "payment_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;
    @Column(
            name = "amount"
    )
    private float amount;
    @Column(
            name = "signup_fee"
    )
    private float signupFee;
    @Column(
            name = "paymentDate"
    )
    private LocalDate paymentDate;
    @Column(
            name = "paymentMethod",
            columnDefinition = "TEXT"
    )
    private String paymentMethod;
    @JsonBackReference
    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER // default on 1 to 1
    )
    @JoinColumn(
            name = "membership_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "payment_membership_id_fk")
    )
    private Membership membership;

    public Payment() {
    }

    public Payment(float amount, float signupFee, LocalDate paymentDate, String paymentMethod, Membership membership) {
        this.amount = amount;
        this.signupFee = signupFee;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
        this.membership = membership;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return "Payment{" +
                "id=" + id +
                ", amount=" + amount +
                ", signupFee=" + signupFee +
                ", paymentDate=" + paymentDate +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", membership=" + membership +
                '}';
    }
}
