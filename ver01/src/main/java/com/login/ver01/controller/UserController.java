package com.login.ver01.controller;


import com.login.ver01.domain.User;
import com.login.ver01.jwt.JwtTokenProvider;
import com.login.ver01.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class UserController {


    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;

    @GetMapping("/user/resource")
    public String test(){
        return "테스트";
    }
    @GetMapping("/resource")
    public String test2(){
        return "테스트";
    }


    @PostMapping("/join")
    public Long join(@RequestBody Map<String, String> user)
    {
//        System.out.println(user.get("email"));
//        System.out.println(userRepository.findByEmail(user.get("email"))!=null);
        Optional<User> getUser = userRepository.findByEmail(user.get("email"));
        System.out.println(getUser);
        if(getUser.isPresent())
        {
            System.out.println("여기농나");
            throw new IllegalArgumentException("중복 되는 아이디 입니다.");
        }
        return userRepository.save(User.builder()
                .email(user.get("email"))
                .password(passwordEncoder.encode(user.get("password")))
                .roles(Collections.singletonList("ROLE_USER"))
                .build()).getId();
    }

    @GetMapping("/users")
    public List<User> getUsers()
    {
        return userRepository.findAll();
    }

    @PostMapping("/login")
    public String login(@RequestBody Map<String,String> user)
    {
        User member= userRepository.findByEmail(user.get("email"))
                .orElseThrow(()->new IllegalArgumentException("가입되지 않은 이메일입니다"));
        if (!passwordEncoder.matches(user.get("password"), member.getPassword())){
            throw new IllegalArgumentException("잘못된 비밀번호 입니다");
        }
        return jwtTokenProvider.createToken(member.getUsername(), member.getRoles());
    }

}
