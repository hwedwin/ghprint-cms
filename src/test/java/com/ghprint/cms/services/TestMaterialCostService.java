package com.ghprint.cms.services;

import com.ghprint.cms.model.stock.TMaterialCost;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2017/4/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestMaterialCostService {

    @Autowired
    private  MaterialCostService materialCostService;

    @Test
    public void testadditems(){
        TMaterialCost  materialCost = new TMaterialCost(1,"PVC料" ,100f,100f,100f,new Date());
        Integer additems = materialCostService.additems(materialCost);
        System.out.println(materialCost);
    }


    @Test
    public void testdelitems(){
        Integer delitems = materialCostService.delitems(1);
        System.out.println(delitems);
    }

    @Test
    public  void testselectitems(){
        List<TMaterialCost> list = materialCostService.selectitems(1, null, null);
        Iterator iterator = list.iterator();
        while ( iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public  void testupdateitemset(){
        TMaterialCost materialCost = materialCostService.updateitemset(1);
        System.out.println(materialCost);
    }

    @Test
    public void testselectsum(){
        Integer selectsum = materialCostService.selectsum(1);
        System.out.println(selectsum);
    }

}
