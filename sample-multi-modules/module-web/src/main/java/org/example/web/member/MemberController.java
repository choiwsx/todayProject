package org.example.web.member;


import org.example.common.domain.Member;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    @GetMapping("/")
    public Member get(){
        return new Member("wonseok", "wonseok@gmail.com");
    }
}
