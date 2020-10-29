package com.AOA.DealInitService.dto;


import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
public class DealDto {
    private List<String> listUser;
}
