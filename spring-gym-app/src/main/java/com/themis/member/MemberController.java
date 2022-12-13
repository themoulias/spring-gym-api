package com.themis.member;

import com.themis.RawData.RawData;
import com.themis.address.Address;
import com.themis.membership.Membership;
import com.themis.payment.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/gym")
@CrossOrigin
public class MemberController {

    private final MemberService memberService;
    private final MemberRepository memberRepository;

    @Autowired
    public MemberController(MemberService memberService,
                            MemberRepository memberRepository){
        this.memberService = memberService;
        this.memberRepository = memberRepository;
    }

    @GetMapping
    public List<Member> getMembers(){
        return memberService.getMembers();
    }



    @PostMapping()
    public void registerNewMember(@RequestBody RawData data){

        Member member = new Member(
                data.getName(),
                data.getEmail(),
                data.getPhone(),
                data.getDob(),
                data.getGender());

        Address address = new Address(data.getCity(),
                data.getStreet(),
                data.getStreetNumber(),
                data.getPostCode(),
                member);
        member.setAddress(address);
        Membership membership = new Membership(data.getMembershipType(),
                data.getPeriod(),
                data.getActive(),
                member);

        Payment payment = new Payment(
                data.getAmount(),
                data.getSignupFee(),
                data.getPaymentDate(),
                data.getPaymentMethod(),
                membership
        );

        membership.setPayment(payment);
        member.setMembership(membership);
        memberService.addNewMember(member);
//
    }

    @DeleteMapping(path = "{memberId}")
    public void deleteMember(
            @PathVariable("memberId") Long memberId){
        memberService.deleteMember(memberId);
    }
    @PutMapping(path ="{memberId}")
    public void updateMember(
            @PathVariable("memberId") Long memberId,
            @RequestBody(required = false) RawData data) {

        Member member = new Member(
                data.getName(),
                data.getEmail(),
                data.getPhone(),
                data.getDob(),
                data.getGender());

        Address address = new Address(data.getCity(),
                data.getStreet(),
                data.getStreetNumber(),
                data.getPostCode(),
                member);
        member.setAddress(address);

        Membership membership = new Membership(data.getMembershipType(),
                data.getPeriod(),
                data.getActive(),
                member);

        Payment payment = new Payment(
                data.getAmount(),
                data.getSignupFee(),
                data.getPaymentDate(),
                data.getPaymentMethod(),
                membership
        );

        membership.setPayment(payment);
        member.setMembership(membership);

//        System.out.println(data);
        memberService.updateMember(memberId,data);
        //memberService.updateMember(memberId, rawData);
    }

}
