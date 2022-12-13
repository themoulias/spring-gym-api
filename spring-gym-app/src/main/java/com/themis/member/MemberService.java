package com.themis.member;

import com.themis.RawData.RawData;
import com.themis.address.Address;
import com.themis.address.AddressRepository;
import com.themis.membership.Membership;
import com.themis.membership.MembershipRepository;
import com.themis.payment.Payment;
import com.themis.payment.PaymentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final AddressRepository addressRepository;
    private final MembershipRepository membershipRepository;
    private final PaymentRepository paymentRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository,
                         AddressRepository addressRepository,
                         MembershipRepository membershipRepository,
                         PaymentRepository paymentRepository) {
        this.memberRepository = memberRepository;
        this.addressRepository = addressRepository;
        this.membershipRepository = membershipRepository;
        this.paymentRepository = paymentRepository;
    }

    public List<Member> getMembers(){
        return memberRepository.findAll();
    }

    public void addNewMember(Member member) {
        Optional<Member> memberOptional = memberRepository.findMemberByEmail(member.getEmail());

        if (memberOptional.isPresent()){
            throw new IllegalStateException("E-mail taken");
        }
        memberRepository.save(member);

    }

    public void deleteMember(Long memberId) {
        boolean exists = memberRepository.existsById(memberId);
        if(!exists){
            throw  new IllegalStateException("member with id "+memberId+ " does not exists");
        }
        memberRepository.deleteById(memberId);
    }
    @Transactional
    public void updateMember(Long memberId, RawData data) {

        Member oldMember = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalStateException(
                        "member with id " + memberId + "does not exists"));

        Address oldAddress = addressRepository.findAddressById(memberId).orElseThrow(() -> new IllegalStateException(
                "address with id " + memberId + "does not exists"));

        Membership oldMembership = membershipRepository.findMembershipById((memberId)).orElseThrow(() -> new IllegalStateException(
                "membership with id " + memberId + "does not exists"));

        Payment oldPayment = paymentRepository.findPaymentById((oldMembership.getId())).orElseThrow(() -> new IllegalStateException(
                "payment with id " + oldMembership.getId() + "does not exists"));

        // Member
        String name = data.getName();
        String email = data.getEmail();
        String phone = data.getPhone();
        LocalDate dob = data.getDob();
        String gender = data.getGender();
        // Address
        String city = data.getCity();
        String street = data.getStreet();
        String streetNumber = data.getStreetNumber();
        String postCode = data.getPostCode();
        // Membership
        String membershipType = data.getMembershipType();
        String period = data.getPeriod();
        boolean active = data.getActive();
        // Payment
        float amount = data.getAmount();
        float signupFee = data.getSignupFee();
        LocalDate paymentDate = data.getPaymentDate();
        String paymentMethod = data.getPaymentMethod();

        // Member
        if (name != null &&
                name.length() > 0 &&
                !Objects.equals(oldMember.getName(), name)) {
            oldMember.setName(name);
        }

        if (email != null &&
                email.length() > 0 &&
                !Objects.equals(oldMember.getEmail(), email)) {
            Optional<Member> memberOptional = memberRepository
                    .findMemberByEmail(email);
            if (memberOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }
            oldMember.setEmail(email);
        }

        if (dob != null &&
                !Objects.equals(oldMember.getDob(), dob)) {
            oldMember.setDob(dob);
        }

        if (gender != null &&
                !Objects.equals(oldMember.getGender(), gender)) {
            oldMember.setGender(gender);
        }

        if (phone != null &&
                !Objects.equals(oldMember.getPhone(), phone)) {
            oldMember.setPhone(phone);
        }

        // Address
        if (city != null &&
                !Objects.equals(oldAddress.getCity(), city)) {
            oldAddress.setCity(city);
        }
        if (street != null &&
                !Objects.equals(oldAddress.getStreet(), street)) {
            oldAddress.setStreet(street);
        }
        if (streetNumber != null &&
                !Objects.equals(oldAddress.getStreetNumber(), streetNumber)) {
            oldAddress.setStreetNumber(streetNumber);
        }
        if (postCode != null &&
                !Objects.equals(oldAddress.getPostCode(), postCode)) {
            oldAddress.setPostCode(postCode);
        }

        //Membership
        if (membershipType != null &&
                !Objects.equals(oldMembership.getMembershipType(), membershipType)) {
            oldMembership.setMembershipType(membershipType);
        }
        if (period != null &&
                !Objects.equals(oldMembership.getPeriod(), period)) {
            oldMembership.setPeriod(period);
        }
//        if (active != null &&
//                !Objects.equals(oldMembership.getActive(), active)) {
//            oldMembership.setActive(active);
//        }

        oldMembership.setActive(active);
        //Payment
//        if (amount != null &&
//                !Objects.equals(oldPayment.getAmount(), amount)) {
//            oldPayment.setAmount(amount);
//        }
        oldPayment.setAmount(amount);
//        if (signupFee != null &&
//                !Objects.equals(oldPayment.getSignupFee(), signupFee)) {
//            oldPayment.setSignupFee(signupFee);
//        }
        oldPayment.setSignupFee(signupFee);

        if (paymentDate != null &&
                !Objects.equals(oldPayment.getPaymentDate(), paymentDate)) {
            oldPayment.setPaymentDate(paymentDate);
        }
        if (paymentMethod != null &&
                !Objects.equals(oldPayment.getPaymentMethod(), paymentMethod)) {
            oldPayment.setPaymentMethod(paymentMethod);
        }
    }
}
