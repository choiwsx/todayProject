package com.example.demo.repository;

import com.example.demo.domain.Fortune;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface FortuneRepository extends  JpaRepository<Fortune, Long>{

}
