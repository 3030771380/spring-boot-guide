package com.rui.es_mysql.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReqDto {
    private String vin;
    private String taskCode;
    private String signName;
}
