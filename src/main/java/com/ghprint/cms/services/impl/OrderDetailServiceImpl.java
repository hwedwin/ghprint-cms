package com.ghprint.cms.services.impl;

import com.ghprint.cms.model.order.OrderView;
import com.ghprint.cms.pagination.DataGridResult;
import com.ghprint.cms.serviceDao.OrderDetailMapper;
import com.ghprint.cms.services.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/4/9.
 */
@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Override
    public DataGridResult selectOrderDetailList(String key, String value, Integer page, Integer rows) {
        Integer pageOffset = (page-1)*rows;
        List<OrderView> list = orderDetailMapper.selectlist(pageOffset,rows,key,value);
        DataGridResult dataGridResult = new DataGridResult();
        if(list!=null) {
            dataGridResult.setRows(list);
            Integer sum = orderDetailMapper.getlistcount(key,value);
            dataGridResult.setTotalCount(sum);
            dataGridResult.setCurrentPage(page);
            dataGridResult.setEveryPage(rows);
            dataGridResult.setTotalPage((sum-1)/rows+1);
        }
        return dataGridResult;
    }

    @Override
    public Integer addOrderDetail(OrderView orderView) {
        Integer record = orderDetailMapper.insertSelective(orderView);
        return record;
    }
}
