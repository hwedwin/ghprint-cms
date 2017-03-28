package com.ghprint.cms.services;

import com.ghprint.cms.model.production.TCustomerInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2017/3/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestCustomerService {

    @Autowired
    private  CustomerInfoService customerInfoService;

    @Test
    public  void testSelectCustomers(){
        List <TCustomerInfo> list = customerInfoService.selectCustomers();
        Iterator<TCustomerInfo> iter = list.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }


}
