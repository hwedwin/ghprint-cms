package com.ghprint.cms.services;

import ch.qos.logback.classic.pattern.SyslogStartConverter;
import com.alibaba.fastjson.JSON;
import com.ghprint.cms.model.production.*;
import com.ghprint.cms.pagination.DataGridResult;
import com.ghprint.cms.serviceDao.ProductionMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2017/3/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestProductionService {

    @Autowired
    private  ProductionInfoService productionInfoService;


    @Test
    public void testgetProductionList(){
        DataGridResult dataGridResult =new DataGridResult();
        dataGridResult =productionInfoService.getProductionList(null,null,1,5);
        System.out.println(dataGridResult.getRows().get(0));
        System.out.println(dataGridResult.getRows().get(1));
        String jsonString = JSON.toJSONString(dataGridResult.getRows().get(0));
        System.out.println(jsonString);
        System.out.println(dataGridResult.getTotalCount());
    }


    @Test
    public void testProductionMapper() {
        //创建一个spring容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        //从spring容器中获得Mapper的代理对象
        ProductionMapper productionMapper = applicationContext.getBean(ProductionMapper.class);
        ProductionInfoView  productionInfoView= productionMapper.getOneitem(3);
//        Iterator<ProductionInfoView> iter = list.iterator();
//        while (iter.hasNext()) {
//            System.out.println(iter.next());
//        }
        System.out.println(productionInfoView);
    }




    @Test
    public  void testaddProductionitems(){
        ProductionInfoView productionInfoView = new ProductionInfoView();
        productionInfoView.setCustomerInfo(new TCustomerInfo(100001000 , "太平洋公司"));
        productionInfoView.setProductInfo(new TProductInfo(2002300,"84343432","老干妈","PVC",35.000f,"PVC"));
        productionInfoView.setPrintingData(new TPrintingData("备注", "黑色", 3, "单排", 300, 300, 234, "B151579"));
        productionInfoView.setPrintingProcedure(new TPrintingProcedure("东北", "500*7", 178,45.44f, 24, 232,"备注"));
        productionInfoView.setPrintingProcedureafter(new TPrintingProcedureafter("qualitycheck", 232,23, "109~134", 45, "glueplace", "foldplace", "单排透气孔（用最小最细的牙，牙要浅）", "tearlineplace", "1,7", 3, "901米/卷", "repeatscrollsize", "15000个/卷", 1, 23, "250个*42条=10500个", "大红荔", 2, "专用模","备注"));
        productionInfoView.setProductionStandard(new TProductionStandard("123-23", "3", "PVC", 34, 3,4, "合掌912米/卷、复卷成品米数不可收901米/卷", new Date(), "zhangsan"));
        System.out.println("request param :{"+productionInfoView.toString()+"}");
        productionInfoView = productionInfoService.addProductionitems(productionInfoView);
        String jsonString = JSON.toJSONString(productionInfoView);
        System.out.println(jsonString);
    }

    @Test
    public  void testDELProductionitems(){
      Integer record =   productionInfoService.delProductionitems(3);
        System.out.println(record);
    }

    @Test
    public  void testUpdateProductionitems(){
        ProductionInfoView productionInfoView = new ProductionInfoView();
        productionInfoView=productionInfoService.getProductionitem(1);
        String jsonString = JSON.toJSONString(productionInfoView);
        System.out.println(jsonString);
        productionInfoView.getCustomerInfo().setCompanyname("阿里巴巴");
        productionInfoService.updateProductionitems(productionInfoView);
        System.out.println("操作完成!"+productionInfoService.getProductionitem(1));
    }
}
