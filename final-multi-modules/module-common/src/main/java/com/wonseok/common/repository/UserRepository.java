package com.wonseok.common.repository;

import com.wonseok.common.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {


//    Optional<User> findByEmail(String email);
}
