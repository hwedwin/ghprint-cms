package com.ghprint.cms.model.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by Administrator on 2017/4/8.
 */
public class OrderInfo {

    private Integer oid;

    private  Integer orderid;

    private Integer companycode;

    private String companyname;

    private String provider;

    private String name;

    private Float specification;

    private String stockname;

    private String color;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date orderdate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
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

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getCompanycode() {
        return companycode;
    }

    public void setCompanycode(Integer companycode) {
        this.companycode = companycode;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getSpecification() {
        return specification;
    }

    public void setSpecification(Float specification) {
        this.specification = specification;
    }

    public String getStockname() {
        return stockname;
    }

    public void setStockname(String stockname) {
        this.stockname = stockname;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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
        this.express = express;
    }

    public String getExpressnum() {
        return expressnum;
    }

    public void setExpressnum(String expressnum) {
        this.expressnum = expressnum;
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
        this.result = result;
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

    public OrderInfo() {
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "oid=" + oid +
                ", orderid=" + orderid +
                ", companycode=" + companycode +
                ", companyname='" + companyname + '\'' +
                ", provider='" + provider + '\'' +
                ", name='" + name + '\'' +
                ", specification=" + specification +
                ", stockname='" + stockname + '\'' +
                ", color='" + color + '\'' +
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
                ", delivery=" + delivery +
                ", logistics=" + logistics +
                ", express='" + express + '\'' +
                ", expressnum='" + expressnum + '\'' +
                ", status=" + status +
                ", result='" + result + '\'' +
                ", insertime=" + insertime +
                '}';
    }
}
