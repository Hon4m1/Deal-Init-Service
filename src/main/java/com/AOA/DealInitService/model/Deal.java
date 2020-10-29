package com.AOA.DealInitService.model;

import com.AOA.DealInitService.dto.DealDto;
import com.AOA.DealInitService.dto.DealUserDto;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

import java.util.List;

@Entity
@Data
public class Deal {
    @GeneratedValue
    @Id
    private Long id;
    private List<String> listUser;
    private Integer price;
    private String firstname;
    private String lastname;
    private String mail;
    private String phone;

    public DealDto toDealDto () {
        return DealDto
                .builder()
                .listUser(this.listUser)
                .build();
    }

    public DealUserDto toDealUserDto (){
        return DealUserDto
                .builder()
                .firstname(this.firstname)
                .lastname(this.lastname)
                .mail(this.mail)
                .phone(this.phone)
                .build();

    }
}
