package com.ghprint.cms.services.impl;

import com.ghprint.cms.model.stock.TMaterialCost;
import com.ghprint.cms.model.stock.TMaterialCostExample;
import com.ghprint.cms.serviceDao.TMaterialCostMapper;
import com.ghprint.cms.services.MaterialCostService;
import com.ghprint.cms.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/4/5.
 */
@Service
public class MaterialCostServiceImpl implements MaterialCostService {

    @Autowired
    private TMaterialCostMapper materialCostMapper;

    @Override
    public Integer additems(TMaterialCost materialCost) {
        materialCost.setInsertime(new Date());
        Integer record = materialCostMapper.insertSelective(materialCost);
        return record;
    }

    @Override
    public Integer delitems(Integer stockid) {
        TMaterialCostExample example = new TMaterialCostExample();
        TMaterialCostExample.Criteria criteria = example.createCriteria();
        criteria.andStockidEqualTo(stockid);
        Integer record = materialCostMapper.deleteByExample(example);
        return record;
    }

    @Override
    public List<TMaterialCost> selectitems(Integer stockid, Date StartDate, Date EndDate) {
        return null;
    }

    @Override
    public Integer updateitemset(Integer stockid) {
        return null;
    }

    @Override
    public Integer selectsum(Integer stockid) {
        return null;
    }
}
