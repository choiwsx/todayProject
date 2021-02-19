package com.example.demo;

import com.example.demo.domain.Fortune;
import com.example.demo.repository.FortuneRepository;
import com.example.demo.service.MockFortuneService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class FortuneTest {

    private MockFortuneService mockFortuneService;
    @Autowired
    private FortuneRepository fortuneRepository;


    @AfterEach
    public void cleanup()
    {
        fortuneRepository.deleteAll();
    }


    @Test
    @DisplayName("랜덤 운세")
    public void random_fortune(){
        for(int i=0; i<10; i++)
        {
            fortuneRepository.save(new Fortune((long)(i+1), "테스트"+(i+1)));
        }

        mockFortuneService = new MockFortuneService(fortuneRepository);

        int random = 4;
        Fortune fortune1 = mockFortuneService.getFortune((long)random);
        Fortune fortune2 = fortuneRepository.findById((long)random).orElse(null);


        System.out.println(fortune1.toString());
        System.out.println(fortune2.toString());

        assertThat(fortune1.equals(fortune2));

    }
}
