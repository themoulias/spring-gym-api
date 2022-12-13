package com.themis.member;

import com.themis.address.Address;
import com.themis.membership.Membership;
import com.themis.payment.Payment;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

import static java.time.Month.*;


@Configuration
public class MemberConfig {

    @Bean
    CommandLineRunner commandLineRunner(MemberRepository memberRepository){
        return args -> {

            Member themis = new Member(
                    "Themis",
                    "themis@mail.com",
                    "6923456789",
                    LocalDate.of(1995, AUGUST, 1),
                    "male"
            );
            Address address = new Address(
                    "Filiates",
                    "street",
                    "12",
                    "46300",
                    themis
            );

            themis.setAddress(address);
            Membership membership = new Membership("Full",
                    "1 Week",
                    true,themis);

            Payment payment = new Payment(
                    200,
                    15,
                    LocalDate.of(2022, DECEMBER, 12),
                    "Cash",
                    membership
            );

            membership.setPayment(payment);
            themis.setMembership(membership);
            memberRepository.save(themis);

        };
    }
}
