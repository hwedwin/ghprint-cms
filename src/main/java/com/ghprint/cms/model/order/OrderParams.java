package com.ghprint.cms.model.order;

/**
 * Created by lipeiting on 2017/6/13.
 */
public class OrderParams {

    private Integer oid;

    private String stockname;

    private String color;

    private Integer productid;

    private String provider;

    private String name;

    private Float specification;

    private Integer materialid;

    private  Float materialsum = 0f;

    private  Integer stocksum  = 0;

    private Integer spellcount = 0;

    private Float proportion = 0f;

    private Float height = 0f;

    private Float thickness = 0f;

    private  String note ;

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
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

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
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

    public Integer getMaterialid() {
        return materialid;
    }

    public void setMaterialid(Integer materialid) {
        this.materialid = materialid;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "OrderParams{" +
                "oid=" + oid +
                ", stockname='" + stockname + '\'' +
                ", color='" + color + '\'' +
                ", productid=" + productid +
                ", provider='" + provider + '\'' +
                ", name='" + name + '\'' +
                ", specification=" + specification +
                ", materialid=" + materialid +
                ", materialsum=" + materialsum +
                ", stocksum=" + stocksum +
                ", spellcount=" + spellcount +
                ", proportion=" + proportion +
                ", height=" + height +
                ", thickness=" + thickness +
                ", note='" + note + '\'' +
                '}';
    }
}
