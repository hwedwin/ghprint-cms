package com.ghprint.cms.model.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by Administrator on 2017/4/8.
 */
public class OrderEdit {
    private Integer id;

    private Integer companyid;

    private Integer standardid;

    private Integer orderid;

    private  Integer opid;

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

    private String result;

    public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }

    public Integer getStandardid() {
        return standardid;
    }

    public void setStandardid(Integer standardid) {
        this.standardid = standardid;
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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
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

    public Integer getOpid() {
        return opid;
    }

    public void setOpid(Integer opid) {
        this.opid = opid;
    }

    public OrderEdit() {
    }

    public OrderEdit(Integer id, Integer companyid, Integer standardid,Integer orderid,Integer opid, Date orderdate, Date deline, Integer print, Integer open, Integer merge, Integer cut, Integer stable, Integer repeat, Integer delivery, Integer logistics, String express, String expressnum, String result) {
        this.id = id;
        this.companyid = companyid;
        this.standardid = standardid;
        this.orderid = orderid;
        this.opid =opid;
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

    @Override
    public String toString() {
        return "OrderEdit{" +
                "id=" + id +
                ", companyid=" + companyid +
                ", standardid=" + standardid +
                ", orderid=" + orderid +
                ", opid=" + opid +
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
                ", result='" + result + '\'' +
                '}';
    }
}
