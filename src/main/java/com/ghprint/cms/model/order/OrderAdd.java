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
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date orderdate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date deline;

    private Integer status =1;

    private String result;

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
                ", status=" + status +
                ", result='" + result + '\'' +
                '}';
    }
}
