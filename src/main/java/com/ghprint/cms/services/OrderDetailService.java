package com.ghprint.cms.services;

import com.ghprint.cms.model.order.OrderView;
import com.ghprint.cms.pagination.DataGridResult;

/**
 * Created by Administrator on 2017/4/9.
 */
public interface OrderDetailService {

    /*查询订单详细列表
   * */
    public DataGridResult selectOrderDetailList(String key , String value , Integer page, Integer rows);
    /*插入明细
    * */
    public  Integer addOrderDetail(OrderView orderView);
}
