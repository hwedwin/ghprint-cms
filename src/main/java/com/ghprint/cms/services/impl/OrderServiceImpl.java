package com.ghprint.cms.services.impl;

import com.ghprint.cms.model.order.OrderInfo;
import com.ghprint.cms.model.order.OrderView;
import com.ghprint.cms.model.order.TPurchaseDetail;
import com.ghprint.cms.model.stock.TMaterialStock;
import com.ghprint.cms.model.stock.TProductionStock;
import com.ghprint.cms.pagination.DataGridResult;
import com.ghprint.cms.serviceDao.TPurchaseDetailMapper;
import com.ghprint.cms.services.MaterialStockService;
import com.ghprint.cms.services.OrderService;
import com.ghprint.cms.services.ProStockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
                log.info("插入：{" + orders + "}条记录...." + order.toString());
            } else {
                log.error("无操作！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("增加订单异常" + e.getMessage());
        }
        log.info("订单增加操作完成，插入：{" + orders + "}条记录." + orderView.toString());
        return orderView;
    }

    @Override
    public Integer delOrderItem(Integer orderId) {
        TPurchaseDetail detail = purchaseDetailMapper.selectByPrimaryKey(orderId);
        Integer record = 0;
        if(detail!=null) {
            detail.setStatus(0);
            record = purchaseDetailMapper.updateByPrimaryKey(detail);
        }
        return record;
    }

    @Override
    public OrderView updateOrderItem(TPurchaseDetail order) {
        return null;
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
}
