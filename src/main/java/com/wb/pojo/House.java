package com.wb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class House {
    private Integer houseId;
    private String houseName;
    private Double houseRect;
    private Date houseDate;
    private String houseLoc1;
    private String houseLoc2;
    private String houseImg;
    private User user;
}
