package com.ghprint.cms.services;

import com.ghprint.cms.model.stock.TMaterialStock;
import com.ghprint.cms.pagination.DataGridResult;

import java.util.List;

/**
 * Created by Administrator on 2017/4/6.
 */
public interface MaterialStockService {

    /*新增原材料
    * */
    public Integer addMaterialStock(TMaterialStock materialStock);
    /*删除原材料
    * */
    public  Integer delMaterialStock(Integer mid);
    /*修改原材料
    * */
    public  Integer updateMaterialStock(TMaterialStock materialStock);
    /*查询原材料列表
    * */
    public DataGridResult selectMaterialStockList(String key , String value , Integer page, Integer rows);
    /*查询单个原材料
    * */
    public  TMaterialStock getMaterialStockById(Integer mid);
   /*加库存
    */
    public  Float addMaterialStocksum(Integer mid , Float count);
    /*减库存
    */
    public  Float subMaterialStocksum(Integer mid , Float count);
    /*查询整个列表
    * */
    public  List<TMaterialStock> selectAllist();
}
