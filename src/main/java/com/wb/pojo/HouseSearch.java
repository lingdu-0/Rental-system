package com.wb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseSearch {
    private String houseName;
    private Double minRect;
    private Double maxRect;
    private Integer pageNum;
}
