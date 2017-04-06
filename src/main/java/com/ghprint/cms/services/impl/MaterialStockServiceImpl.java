package com.ghprint.cms.services.impl;

import com.ghprint.cms.model.stock.TMaterialCost;
import com.ghprint.cms.model.stock.TMaterialStock;
import com.ghprint.cms.pagination.DataGridResult;
import com.ghprint.cms.serviceDao.TMaterialStockMapper;
import com.ghprint.cms.services.MaterialCostService;
import com.ghprint.cms.services.MaterialStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/4/6.
 */
@Service
public class MaterialStockServiceImpl  implements MaterialStockService{

    @Autowired
    private TMaterialStockMapper materialStockMapper;

    @Autowired
    private MaterialCostService materialCostService;

    @Override
    public Integer addMaterialStock(TMaterialStock materialStock) {
        Integer record = materialStockMapper.insertSelective(materialStock);
        if(record>0) {
            TMaterialCost materialCost = new TMaterialCost(materialStock.getId(), materialStock.getName(), materialStock.getMaterialsum());
            materialCost.setIncome(materialStock.getMaterialsum());
            record += materialCostService.additems(materialCost);
        }
        return record;
    }

    @Override
    public Integer delMaterialStock(Integer mid) {
        Integer record = materialStockMapper.deleteByPrimaryKey(mid);
        record += materialCostService.delitems(mid);
        return record;
    }

    @Override
    public Integer updateMaterialStock(TMaterialStock materialStock) {
        TMaterialStock   materialStocks =  this.getMaterialStockById(materialStock.getId());
        Float sum = materialStock.getMaterialsum();
        if(sum>=0) {
            Float change = materialStock.getMaterialsum() - materialStocks.getMaterialsum();
            TMaterialCost materialCost = new TMaterialCost(materialStock.getId(), materialStock.getName(), sum);
            Integer record = materialStockMapper.updateByPrimaryKey(materialStock);
            if (change > 0) {
                materialCost.setIncome(change);
                record += materialCostService.additems(materialCost);
            }
            if (change < 0) {
                materialCost.setOutcount(-change);
                record += materialCostService.additems(materialCost);
            }
        return  record;
        }else {
            return -1;
        }
    }

    @Override
    public DataGridResult selectMaterialStockList(String key, String value, Integer page, Integer rows) {
        return null;
    }

    @Override
    public TMaterialStock getMaterialStockById(Integer mid) {
        TMaterialStock materialStock = materialStockMapper.selectByPrimaryKey(mid);
        return materialStock==null?null:materialStock;
    }

    @Override
    public Integer addMaterialStocksum(Integer mid, Integer count) {
        return null;
    }

    @Override
    public Integer subMaterialStocksum(Integer mid, Integer count) {
        return null;
    }
}
