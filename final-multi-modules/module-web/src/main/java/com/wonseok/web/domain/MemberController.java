package com.wonseok.web.domain;


import com.wonseok.api.service.MemberServiceCustom;
import com.wonseok.common.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    private final MemberServiceCustom memberServiceCustom;

    public MemberController(MemberServiceCustom memberServiceCustom)
    {
        this.memberServiceCustom = memberServiceCustom;
    }

    @GetMapping("/")
    public Member get() {
        System.out.println("여길 못오는거지?");
        memberServiceCustom.signup(new Member("wonseok", "test@test.com"));
        return new Member("wonseok", "wonseok@gmail.com");
    }



}
