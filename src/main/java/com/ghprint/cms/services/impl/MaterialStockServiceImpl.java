package com.ghprint.cms.services.impl;

import com.ghprint.cms.model.stock.TMaterialCost;
import com.ghprint.cms.model.stock.TMaterialStock;
import com.ghprint.cms.model.stock.TMaterialStockExample;
import com.ghprint.cms.pagination.DataGridResult;
import com.ghprint.cms.serviceDao.TMaterialStockMapper;
import com.ghprint.cms.services.MaterialCostService;
import com.ghprint.cms.services.MaterialStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
            record += materialCostService.addincomeitems(materialStock,materialStock.getMaterialsum());
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
        Integer pageOffset = (page-1)*rows;
        List<TMaterialStock> list = materialStockMapper.selectlist(pageOffset,rows,key,value);
        DataGridResult dataGridResult = new DataGridResult();
        if(list!=null) {
            dataGridResult.setRows(list);
            Integer sum = materialStockMapper.getlistcount(key,value);
            dataGridResult.setTotalCount(sum);
            dataGridResult.setCurrentPage(page);
            dataGridResult.setEveryPage(rows);
            dataGridResult.setTotalPage((sum-1)/rows+1);
        }
        return dataGridResult;
    }

    @Override
    public TMaterialStock getMaterialStockById(Integer mid) {
        TMaterialStock materialStock = materialStockMapper.selectByPrimaryKey(mid);
        return materialStock==null?null:materialStock;
    }

    @Override
    public Float addMaterialStocksum(Integer mid, Float count) {
        TMaterialStock materialStock = this.getMaterialStockById(mid);
        Float sum = 0f ;
        if(count>0 && materialStock!=null){
            sum   = materialStock.getMaterialsum()+ count;
            materialStock.setMaterialsum(sum);
            Integer record = materialStockMapper.updateByPrimaryKeySelective(materialStock);
             record += materialCostService.addincomeitems(materialStock,count);
        }
        return  sum ;
    }

    @Override
    public Float subMaterialStocksum(Integer mid, Float count) {
        TMaterialStock  materialStock= this.getMaterialStockById(mid);
        if(count>0&& materialStock!=null){
            Float sum = materialStock.getMaterialsum()- count;
            materialStock.setMaterialsum(sum);
            Integer record =materialStockMapper.updateByPrimaryKeySelective(materialStock);
            record += materialCostService.addoutitems(materialStock,count);
            return  sum ;
        } else{
            return -1f;
        }
    }

    @Override
    public List<TMaterialStock> selectAllist() {
        TMaterialStockExample example = new TMaterialStockExample();
        List<TMaterialStock> list = materialStockMapper.selectByExample(example);
        return list;
    }
}
