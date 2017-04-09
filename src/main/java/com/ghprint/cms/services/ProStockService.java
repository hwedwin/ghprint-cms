package com.ghprint.cms.services;

import com.ghprint.cms.model.stock.TProductionStock;
import com.ghprint.cms.pagination.DataGridResult;

import java.util.List;

/**
 * Created by Administrator on 2017/3/27.
 */
public interface ProStockService {

    //新增库存
    public  Integer addProStock(TProductionStock productionStock);
    public  Integer delProStock(Integer sid);
    public  Integer updateProStock(TProductionStock productionStock);
    public  TProductionStock getProStockbyId(Integer sid);
    public DataGridResult selectProStocks(String key , String value , Integer page, Integer rows);
    //加库存
    public  Integer addStocksum(Integer sid , Integer count);
    //减库存
    public  Integer subStocksum(Integer sid , Integer count);

    public List<TProductionStock> selectAllist();
}
