package com.wb.converter;

import com.wb.pojo.House;
import com.wb.pojo.HouseSearch;
import com.wb.pojo.User;
import com.wb.vo.HouseSearchVo;
import com.wb.vo.HouseVO;

public class HouseConverter {
    public static House conver(HouseVO houseVO, String img, User user) {
        House house = new House();
        house.setHouseId(houseVO.getHouseId());
        house.setHouseName(houseVO.getTitle());
        house.setHouseRect(houseVO.getFloorage());
        house.setHouseDate(houseVO.getHouseDate());
        house.setHouseLoc1(houseVO.getDistrictId());
        house.setHouseLoc2(houseVO.getStreetId());
        house.setHouseImg(img);
        house.setUser(user);
        return house;
    }

    public static HouseSearch conver(HouseSearchVo searchVo) {
        HouseSearch houseSearch = new HouseSearch();
        houseSearch.setHouseName(searchVo.getHouseName());
        houseSearch.setMaxRect(searchVo.getMaxRect());
        houseSearch.setMinRect(searchVo.getMinRect());
        houseSearch.setPageNum(searchVo.getPageNum());
        return houseSearch;
    }
}
