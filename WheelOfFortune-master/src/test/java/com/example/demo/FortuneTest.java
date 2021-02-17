package com.example.demo;

import com.example.demo.domain.Fortune;
import com.example.demo.repository.FortuneRepository;
import com.example.demo.service.FortuneService;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;


//@SpringBootTest
public class FortuneTest {


    private FortuneService fortuneService;
    private FortuneRepository fortuneRepository;
    @Test
    @DisplayName("랜덤 운세")
    void random_fortune(){

//        int fortuneLen = fortuneService.getFortuneList().size();
//        int random = ((int)(Math.random()*fortuneLen))+1;
//        fortuneService = new FortuneService(fortuneRepository);
//
//        int random = 4;
//
//        Fortune fortune1 = fortuneService.getFortune((long)random);
//        Fortune fortune2 = fortuneRepository.findByFortuneId((long)random);
//
//        Assert.assertEquals(fortune1, fortune2);
    }
}
