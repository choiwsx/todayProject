package com.backend.springboot.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
//@Table(name = "users")
public class User {

    public User(){

    }

    public User(String name, String email){
        super();
        this.name = name;
        this.email = email;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;




    private String name;

    private String email;


}