package com.ghprint.cms.model.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by lipeiting on 2017/6/14.
 */
public class OrderAdd {
    private Integer id;

    private Integer companyid;

    private Integer standardid;

    private Integer orderparamsid;

    private Integer orderid;

    private Integer ordercount = 0;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date orderdate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
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


    private Integer status = 1;

    private String result;

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

    public Integer getStandardid() {
        return standardid;
    }

    public void setStandardid(Integer standardid) {
        this.standardid = standardid;
    }

    public Integer getOrderparamsid() {
        return orderparamsid;
    }

    public void setOrderparamsid(Integer orderparamsid) {
        this.orderparamsid = orderparamsid;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Integer getOrdercount() {
        return ordercount;
    }

    public void setOrdercount(Integer ordercount) {
        this.ordercount = ordercount;
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

    public OrderAdd() {
    }

    public OrderAdd(Integer companyid, Integer standardid, Integer orderparamsid, Integer orderid, Integer ordercount, Date orderdate, Date deline, String result) {
        this.companyid = companyid;
        this.standardid = standardid;
        this.orderparamsid = orderparamsid;
        this.orderid = orderid;
        this.ordercount = ordercount;
        this.orderdate = orderdate;
        this.deline = deline;
        this.result = result;
    }

    @Override
    public String toString() {
        return "OrderAdd{" +
                "id=" + id +
                ", companyid=" + companyid +
                ", standardid=" + standardid +
                ", orderparamsid=" + orderparamsid +
                ", orderid=" + orderid +
                ", ordercount=" + ordercount +
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
                '}';
    }
}
