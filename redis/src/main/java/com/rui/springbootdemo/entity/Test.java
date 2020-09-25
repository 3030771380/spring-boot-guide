package com.rui.springbootdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Test {
    private Integer id ;
    private String cellDuration;
    private String time;
    private String vin;
}
