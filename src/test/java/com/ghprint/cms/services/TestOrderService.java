package com.ghprint.cms.services;

import com.alibaba.fastjson.JSON;
import com.ghprint.cms.model.order.OrderInfo;
import com.ghprint.cms.model.order.OrderInit;
import com.ghprint.cms.model.order.OrderView;
import com.ghprint.cms.model.order.TPurchaseDetail;
import com.ghprint.cms.pagination.DataGridResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2017/4/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestOrderService {

    @Autowired
    private  OrderService orderService;

    @Test
    public  void testCheckProStocks(){
        OrderView orderView = orderService.CheckProStocks(4, 900);
        System.out.println(orderView);
    }

    @Test
    public  void testmaterialSub(){
        TPurchaseDetail order = new TPurchaseDetail();
        order.setStockid(11);
        order.setSpellcount(1);
        order.setHeight(0.09f);
        order.setProportion(1.23f);
        order.setThickness(0.33f);
        System.out.println(order);
        Float sub = orderService.materialSub(500, order);
        System.out.println(sub);
    }

    @Test
    public  void testCheckMaterialStocks(){
        OrderView orderView = orderService.CheckMaterialStocks(11, 999.00f);
        System.out.println(orderView);
    }

    @Test
    public  void  testaddOrderItem(){
        TPurchaseDetail O = new TPurchaseDetail(1,4,11,1,1,1f,1f,1f,100,new Date(), new Date());
        OrderView orderView = orderService.addOrderItem(O);
    }

    @Test
    public  void testselectOrderList(){
        DataGridResult orderList = orderService.selectOrderList(null,null, 1, 10);
        List list = orderList.getRows();
        Iterator<TPurchaseDetail> iter = list.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    @Test
    public  void testgetOrderItemById(){
        OrderInfo orderInfo = orderService.getOrderItemById(19);
        System.out.println(orderInfo);
    }

    @Test
    public  void testgetProductionInit(){
        OrderInit productionInit = orderService.getProductionInit(true, true, true, true);

        String jsonString = JSON.toJSONString(productionInit);
            System.out.println(jsonString);
    }
}
