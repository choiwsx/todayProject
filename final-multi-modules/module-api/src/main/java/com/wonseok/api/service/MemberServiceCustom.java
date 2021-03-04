package com.wonseok.api.service;


import com.wonseok.common.domain.Member;
import com.wonseok.common.repository.MemberRepository;
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
