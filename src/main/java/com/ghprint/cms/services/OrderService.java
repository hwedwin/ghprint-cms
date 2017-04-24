package com.ghprint.cms.services;

import com.ghprint.cms.model.order.*;
import com.ghprint.cms.pagination.DataGridResult;

/**
 * Created by Administrator on 2017/4/8.
 */
public interface OrderService {

    /*新增订单
    * */
    public OrderView addOrderItem(TPurchaseDetail order);
    /*取消订单
    * */
    public Integer delOrderItem(Integer orderId);
    /*修改订单
    * */
    public  Integer updateOrderItem(OrderEdit order);
    /*查询订单列表
    * */
    public DataGridResult selectOrderList(String key , String value , Integer page, Integer rows);
    /*查询单条记录
    * */
    public OrderInfo getOrderItemById(Integer orderId);
    /*根据订单数量查询成品库存是否足够
    * */
    public OrderView CheckProStocks(Integer productid , Integer ordercount);
    /*计算原材料抵扣量
    * */
    public  Float  materialSub(Integer  needsum , TPurchaseDetail order);
    /*检查原材料库存是否足够
    * */
    public  OrderView CheckMaterialStocks(Integer stockid , Float sub);
    /*字典
    * */
    public OrderInit getProductionInit(Boolean company , Boolean product , Boolean material , Boolean standard);
    /*查询单条记录修改附外键
    * */
    public OrderEdit getOrderEdit(Integer orderId);

}
