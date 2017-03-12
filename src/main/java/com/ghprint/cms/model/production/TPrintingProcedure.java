package com.ghprint.cms.model.production;

public class TPrintingProcedure {
    private Integer id;

    private String printdirect;

    private String specification;

    private Integer printamount;

    private Float printweight;

    private Integer printmeter;

    private Integer wastage;

    private String procedurenote;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrintdirect() {
        return printdirect;
    }

    public void setPrintdirect(String printdirect) {
        this.printdirect = printdirect == null ? null : printdirect.trim();
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification == null ? null : specification.trim();
    }

    public Integer getPrintamount() {
        return printamount;
    }

    public void setPrintamount(Integer printamount) {
        this.printamount = printamount;
    }

    public Float getPrintweight() {
        return printweight;
    }

    public void setPrintweight(Float printweight) {
        this.printweight = printweight;
    }

    public Integer getPrintmeter() {
        return printmeter;
    }

    public void setPrintmeter(Integer printmeter) {
        this.printmeter = printmeter;
    }

    public Integer getWastage() {
        return wastage;
    }

    public void setWastage(Integer wastage) {
        this.wastage = wastage;
    }

    public String getProcedurenote() {
        return procedurenote;
    }

    public void setProcedurenote(String procedurenote) {
        this.procedurenote = procedurenote == null ? null : procedurenote.trim();
    }

    public TPrintingProcedure() {
    }

    public TPrintingProcedure(String printdirect, String specification, Integer printamount, Float printweight, Integer printmeter, Integer wastage, String procedurenote) {
        this.printdirect = printdirect;
        this.specification = specification;
        this.printamount = printamount;
        this.printweight = printweight;
        this.printmeter = printmeter;
        this.wastage = wastage;
        this.procedurenote = procedurenote;
    }

    @Override
    public String toString() {
        return "TPrintingProcedure{" +
                "id=" + id +
                ", printdirect='" + printdirect + '\'' +
                ", specification='" + specification + '\'' +
                ", printamount=" + printamount +
                ", printweight=" + printweight +
                ", printmeter=" + printmeter +
                ", wastage=" + wastage +
                ", procedurenote='" + procedurenote + '\'' +
                '}';
    }
}