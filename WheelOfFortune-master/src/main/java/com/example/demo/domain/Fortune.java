package com.example.demo.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Getter
public class Fortune {
    @Id @GeneratedValue
    private Long id;

    private String name;


    public Fortune(Long id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Fortune{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
