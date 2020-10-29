package com.AOA.DealInitService.dto;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class DealUserDto {
    private String firstname;
    private String lastname;
    private String mail;
    private String phone;
}
