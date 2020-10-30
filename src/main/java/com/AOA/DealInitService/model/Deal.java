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

    private String nameDeal;
    private String code;
    private Integer price;
    private String zone;
    private String devise;

    private String nameBrower;
    private String nameLender;
    private String statut;
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
                .borower(this.nameBrower)
                .lender(this.nameLender)
                .mail(this.mail)
                .phone(this.phone)
                .build();

    }
}
