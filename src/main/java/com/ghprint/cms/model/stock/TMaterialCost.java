package com.ghprint.cms.model.stock;

import java.util.Date;

public class TMaterialCost {
    private Integer id;

    private Integer stockid;

    private String name;

    private Float income=0f;

    private Float outcount=0f;

    private Float sumcount=0f;

    private Date insertime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStockid() {
        return stockid;
    }

    public void setStockid(Integer stockid) {
        this.stockid = stockid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Float getIncome() {
        return income;
    }

    public void setIncome(Float income) {
        this.income = income;
    }

    public Float getOutcount() {
        return outcount;
    }

    public void setOutcount(Float outcount) {
        this.outcount = outcount;
    }

    public Float getSumcount() {
        return sumcount;
    }

    public void setSumcount(Float sumcount) {
        this.sumcount = sumcount;
    }

    public Date getInsertime() {
        return insertime;
    }

    public void setInsertime(Date insertime) {
        this.insertime = insertime;
    }

    public TMaterialCost() {
    }

    public TMaterialCost(Integer stockid, String name,Float sumcount) {
        this.stockid = stockid;
        this.name = name;
        this.sumcount = sumcount;
        this.insertime= new Date();
    }


    public TMaterialCost(Integer stockid, String name, Float income, Float outcount, Float sumcount, Date insertime) {
        this.stockid = stockid;
        this.name = name;
        this.income = income;
        this.outcount = outcount;
        this.sumcount = sumcount;
        this.insertime = insertime;
    }

    @Override
    public String toString() {
        return "TMaterialCost{" +
                "id=" + id +
                ", stockid=" + stockid +
                ", name='" + name + '\'' +
                ", income=" + income +
                ", outcount=" + outcount +
                ", sumcount=" + sumcount +
                ", insertime=" + insertime +
                '}';
    }
}