package com.ghprint.cms.services;

import com.alibaba.fastjson.JSON;
import com.ghprint.cms.model.stock.TMaterialStock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2017/4/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestMaterialStockService {

    @Autowired
    private  MaterialStockService materialStockService;

    @Test
    public  void testaddMaterialStock(){
        TMaterialStock materialStock = new TMaterialStock("供应商","PVC材料","材料规格",5.5f,"1-2",55,3,100f,100f,300f);
        String jsonString = JSON.toJSONString(materialStock);
        System.out.println(jsonString);
//        Integer stock = materialStockService.addMaterialStock(materialStock);
//        System.out.println(stock);
    }

    @Test
    public  void testdelMaterialStock(){
        Integer stock = materialStockService.delMaterialStock(4);
        System.out.println(stock);
    }

    @Test
    public  void testupdateMaterialStock(){
        TMaterialStock materialStock = materialStockService.getMaterialStockById(3);
        System.out.println("修改前:"+materialStock);
        materialStock.setMaterialsum(-100f);
        materialStock.setName("阿里巴巴");
        Integer stock = materialStockService.updateMaterialStock(materialStock);
        TMaterialStock materialStocks = materialStockService.getMaterialStockById(materialStock.getId());
        System.out.println("修改记录数:"+stock+",修改后:"+materialStocks);
    }


    @Test
    public  void testaddMaterialStocksum(){
        Float stocksum = materialStockService.addMaterialStocksum(5, 100f);
        System.out.println(stocksum);
    }

    @Test
    public  void testsubMaterialStocksum(){
        Float stocksum = materialStockService.subMaterialStocksum(5, 100f);
        System.out.println(stocksum);
    }
}
