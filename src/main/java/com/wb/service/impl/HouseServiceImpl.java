package com.wb.service.impl;

import com.github.pagehelper.PageHelper;
import com.wb.common.Constant;
import com.wb.mapper.HouseMapper;
import com.wb.pojo.House;
import com.wb.pojo.HouseSearch;
import com.wb.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {
    @Autowired
    private HouseMapper houseMapper;

    /**
     * 发布房源
     *
     * @param house
     */
    public void fabu(House house) {
        houseMapper.fabu(house);
    }

    /**
     * 通过条件查询房源
     *
     * @param houseSearch
     * @return
     */
    @Override
    public List<House> search(HouseSearch houseSearch) {
        if (houseSearch.getPageNum() == null)
            houseSearch.setPageNum(1);
        PageHelper.startPage(houseSearch.getPageNum(), Constant.PAGESIZE);
        return houseMapper.search(houseSearch);
    }

    /**
     * 通过房源编号查询指定房源
     *
     * @param houseId
     * @return
     */
    @Override
    public House findById(Integer houseId) {
        return houseMapper.findById(houseId);
    }

    /**
     * 通过用户编号查询用户发布的所有房源
     *
     * @param userId
     * @return
     */
    @Override
    public List<House> findByUserId(Integer userId, Integer pageNum) {
        PageHelper.startPage(pageNum, Constant.PAGESIZE);
        return houseMapper.findByUserId(userId);
    }

    /**
     * 通过id删除房源
     *
     * @param houseId
     * @return
     */
    @Override
    public int delete(Integer houseId) {
        return houseMapper.delete(houseId);
    }

    /**
     * 根据id修改房源
     *
     * @param house
     * @return
     */
    @Override
    public int update(House house) {
        return houseMapper.update(house);
    }
}
