package com.wb.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseSearchVo {
    private String houseName;
    private Double minRect;
    private Double maxRect;
    private String floorage;
    private Integer pageNum;
}
