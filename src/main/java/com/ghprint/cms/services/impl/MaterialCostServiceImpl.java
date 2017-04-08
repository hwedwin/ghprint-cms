package com.ghprint.cms.services.impl;

import com.ghprint.cms.model.stock.TMaterialCost;
import com.ghprint.cms.model.stock.TMaterialCostExample;
import com.ghprint.cms.model.stock.TMaterialStock;
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
    public List<TMaterialCost> selectitems(Integer stockid, String StartDate, String EndDate) {
        List<TMaterialCost> costList = materialCostMapper.selectitems(stockid, StartDate, EndDate);
        return costList!=null?costList:null;
    }

    @Override
    public TMaterialCost updateitemset(Integer stockid) {
        TMaterialCostExample example = new TMaterialCostExample();
        TMaterialCostExample.Criteria criteria = example.createCriteria();
        criteria.andStockidEqualTo(stockid);
        List<TMaterialCost> list = materialCostMapper.selectByExample(example);
        TMaterialCost materialCost = new TMaterialCost();
        if(list.size()>0) {
            materialCost = list.get(0);
            materialCost.setOutcount(0f);
            materialCost.setSumcount(0f);
            materialCost.setIncome(0f);
            materialCost.setInsertime(new Date());
        }else {
            return  null;
        }
        this.delitems(stockid);
        this.additems(materialCost);
        return materialCost;
    }

    @Override
    public Integer selectsum(Integer stockid) {
        List<TMaterialCost> materialCosts = this.selectitems(stockid, null, null);
        if(materialCosts.size()>0) {
            float sumcount = materialCosts.get(0).getSumcount();
            return  (int) sumcount;
        }else {
            return  0;
        }
    }

    @Override
    public Integer addincomeitems(TMaterialStock materialStock ,Float count) {
        TMaterialCost materialCost = new TMaterialCost(materialStock.getId(), materialStock.getName(), materialStock.getMaterialsum());
        materialCost.setIncome(count);
        Integer record = this.additems(materialCost);
        return record;
    }

    @Override
    public Integer addoutitems(TMaterialStock materialStock,Float count) {
        TMaterialCost materialCost = new TMaterialCost(materialStock.getId(), materialStock.getName(), materialStock.getMaterialsum());
        materialCost.setOutcount(count);
        Integer record = this.additems(materialCost);
        return record;
    }
}
