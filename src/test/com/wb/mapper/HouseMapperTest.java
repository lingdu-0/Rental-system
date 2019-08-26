package com.wb.mapper;

import com.github.pagehelper.PageHelper;
import com.wb.pojo.House;
import com.wb.pojo.HouseSearch;
import com.wb.test.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class HouseMapperTest extends BaseTest {
    @Autowired
    private HouseMapper houseMapper;

    @Test
    public void search() {
        HouseSearch houseSearch = new HouseSearch();
        //houseSearch.setHouseName("2");
        PageHelper.startPage(1, 10);
        List<House> list = houseMapper.search(houseSearch);
        for (House h : list)
            System.out.println(h);
    }

    @Test
    public void findById() {
        House house = houseMapper.findById(1);
        System.out.println(house);
    }

    @Test
    public void findByUserId() {
        List<House> list = houseMapper.findByUserId(1);
        for (House h : list)
            System.out.println(h);
    }

    @Test
    public void delete() {
        System.out.println("受影响的行数:" + houseMapper.delete(19));
    }

    @Test
    public void update() {
        House house = new House();
        house.setHouseId(17);
        house.setHouseName("测试0");
        house.setHouseRect(100.0);
        house.setHouseDate(new Date());
        house.setHouseLoc1("1004");
        house.setHouseLoc2("1001");
        house.setHouseImg("2.jpg");
        System.out.println("受影响的行数:"+houseMapper.update(house));
    }
}
