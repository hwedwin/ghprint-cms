package com.ghprint.cms.model.order;

public class TOrderParams {
    private Integer id;

    private Integer productid;

    private Integer materialid;

    private Integer spellcount;

    private Float proportion;

    private Float height;

    private Float thickness;

    private Float materialsum;

    private Integer stocksum;

    private String note;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public Integer getMaterialid() {
        return materialid;
    }

    public void setMaterialid(Integer materialid) {
        this.materialid = materialid;
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

    public Integer getStocksum() {
        return stocksum;
    }

    public void setStocksum(Integer stocksum) {
        this.stocksum = stocksum;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public TOrderParams() {
    }

    public TOrderParams(Integer productid, Integer materialid, Integer spellcount, Float proportion, Float height, Float thickness, String note) {
        this.productid = productid;
        this.materialid = materialid;
        this.spellcount = spellcount;
        this.proportion = proportion;
        this.height = height;
        this.thickness = thickness;
        this.note = note;
    }

    @Override
    public String toString() {
        return "TOrderParams{" +
                "id=" + id +
                ", productid=" + productid +
                ", materialid=" + materialid +
                ", spellcount=" + spellcount +
                ", proportion=" + proportion +
                ", height=" + height +
                ", thickness=" + thickness +
                ", materialsum=" + materialsum +
                ", stocksum=" + stocksum +
                ", note='" + note + '\'' +
                '}';
    }
}