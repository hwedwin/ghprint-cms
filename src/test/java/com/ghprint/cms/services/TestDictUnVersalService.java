package com.ghprint.cms.services;

import com.alibaba.fastjson.JSON;
import com.ghprint.cms.model.production.ProductionInit;
import com.ghprint.cms.model.sys.DictItemVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Iterator;
import java.util.List;


/**
 * Created by Administrator on 2017/2/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestDictUnVersalService {

    @Autowired
    private  DictUnVersalService dictUnVersalService;

    @Test
    public void testfindDictItems() throws  Exception{
        List list = dictUnVersalService.findDictItems("packaging");
        Iterator iter = list.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
    }

    @Test
    public  void testgetDicItemName() throws  Exception{
       String result =  dictUnVersalService.getDicItemName("packaging","1");
        System.out.println(result);
    }


    @Test
    public  void testProdctionInit(){
        List <DictItemVO> packaging= dictUnVersalService.findDictItems("packaging");
        List <DictItemVO> printingmode = dictUnVersalService.findDictItems("printingmode");
        ProductionInit productionInit = new ProductionInit(packaging,printingmode);
        String jsonString = JSON.toJSONString(productionInit);
        System.out.println("jsonString:" + jsonString);
    }

}
