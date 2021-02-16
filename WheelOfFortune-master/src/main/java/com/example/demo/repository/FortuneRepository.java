package com.example.demo.repository;

import com.example.demo.domain.Fortune;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FortuneRepository extends JpaRepository<Fortune, Long> {

}
