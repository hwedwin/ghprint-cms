package com.ghprint.cms.model.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class TPurchaseDetail {
    private Integer id;

    private Integer orderid;

    private Integer companyid;

    private Integer productid;

    private Integer stockid;

    private Integer standardid;

    private Integer spellcount = 0;

    private Float proportion = 0f;

    private Float height = 0f;

    private Float thickness = 0f;

    private Float materialsum = 0f;

    private Float purchasebuy = 0f;

    private Integer ordercount = 0;

    private Integer stockcount = 0;

    private Integer productsum = 0;

    private Date orderdate;

    private Date deline;

    private Integer print;

    private Integer open;

    private Integer merge;

    private Integer cut;

    private Integer stable;

    private Integer repeat;

    private Integer delivery;

    private Integer logistics;

    private String express;

    private String expressnum;

    private Integer status =1;

    private String result;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date insertime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public Integer getStockid() {
        return stockid;
    }

    public void setStockid(Integer stockid) {
        this.stockid = stockid;
    }

    public Integer getStandardid() {
        return standardid;
    }

    public void setStandardid(Integer standardid) {
        this.standardid = standardid;
    }

    public Integer getSpellcount() {
        return spellcount;
    }

    public void setSpellcount(Integer spellcount) {
        this.spellcount = spellcount;
    }

    public Float getProportion() {
        return proportion;
    }

    public void setProportion(Float proportion) {
        this.proportion = proportion;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getThickness() {
        return thickness;
    }

    public void setThickness(Float thickness) {
        this.thickness = thickness;
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
    }

    public Integer getOrdercount() {
        return ordercount;
    }

    public void setOrdercount(Integer ordercount) {
        this.ordercount = ordercount;
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
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public Date getDeline() {
        return deline;
    }

    public void setDeline(Date deline) {
        this.deline = deline;
    }

    public Integer getPrint() {
        return print;
    }

    public void setPrint(Integer print) {
        this.print = print;
    }

    public Integer getOpen() {
        return open;
    }

    public void setOpen(Integer open) {
        this.open = open;
    }

    public Integer getMerge() {
        return merge;
    }

    public void setMerge(Integer merge) {
        this.merge = merge;
    }

    public Integer getCut() {
        return cut;
    }

    public void setCut(Integer cut) {
        this.cut = cut;
    }

    public Integer getStable() {
        return stable;
    }

    public void setStable(Integer stable) {
        this.stable = stable;
    }

    public Integer getRepeat() {
        return repeat;
    }

    public void setRepeat(Integer repeat) {
        this.repeat = repeat;
    }

    public Integer getDelivery() {
        return delivery;
    }

    public void setDelivery(Integer delivery) {
        this.delivery = delivery;
    }

    public Integer getLogistics() {
        return logistics;
    }

    public void setLogistics(Integer logistics) {
        this.logistics = logistics;
    }

    public String getExpress() {
        return express;
    }

    public void setExpress(String express) {
        this.express = express == null ? null : express.trim();
    }

    public String getExpressnum() {
        return expressnum;
    }

    public void setExpressnum(String expressnum) {
        this.expressnum = expressnum == null ? null : expressnum.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    public Date getInsertime() {
        return insertime;
    }

    public void setInsertime(Date insertime) {
        this.insertime = insertime;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public TPurchaseDetail() {
    }

    public TPurchaseDetail(Integer companyid, Integer productid, Integer stockid, Integer standardid,Integer orderid, Integer spellcount, Float proportion, Float height, Float thickness, Integer ordercount, Date orderdate, Date deline, Integer print, Integer open, Integer merge, Integer cut, Integer stable, Integer repeat, Integer delivery, Integer logistics, String express, String expressnum, String result) {
        this.companyid = companyid;
        this.productid = productid;
        this.stockid = stockid;
        this.standardid = standardid;
        this.orderid = orderid;
        this.spellcount = spellcount;
        this.proportion = proportion;
        this.height = height;
        this.thickness = thickness;
        this.ordercount = ordercount;
        this.orderdate = orderdate;
        this.deline = deline;
        this.print = print;
        this.open = open;
        this.merge = merge;
        this.cut = cut;
        this.stable = stable;
        this.repeat = repeat;
        this.delivery = delivery;
        this.logistics = logistics;
        this.express = express;
        this.expressnum = expressnum;
        this.result = result;
    }

    public TPurchaseDetail(Integer companyid, Integer productid, Integer stockid, Integer standardid, Integer orderid,Integer spellcount, Float proportion, Float height, Float thickness, Integer ordercount, Date orderdate, Date deline) {
        this.companyid = companyid;
        this.productid = productid;
        this.orderid = orderid;
        this.stockid = stockid;
        this.standardid = standardid;
        this.spellcount = spellcount;
        this.proportion = proportion;
        this.height = height;
        this.thickness = thickness;
        this.ordercount = ordercount;
        this.orderdate = orderdate;
        this.deline = deline;
    }

    @Override
    public String toString() {
        return "TPurchaseDetail{" +
                "id=" + id +
                ", orderid=" + orderid +
                ", companyid=" + companyid +
                ", productid=" + productid +
                ", stockid=" + stockid +
                ", standardid=" + standardid +
                ", spellcount=" + spellcount +
                ", proportion=" + proportion +
                ", height=" + height +
                ", thickness=" + thickness +
                ", materialsum=" + materialsum +
                ", purchasebuy=" + purchasebuy +
                ", ordercount=" + ordercount +
                ", stockcount=" + stockcount +
                ", productsum=" + productsum +
                ", orderdate=" + orderdate +
                ", deline=" + deline +
                ", print=" + print +
                ", open=" + open +
                ", merge=" + merge +
                ", cut=" + cut +
                ", stable=" + stable +
                ", repeat=" + repeat +
                ", delivery='" + delivery + '\'' +
                ", logistics='" + logistics + '\'' +
                ", express='" + express + '\'' +
                ", expressnum='" + expressnum + '\'' +
                ", status=" + status +
                ", result='" + result + '\'' +
                ", insertime=" + insertime +
                '}';
    }
}