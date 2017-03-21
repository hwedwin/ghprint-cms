package com.ghprint.cms.services.impl;

import com.ghprint.cms.model.production.*;
import com.ghprint.cms.pagination.DataGridResult;
import com.ghprint.cms.serviceDao.*;
import com.ghprint.cms.services.*;
import org.apache.commons.lang.StringUtils;
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
            dataGridResult.setTotalPage((sum-1)/rows+1);
        }
        return dataGridResult;
    }

    @Override
    public Integer delProductionitems(Integer pid) {
        return productionStandardService.delProductionStandardService(pid);
    }

    @Override
    public ProductionInfoView getProductionitem(Integer pid) {
        ProductionInfoView p = new ProductionInfoView();
        if(pid != null){
         p  =   productionMapper.getOneitem(pid);
            p.getCustomerInfo().setId(p.getProductionStandard().getCompanyid());
            p.getPrintingProcedure().setId(p.getProductionStandard().getProcedureid());
            p.getPrintingProcedureafter().setId(p.getProductionStandard().getProcedureafterid());
            p.getPrintingData().setId(p.getProductionStandard().getPrintdataid());
            p.getProductInfo().setId(p.getProductionStandard().getProductid());
        }
        return  p;
    }

    @Override
    public Integer updateProductionitems(ProductionInfoView productionInfoView) {
        Integer record = 0;

        try {
            if (productionInfoView.getPid() != null) {
                TCustomerInfo customerInfo = productionInfoView.getCustomerInfo();
                TProductInfo productInfo = productionInfoView.getProductInfo();
                TPrintingData printingData = productionInfoView.getPrintingData();
                TPrintingProcedure printingProcedure = productionInfoView.getPrintingProcedure();
                TPrintingProcedureafter printingProcedureafter = productionInfoView.getPrintingProcedureafter();
                TProductionStandard productionStandard = productionInfoView.getProductionStandard();
                logger.info("Service request param:{}", productionInfoView.toString());
                logger.info("1---UPDATE  CustomerInfo by ID:{}----", productionInfoView.getCustomerInfo().getId());
                if (customerInfo.getId() != null) {
                    record += customerInfoService.updateCustomerInfo(customerInfo);
                }
                logger.info("1===UPDATE  CustomerInfo record:{}====", record);
                logger.info("2---UPDATE  ProductionInfo by ID:{}----", productionInfoView.getProductInfo().getId());
                if (productInfo.getId() != null) {
                    record += productionService.updateProduction(productInfo);
                }
                logger.info("2===UPDATE  ProdutionInfo record:{}====", record);
                logger.info("3---UPDATE  PrintingProcedure by ID:{}----", productionInfoView.getPrintingProcedure().getId());
                if (printingProcedure.getId() != null) {
                    record += printingProcedureService.updataPrintingProcedure(printingProcedure);
                }
                logger.info("3===UPDATE  PrintingProcedure record:{}====", record);
                logger.info("4---UPDATE  PrintingData by ID:{}----", productionInfoView.getPrintingData().getId());
                if (printingData.getId() != null) {
                    record += printingDataService.updatePrintingData(printingData);
                }
                logger.info("4===UPDATE  PrintingData record:{}====", record);
                logger.info("5---UPDATE  PrintingProceduceafter by ID:{}----", productionInfoView.getPrintingProcedureafter().getId());
                if (printingProcedureafter.getId() != null) {
                    record += printingProcedureafterService.updatePrintingProcedureafter(printingProcedureafter);
                }
                logger.info("5===UPDATE  PrintingProcedureafter record:{}====", record);
                logger.info("6---UPDATE  ProductionStandard by ID:{}----", productionInfoView.getProductionStandard().getId());
                if (productionStandard.getId() != null) {
                    productionStandard.setProductid(productInfo.getId());
                    productionStandard.setPrintdataid(printingData.getId());
                    productionStandard.setCompanyid(customerInfo.getId());
                    productionStandard.setProcedureid(printingProcedure.getId());
                    productionStandard.setProcedureafterid(printingProcedureafter.getId());
                    record += productionStandardService.updateProductionStandardService(productionStandard);
                }
                logger.info("6===UPDATE  ProductionStandard record:{}====", record);

                logger.info("00000===updateProductionitems FINISH!!====");
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("===updateProductionitems FAIL:{}====",e);
        }
        return record;
    }
}
