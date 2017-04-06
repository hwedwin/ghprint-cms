package com.ghprint.cms.services.impl;

import com.ghprint.cms.model.stock.TCartonStock;
import com.ghprint.cms.model.stock.TProductionStock;
import com.ghprint.cms.pagination.DataGridResult;
import com.ghprint.cms.serviceDao.TCartonStockMapper;
import com.ghprint.cms.services.CartonStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/4/5.
 */
@Service
public class CartonStockServiceImpl implements CartonStockService {

    @Autowired
    private TCartonStockMapper cartonStockMapper;

    @Override
    public Integer addCartonStocks(TCartonStock cartonStock) {
        Integer record = cartonStockMapper.insertSelective(cartonStock);
        return record;
    }

    @Override
    public Integer delCartonStocks(Integer cid) {
        Integer record = cartonStockMapper.deleteByPrimaryKey(cid);
        return record;
    }

    @Override
    public Integer updateCartonStocks(TCartonStock cartonStock) {
        Integer record = cartonStockMapper.updateByPrimaryKey(cartonStock);
        return record;
    }

    @Override
    public TCartonStock getCartonStockbyId(Integer cid) {
        TCartonStock cartonStock  =  cartonStockMapper.selectByPrimaryKey(cid);
        return cartonStock ;
    }

    @Override
    public DataGridResult selectCartonStocks(String key, String value, Integer page, Integer rows) {
        Integer pageOffset = (page-1)*rows;
        List<TCartonStock> list = cartonStockMapper.selectlist(pageOffset,rows,key,value);
        DataGridResult dataGridResult = new DataGridResult();
        if(list!=null) {
            dataGridResult.setRows(list);
            Integer sum = cartonStockMapper.getlistcount(key,value);
            dataGridResult.setTotalCount(sum);
            dataGridResult.setCurrentPage(page);
            dataGridResult.setEveryPage(rows);
            dataGridResult.setTotalPage((sum-1)/rows+1);
        }
        return dataGridResult;
    }

    @Override
    public Integer addStockCount(Integer cid, Integer count) {
        TCartonStock cartonStock = this.getCartonStockbyId(cid);
        Integer sum = 0 ;
        if(count>0){
            sum   = cartonStock.getPackages()+ count;
            cartonStock.setPackages(sum);
            cartonStockMapper.updateByPrimaryKeySelective(cartonStock);
        }
        return  sum ;
    }

    @Override
    public Integer subStockCount(Integer cid, Integer count) {
        TCartonStock cartonStock = this.getCartonStockbyId(cid);
        if(count<=cartonStock.getPackages()&& cartonStock.getPackages()>0&&count>0){
            Integer sum = cartonStock.getPackages()- count;
            cartonStock.setPackages(sum);
            cartonStockMapper.updateByPrimaryKeySelective(cartonStock);
            return  sum ;
        }else if(count> cartonStock.getPackages()) {
            Integer sum = cartonStock.getPackages()- count;
            return  sum;
        } else{
            return -1;
        }
    }
}
