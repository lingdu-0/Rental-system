package com.wb.service;

import com.wb.pojo.House;
import com.wb.pojo.HouseSearch;

import java.util.List;

public interface HouseService {
    void fabu(House house);
    List<House> search(HouseSearch houseSearch);
    House findById(Integer houseId);
    List<House> findByUserId(Integer userId,Integer pageNum);
    int delete(Integer houseId);
    int update(House house);
}
