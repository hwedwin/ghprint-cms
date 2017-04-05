package com.ghprint.cms.services;

import com.ghprint.cms.model.stock.TCartonStock;
import com.ghprint.cms.pagination.DataGridResult;

/**
 * Created by Administrator on 2017/4/5.
 */
public interface CartonStockService {

    public Integer addCartonStocks(TCartonStock cartonStock);
    public Integer delCartonStocks( Integer cid);
    public  Integer updateCartonStocks(TCartonStock cartonStock);
    public  TCartonStock getCartonStockbyId(Integer cid);
    public DataGridResult selectCartonStocks(String key , String value , Integer page, Integer rows);
    public  Integer addStockCount(Integer cid , Integer count);
    public  Integer subStockCount(Integer cid , Integer count);

}
