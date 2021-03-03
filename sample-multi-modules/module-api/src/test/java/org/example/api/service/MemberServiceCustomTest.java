package org.example.api.service;


import org.example.common.domain.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberServiceCustomTest {

    @Autowired
    private MemberServiceCustom memberServiceCustom;


    @Test
    public void save(){
        Member member = new Member("wonseok", "wonseok@gmail.com");
        Long id = memberServiceCustom.signup(member);
        assertThat(id, is(1L));
    }


}
