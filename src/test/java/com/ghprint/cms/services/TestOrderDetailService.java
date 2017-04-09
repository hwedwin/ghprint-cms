package com.ghprint.cms.services;

import com.ghprint.cms.model.order.OrderView;
import com.ghprint.cms.pagination.DataGridResult;
import com.ghprint.cms.utils.DateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2017/4/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestOrderDetailService {

    @Autowired
    private  OrderDetailService orderDetailService;

    @Test
    public void testSelectlist(){
        DataGridResult orderList = orderDetailService.selectOrderDetailList(null,null, 1, 10);
        List list = orderList.getRows();
        Iterator<OrderView> iter = list.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    @Test
    public  void addOrderDetail(){
        OrderView orderView = new OrderView();
        orderView.setOrderid(1);
        orderView.setInsertime(DateUtil.getTime());
        System.out.println(orderView);
        Integer detail = orderDetailService.addOrderDetail(orderView);
        System.out.println(detail);
    }
}
