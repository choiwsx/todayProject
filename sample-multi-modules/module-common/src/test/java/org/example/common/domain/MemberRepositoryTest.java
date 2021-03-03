package org.example.common.domain;

import org.example.common.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;



import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class MemberRepositoryTest {
    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void add(){
        memberRepository.save(new Member("wonseok", "wonseok@gmail.com"));
        Member saved = memberRepository.findById(1l).get();
        assertThat(saved.getName(), is("wonseok"));
    }
}
