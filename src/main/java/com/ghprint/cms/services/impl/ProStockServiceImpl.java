package com.ghprint.cms.services.impl;

import com.ghprint.cms.model.stock.TProductionStock;
import com.ghprint.cms.pagination.DataGridResult;
import com.ghprint.cms.serviceDao.TProductionStockMapper;
import com.ghprint.cms.services.ProStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/3/27.
 */
@Service
public class ProStockServiceImpl implements ProStockService {

    @Autowired
    private TProductionStockMapper productionStockMapper;

    @Override
    public Integer addProStock(TProductionStock productionStock) {
        Integer record =  productionStockMapper.insertSelective(productionStock);
        return record;
    }

    @Override
    public Integer delProStock(Integer sid) {
        Integer record = productionStockMapper.deleteByPrimaryKey(sid);
        return  record;
    }

    @Override
    public Integer updateProStock(TProductionStock productionStock) {
       Integer record = productionStockMapper.updateByPrimaryKeySelective(productionStock);
        return  record;
    }

    @Override
    public TProductionStock getProStockbyId(Integer sid) {
        TProductionStock productionStock = productionStockMapper.selectByPrimaryKey(sid);
        return  productionStock;
    }

    @Override
    public DataGridResult selectProStocks(String key, String value, Integer page, Integer rows) {
        Integer pageOffset = (page-1)*rows;
        List<TProductionStock> list = productionStockMapper.selectlist(pageOffset,rows,key,value);
        DataGridResult dataGridResult = new DataGridResult();
        if(list!=null) {
            dataGridResult.setRows(list);
            Integer sum = productionStockMapper.getlistcount(key,value);
            dataGridResult.setTotalCount(sum);
            dataGridResult.setCurrentPage(page);
            dataGridResult.setEveryPage(rows);
            dataGridResult.setTotalPage((sum-1)/rows+1);
        }
        return dataGridResult;
    }

    @Override
    public Integer updataStocksum(Integer sid, Integer count) {
        TProductionStock productionStock = this.getProStockbyId(sid);
        if(count<=productionStock.getStocksum()&& productionStock.getStocksum()>0&&count>0){
            Integer sum = productionStock.getStocksum() - count;
            productionStock.setStocksum(sum);
            productionStockMapper.updateByPrimaryKeySelective(productionStock);
            return  sum ;
        }else{
            return -1;
        }
    }
}