package com.ghprint.cms.model.stock;

public class TProductionStock {
    private Integer id;

    private Integer customerid;

    private String stockid;

    private String stockname;

    private String color;

    private Integer count;

    private Integer boxcount;

    private Integer remain;

    private Integer stocksum;

    private Float price;

    private Float amount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Integer customerid) {
        this.customerid = customerid;
    }

    public String getStockid() {
        return stockid;
    }

    public void setStockid(String stockid) {
        this.stockid = stockid == null ? null : stockid.trim();
    }

    public String getStockname() {
        return stockname;
    }

    public void setStockname(String stockname) {
        this.stockname = stockname == null ? null : stockname.trim();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getBoxcount() {
        return boxcount;
    }

    public void setBoxcount(Integer boxcount) {
        this.boxcount = boxcount;
    }

    public Integer getRemain() {
        return remain;
    }

    public void setRemain(Integer remain) {
        this.remain = remain;
    }

    public Integer getStocksum() {
        return stocksum;
    }

    public void setStocksum(Integer stocksum) {
        this.stocksum = stocksum;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public TProductionStock(Integer customerid, String stockid, String stockname, String color, Integer count, Integer boxcount, Integer remain, Integer stocksum, Float price, Float amount) {
        this.customerid = customerid;
        this.stockid = stockid;
        this.stockname = stockname;
        this.color = color;
        this.count = count;
        this.boxcount = boxcount;
        this.remain = remain;
        this.stocksum = stocksum;
        this.price = price;
        this.amount = amount;
    }

    public TProductionStock() {
    }

    @Override
    public String toString() {
        return "TProductionStock{" +
                "id=" + id +
                ", customerid=" + customerid +
                ", stockid='" + stockid + '\'' +
                ", stockname='" + stockname + '\'' +
                ", color='" + color + '\'' +
                ", count=" + count +
                ", boxcount=" + boxcount +
                ", remain=" + remain +
                ", stocksum=" + stocksum +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }
}