package org.example.api.service;


import org.example.common.domain.Member;
import org.example.common.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceCustom {

    private MemberRepository memberRepository;

    public MemberServiceCustom(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }


    public Long signup(Member member)
    {
        return memberRepository.save(member).getId();
    }

}
