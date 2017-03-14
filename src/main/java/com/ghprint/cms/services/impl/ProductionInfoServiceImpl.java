package com.ghprint.cms.services.impl;

import com.ghprint.cms.model.production.ProductionInfoView;
import com.ghprint.cms.pagination.DataGridResult;
import com.ghprint.cms.serviceDao.*;
import com.ghprint.cms.services.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/3/1.
 */
@Service
public class ProductionInfoServiceImpl implements ProductionInfoService {

    private static Logger logger = LoggerFactory.getLogger(ProductionInfoServiceImpl.class);

    @Autowired
    private ProductionMapper productionMapper;
    @Autowired
    private CustomerInfoService customerInfoService;
    @Autowired
    private PrintingProcedureService printingProcedureService;
    @Autowired
    private ProductionService productionService;
    @Autowired
    private PrintingDataService printingDataService;
    @Autowired
    private PrintingProcedureafterService printingProcedureafterService;

    @Autowired
    private  ProductionStandardService  productionStandardService;

    /*
    * 增加生产标准
    * */
    @Override
    public ProductionInfoView addProductionitems(ProductionInfoView productionInfoView) {
        try {
            logger.info("Insert into CustomerInfo:{}", productionInfoView.getCustomerInfo());
            //客户信息
            Integer record = customerInfoService.addCustomerInfo(productionInfoView.getCustomerInfo());
            logger.info("Insert into CustomerInfo seccess:{}", record);

            logger.info("Insert into ProductInfo:{}", productionInfoView.getProductInfo());
            //产品信息
            record =productionService.addProduction(productionInfoView.getProductInfo());
            logger.info("Insert into ProductInfo seccess:{}", record);

            //印刷数据
            logger.info("Insert into PrintdataInfo:{}",productionInfoView.getPrintingData());
            record = printingDataService.addPrintingData(productionInfoView.getPrintingData());
            logger.info("Insert into PrintdataInfo seccess:{}",record);

            //印刷工序
            logger.info("Insert into PrintProcedure:{}",productionInfoView.getPrintingProcedure());
            record = printingProcedureService.addPrintingProcedure(productionInfoView.getPrintingProcedure());
            logger.info("Insert into PrintProcedure seccess:{}",record);

            //印刷后工序
            logger.info("Insert into PrintingProcedureafter:{}",productionInfoView.getPrintingProcedureafter());
            record = printingProcedureafterService.addPrintingProcedureafter(productionInfoView.getPrintingProcedureafter());
            logger.info("Insert into PrintingProcedureafter seccess:{}",record);

            //生产标准
            productionInfoView.getProductionStandard().setCompanyid(productionInfoView.getCustomerInfo().getId());
            productionInfoView.getProductionStandard().setPrintdataid(productionInfoView.getPrintingData().getId());
            productionInfoView.getProductionStandard().setProductid(productionInfoView.getProductInfo().getId());
            productionInfoView.getProductionStandard().setProcedureid(productionInfoView.getPrintingProcedure().getId());
            productionInfoView.getProductionStandard().setProcedureafterid(productionInfoView.getPrintingProcedureafter().getId());
            logger.info("Insert into productionStandard:{}",productionInfoView.getProductionStandard());
            record = productionStandardService.addProductionStandardService(productionInfoView.getProductionStandard());
            logger.info("Insert into productionStandard seccess:{}",record);

            logger.info("Insert into production seccess!!!");
        }  catch (Exception e) {
        logger.error("Insert_Exception:{}",e.toString());
        e.printStackTrace();
            return  null ;
        }
        return productionInfoView;
    }

    /*
        * 查询生产质量标准列表
        * */
    @Override
    public DataGridResult getProductionList(String key,String value, Integer page, Integer rows) {
        DataGridResult dataGridResult = new DataGridResult();
        Integer pageOffset = (page-1)*rows;
       List<ProductionInfoView> list =productionMapper.selectlist(pageOffset,rows,key,value);
        if(list != null ) {
            dataGridResult.setRows(list);
            Integer sum = productionMapper.getlistcount(key,value);
            dataGridResult.setTotalCount(sum);
            dataGridResult.setCurrentPage(page);
            dataGridResult.setEveryPage(rows);
            dataGridResult.setTotalPage(sum / rows);
        }
        return dataGridResult;
    }

    @Override
    public Integer delProductionitems(Integer pid) {
        return null;
    }
}
