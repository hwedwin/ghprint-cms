package com.ghprint.cms.model.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by Administrator on 2017/4/8.
 */
public class OrderView {

    private Integer id;

    private Integer orderid;
    //原材料库存量
    private Float materialsum=0f;
    //原材料采购量
    private Float purchasebuy=0f;
    //原材料抵扣量
    private Float materialneed=0f;
    //成品库存量
    private Integer stockcount=0;
    //成品需生产量
    private Integer productsum=0;
    //成品抵扣量
    private  Integer prodneed=0;
    //原材料标志  0：没有抵扣  1：抵扣成功够 -1：抵扣不足没抵扣
    private  Integer materialflag = 0;
    //成品标志 0:抵扣成功不够  1:抵扣成功够
    private  Integer proflag=1;
    //操作后成品库存量
    private  Integer nowprosum=0;
    //操作后原材料库存量
    private  Float nowmaterialsum = 0f;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date insertime ;

    public OrderView() {
    }

    public Float getMaterialsum() {
        return materialsum;
    }

    public void setMaterialsum(Float materialsum) {
        this.materialsum = materialsum;
    }

    public Float getPurchasebuy() {
        return purchasebuy;
    }

    public void setPurchasebuy(Float purchasebuy) {
        this.purchasebuy = purchasebuy;
        this.materialflag = -1 ;
    }

    public Float getMaterialneed() {
        return materialneed;
    }

    public void setMaterialneed(Float materialneed) {
        this.materialneed = materialneed;
        this.proflag = 0 ;
    }

    public Integer getStockcount() {
        return stockcount;
    }

    public void setStockcount(Integer stockcount) {
        this.stockcount = stockcount;
    }

    public Integer getProductsum() {
        return productsum;
    }

    public void setProductsum(Integer productsum) {
        this.productsum = productsum;
        this.proflag = 0;
    }

    public Integer getProdneed() {
        return prodneed;
    }

    public void setProdneed(Integer prodneed) {
        this.prodneed = prodneed;
    }

    public Integer getMaterialflag() {
        return materialflag;
    }

    public void setMaterialflag(Integer materialflag) {
        this.materialflag = materialflag;
    }

    public Integer getProflag() {
        return proflag;
    }

    public void setProflag(Integer proflag) {
        this.proflag = proflag;
    }

    public Integer getNowprosum() {
        return nowprosum;
    }

    public void setNowprosum(Integer nowprosum) {
        this.nowprosum = nowprosum;
    }

    public Float getNowmaterialsum() {
        return nowmaterialsum;
    }

    public void setNowmaterialsum(Float nowmaterialsum) {
        this.nowmaterialsum = nowmaterialsum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Date getInsertime() {
        return insertime;
    }

    public void setInsertime(Date insertime) {
        this.insertime = insertime;
    }

    @Override
    public String toString() {
        return "OrderView{" +
                "id=" + id +
                ", orderId=" + orderid +
                ", materialsum=" + materialsum +
                ", purchasebuy=" + purchasebuy +
                ", materialneed=" + materialneed +
                ", stockcount=" + stockcount +
                ", productsum=" + productsum +
                ", prodneed=" + prodneed +
                ", materialflag=" + materialflag +
                ", proflag=" + proflag +
                ", nowprosum=" + nowprosum +
                ", nowmaterialsum=" + nowmaterialsum +
                ", insertime=" + insertime +
                '}';
    }
}
