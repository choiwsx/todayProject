package com.example.demo;

import com.example.demo.domain.Fortune;
import com.example.demo.repository.FortuneRepository;
import com.example.demo.service.MockFortuneService;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
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


        assertThat(fortune1.equals(fortune2));

    }

    @Test
    public void run() throws Exception {
        StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor();
        pbeEnc.setAlgorithm("PBEWithMD5AndDES");
        pbeEnc.setPassword("test"); //2번 설정의 암호화 키를 입력

        String enc = pbeEnc.encrypt("1234"); //암호화 할 내용
        System.out.println("enc = " + enc); //암호화 한 내용을 출력

        //테스트용 복호화
        String des = pbeEnc.decrypt(enc);
        System.out.println("des = " + des);
    }
}
