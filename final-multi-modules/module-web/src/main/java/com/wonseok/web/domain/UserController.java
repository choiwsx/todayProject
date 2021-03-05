//package com.wonseok.web.domain;
//
//
//import com.wonseok.common.domain.Member;
////import com.wonseok.common.jwt.JwtTokenProvider;
//import com.wonseok.common.repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Collections;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//
//
////@RequiredArgsConstructor
//@RestController
//public class UserController {
//
////    private final PasswordEncoder passwordEncoder;
////    private final JwtTokenProvider jwtTokenProvider;
//    private final UserRepository userRepository;
//
//    public UserController(UserRepository userRepository)
//    {
//        this.userRepository = userRepository;
//    }
//
//
//
////    @GetMapping("/users")
////    public List<User> getUsers() { return userRepository.findAll();}
//
////    @PostMapping("/join")
////    public Long join(@RequestBody Map<String, String> user)
////    {
////        Optional<User> getUser = userRepository.findByEmail(user.get("email"));
////        if(getUser.isPresent())
////        {
////            throw new IllegalArgumentException("중복 되는 아이디.");
////        }
////
////        return userRepository.save(User.builder()
////                .email(user.get("email"))
////                .password(passwordEncoder.encode(user.get("password")))
////                .roles(Collections.singletonList("ROLE_USER"))
////                .build()).getId();
////    }
////
////    @PostMapping("/login")
////    public String login(@RequestBody Map<String, String> user)
////    {
////        User member = userRepository.findByEmail(user.get("email"))
////                .orElseThrow(()->new IllegalArgumentException("가입되지 않은 아이디입니다."));
////        if(!passwordEncoder.matches(user.get("password"),member.getPassword()))
////        {
////            throw new IllegalArgumentException("잘못된 비번");
////        }
////        return jwtTokenProvider.createToken(member.getUsername(), member.getRoles());
////    }
//
//}
