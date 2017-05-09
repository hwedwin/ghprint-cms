package com.ghprint.cms.services.impl;

import com.ghprint.cms.model.order.*;
import com.ghprint.cms.model.production.ProductionInfoView;
import com.ghprint.cms.model.production.ProductionInit;
import com.ghprint.cms.model.production.TCustomerInfo;
import com.ghprint.cms.model.stock.TMaterialStock;
import com.ghprint.cms.model.stock.TProductionStock;
import com.ghprint.cms.pagination.DataGridResult;
import com.ghprint.cms.serviceDao.TPurchaseDetailMapper;
import com.ghprint.cms.services.*;
import com.ghprint.cms.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/4/8.
 */
@Service
public class OrderServiceImpl implements OrderService {

    private static Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private TPurchaseDetailMapper purchaseDetailMapper;

    @Autowired
    private MaterialStockService materialStockService;

    @Autowired
    private ProStockService proStockService;

    @Autowired
    private CustomerInfoService customerInfoService;

    @Autowired
    private ProductionInfoService productionInfoService;

    @Autowired
    private  OrderDetailService orderDetailService;

    @Override
    public OrderView addOrderItem(TPurchaseDetail order) {
        OrderView orderView = new OrderView();
        Integer orders = 0;
        try {
            //成品检查以及成品抵扣操作
            if (order.getOrdercount() > 0 && order.getProductid() != null) {
                orderView = this.CheckProStocks(order.getProductid(), order.getOrdercount());
                if (orderView.getProdneed() > 0) {
                    Integer record = proStockService.subStocksum(order.getProductid(), orderView.getProdneed());
                    orderView.setNowprosum(proStockService.getProStockbyId(order.getProductid()).getStocksum());
                    orderView.setMaterialsum(materialStockService.getMaterialStockById(order.getStockid()).getMaterialsum());
                    orderView.setNowmaterialsum(orderView.getMaterialsum());
                    log.info("抵扣成品库存成功！应抵扣量:{}", orderView.getProdneed());
                }
                //原材料检查以及操作
                if (orderView.getProflag() == 0 && orderView.getProductsum() > 0 && order.getStockid() != null) {
                    Float sub = this.materialSub(orderView.getProductsum(), order);
                    if (sub > 0) {
                        OrderView view = this.CheckMaterialStocks(order.getStockid(), sub);
                        float sum = materialStockService.subMaterialStocksum(order.getStockid(), sub);
                        log.info("抵扣材料库存不足！应抵扣量:{},需采购量{}", view.getMaterialneed(), view.getPurchasebuy());
                        orderView.setMaterialflag(view.getMaterialflag());
                        orderView.setMaterialneed(view.getMaterialneed());
                        orderView.setMaterialsum(view.getMaterialsum());
                        orderView.setNowmaterialsum(sum);
                        if (view.getPurchasebuy() > 0) {
                            orderView.setPurchasebuy(view.getPurchasebuy());
                        }
                    }
                }

                //订单入表
                order.setMaterialsum(orderView.getNowmaterialsum());
                order.setPurchasebuy(orderView.getPurchasebuy());
                order.setStockcount(orderView.getNowprosum());
                order.setProductsum(orderView.getProductsum());
                order.setInsertime(new Date());
                orders = purchaseDetailMapper.insertSelective(order);
                orderView.setOrderid(order.getId());
                orderView.setInsertime(DateUtil.getTime());
                orders +=orderDetailService.addOrderDetail(orderView);
                log.info("订单增加操作完成,插入：{" + orders + "}条记录....\n" + order.toString()+"\n"+orderView.toString());
            } else {
                log.error("无操作！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("增加订单异常" + e.getMessage());
            return  null;
        }
        return orderView;
    }

    @Override
    public Integer delOrderItem(Integer orderId) {
        TPurchaseDetail detail = purchaseDetailMapper.selectByPrimaryKey(orderId);
        Integer record = 0;
        if(detail!=null) {
            detail.setStatus(0);
            record = purchaseDetailMapper.updateByPrimaryKeySelective(detail);
        }
        return record;
    }

    @Override
    public Integer updateOrderItem(OrderEdit order) {
        TPurchaseDetail detail = purchaseDetailMapper.selectByPrimaryKey(order.getId());
        if(order.getCompanyid()!=null) {
            detail.setCompanyid(order.getCompanyid());
        }
        if(order.getStandardid()!=null){
            detail.setStandardid(order.getStandardid());
        }
        if(order.getOrderdate()!=null){
            detail.setOrderdate(order.getOrderdate());
        }
        if(order.getDeline()!=null){
            detail.setDeline(order.getDeline());
        }
        if(order.getPrint()!=null){
            detail.setPrint(order.getPrint());
        }
        if(order.getOpen()!=null){
            detail.setOpen(order.getOpen());
        }
        if(order.getMerge()!=null){
            detail.setMerge(order.getMerge());
        }
        if(order.getCut()!=null){
            detail.setCut(order.getCut());
        }
        if(order.getStable()!=null){
            detail.setStable(order.getStable());
        }
        if(order.getRepeat()!=null){
            detail.setRepeat(order.getRepeat());
        }
        if(order.getDelivery()!=null){
            detail.setDelivery(order.getDelivery());
        }
        if(order.getLogistics()!=null){
            detail.setLogistics(order.getLogistics());
        }
        if(order.getExpress()!=null){
            detail.setExpress(order.getExpress());
        }
        if(order.getExpressnum()!=null){
            detail.setExpressnum(order.getExpressnum());
        }
        if(order.getResult()!=null){
            detail.setResult(order.getResult());
        }
        if(order.getOrderid()!=null){
            detail.setOrderid(order.getOrderid());
        }
        Integer key = purchaseDetailMapper.updateByPrimaryKey(detail);
        return key;
    }

    @Override
    public DataGridResult selectOrderList(String key, String value, Integer page, Integer rows) {
        Integer pageOffset = (page-1)*rows;
        List<OrderInfo> list = purchaseDetailMapper.selectlist(pageOffset,rows,key,value);
        DataGridResult dataGridResult = new DataGridResult();
        if(list!=null) {
            dataGridResult.setRows(list);
            Integer sum = purchaseDetailMapper.getlistcount(key,value);
            dataGridResult.setTotalCount(sum);
            dataGridResult.setCurrentPage(page);
            dataGridResult.setEveryPage(rows);
            dataGridResult.setTotalPage((sum-1)/rows+1);
        }
        return dataGridResult;
    }

    @Override
    public OrderInfo getOrderItemById(Integer orderId) {
        OrderInfo oneitem = purchaseDetailMapper.getOneitem(orderId);
        return oneitem==null?null:oneitem;
    }

    @Override
    public OrderView CheckProStocks(Integer productid, Integer ordercount) {

        OrderView orderView = new OrderView();
        try {
            TProductionStock productionStock = proStockService.getProStockbyId(productid);
            if (productionStock != null && ordercount > 0) {
                Integer stocksum = productionStock.getStocksum();
                Integer change = stocksum - ordercount;
                if (change >= 0) {
                    orderView.setStockcount(stocksum);
                    orderView.setProdneed(ordercount);
                } else {
                    orderView.setStockcount(stocksum);
                    orderView.setProdneed(ordercount);
                    orderView.setProductsum(-change);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("检查成品库存异常" + e.getMessage());
            return null;
        }
        return orderView;
    }

    @Override
    public Float materialSub(Integer needsum, TPurchaseDetail order) {
        float materialsub = 0f;
        if (order.getStockid() != null && needsum > 0 && order.getSpellcount() > 0) {
            TMaterialStock materialStock = materialStockService.getMaterialStockById(order.getStockid());
            Float size = materialStock.getSpecification() / order.getSpellcount();
            materialsub = needsum * size * order.getProportion() * order.getHeight() * order.getThickness();
            BigDecimal b = new BigDecimal(materialsub);
            materialsub = b.setScale(3, BigDecimal.ROUND_HALF_UP).floatValue();
        } else {
            materialsub = -1;
        }
        return materialsub;
    }

    @Override
    public OrderView CheckMaterialStocks(Integer stockid, Float sub) {
        OrderView orderView = new OrderView();
        try {
            TMaterialStock materialStock = materialStockService.getMaterialStockById(stockid);
            if (materialStock != null && sub > 0) {
                float materialsum = materialStock.getMaterialsum();
                float change = materialsum - sub;
                if (change >= 0) {
                    orderView.setMaterialsum(materialsum);
                    orderView.setMaterialneed(sub);
                    orderView.setMaterialflag(1);
                } else {
                    orderView.setMaterialsum(materialsum);
                    orderView.setMaterialneed(sub);
                    orderView.setPurchasebuy(-change);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("检查原材料库存异常" + e.getMessage());
            return null;
        }
        return orderView;
    }

    @Override
    public OrderInit getProductionInit(Boolean company, Boolean product, Boolean material, Boolean standard) {
        OrderInit orderInit = new OrderInit();
        List<OrderDictionary> list1 = new ArrayList<>();
        List<OrderDictionary> list2 = new ArrayList<>();
        List<OrderDictionary> list3 = new ArrayList<>();
        List<OrderDictionary> list4 = new ArrayList<>();
        if(company){
            List<TCustomerInfo> customerInfos = customerInfoService.selectCustomers();
            if(customerInfos.size()>0){
                for(int i = 0;i<customerInfos.size();i++){
                    OrderDictionary orderDictionary = new OrderDictionary();
                    orderDictionary.setId(customerInfos.get(i).getId());
                    orderDictionary.setNote1(customerInfos.get(i).getCompanycode().toString());
                    orderDictionary.setNote2(customerInfos.get(i).getCompanyname());
                    list1.add(orderDictionary);
                }
            }
            orderInit.setCompany(list1);
        }


        if(product){
            List<TProductionStock> productionStocks = proStockService.selectAllist();
            if(productionStocks.size()>0){
                for(int i = 0;i<productionStocks.size();i++){
                    OrderDictionary orderDictionary = new OrderDictionary();
                    orderDictionary.setId(productionStocks.get(i).getId());
                    orderDictionary.setNote1(productionStocks.get(i).getStockid().toString());
                    orderDictionary.setNote2(productionStocks.get(i).getStockname());
                    orderDictionary.setNote3(productionStocks.get(i).getColor());
                    list2.add(orderDictionary);
                }
            }
            orderInit.setProduct(list2);
        }


        if(material){
            List<TMaterialStock> materialStocks = materialStockService.selectAllist();
            if(materialStocks.size()>0){
                for(int i = 0;i<materialStocks.size();i++){
                    OrderDictionary orderDictionary = new OrderDictionary();
                    orderDictionary.setId(materialStocks.get(i).getId());
                    orderDictionary.setNote1(materialStocks.get(i).getName().toString());
                    orderDictionary.setNote2(materialStocks.get(i).getProvider());
                    orderDictionary.setNote3(materialStocks.get(i).getSpecification().toString());
                    list3.add(orderDictionary);
                }
            }
            orderInit.setMaterial(list3);
        }

        if(standard){
            List<ProductionInfoView> productionInfoViews = productionInfoService.selectAllist();
            if(productionInfoViews.size()>0){
                for(int i = 0;i<productionInfoViews.size();i++){
                    OrderDictionary orderDictionary = new OrderDictionary();
                    orderDictionary.setId(productionInfoViews.get(i).getPid());
                    orderDictionary.setNote1(productionInfoViews.get(i).getProductionStandard().getPrintingmode());
                    orderDictionary.setNote2(productionInfoViews.get(i).getProductionStandard().getMaterial());
                    orderDictionary.setNote3(productionInfoViews.get(i).getProductionStandard().getNote());
                    list4.add(orderDictionary);
                }
            }
            orderInit.setStandard(list4);
        }
        return orderInit;
    }

    @Override
    public OrderEdit getOrderEdit(Integer orderId) {
        OrderEdit order = purchaseDetailMapper.getEditOrder(orderId);
        OrderInit orderInit = this.getProductionInit(true, false, false, true);
                    if (orderInit != null && order != null) {
                        List<OrderDictionary> company = orderInit.getCompany();
                        for (int i = 0; i < company.size(); i++) {
                            if (company.get(i).getId() == order.getCompanyid()) {
                                log.info("公司ID：{} ，INDEX：{}",order.getCompanyid(),i+1);
                               order.setCompanyid(i + 1);
                                break;
                            }
                        }
                        List<OrderDictionary>  standard= orderInit.getStandard();
                        for(int i=0;i<standard.size(); i++){
                            if(standard.get(i).getId() ==  order.getStandardid()){
                                log.info("生产标准ID：{} ，INDEX：{}",order.getStandardid(),i+1);
                                order.setStandardid(i+1);
                                break;
                            }
                        }
                    }
        return   order==null?null : order ;
    }
}
