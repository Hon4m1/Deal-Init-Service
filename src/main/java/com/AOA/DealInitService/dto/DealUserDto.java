package com.AOA.DealInitService.dto;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class DealUserDto {
    private String lender;
    private String borower;
    private String mail;
    private String phone;
}
