package com.wb.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseVO {
    private Integer houseId;
    private String title;
    private Double floorage;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date houseDate;
    private String districtId;
    private String streetId;
    private MultipartFile houseImg;
    private String testText;
}
