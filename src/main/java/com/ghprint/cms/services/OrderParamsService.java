package com.ghprint.cms.services;

import com.ghprint.cms.model.order.OrderParams;
import com.ghprint.cms.model.order.TOrderParams;
import com.ghprint.cms.pagination.DataGridResult;

import java.util.List;

/**
 * Created by lipeiting on 2017/6/13.
 */
public interface OrderParamsService {

    /*增加订单明细
    * */
    public  Integer  addOrderParams (TOrderParams orderParams);
    /*删除订单明细
    * */
    public  Integer delOrderParams(Integer opid);
    /*修改订单明细
    * */
    public  Integer  updateOrderParams(TOrderParams orderParams);
    /*查询订单明细列表
    * */
    public DataGridResult selectOrderParamsList(String key , String value , Integer page, Integer rows);
    /*查询单个订单明细
    * */
    public OrderParams getOrderParamsById(Integer opid);
    /*查询整个列表
    * */
    public List<TOrderParams> selectAllist();
    /*查询单条记录修改附外键
   * */
    public OrderParams getOrderParamsEdit(Integer opid);
}
