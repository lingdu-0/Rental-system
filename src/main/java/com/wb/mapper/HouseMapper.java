package com.wb.mapper;

import com.wb.pojo.House;
import com.wb.pojo.HouseSearch;

import java.util.List;

public interface HouseMapper {
    void fabu(House house);
    List<House> search(HouseSearch houseSearch);
    House findById(Integer houseId);
    List<House> findByUserId(Integer userId);
    int delete(Integer houseId);
    int update(House house);
}
