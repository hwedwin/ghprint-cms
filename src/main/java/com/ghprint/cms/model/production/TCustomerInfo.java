package com.ghprint.cms.model.production;

public class TCustomerInfo {
    private Integer id;

    private Integer companycode;

    private String companyname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        this.companyname = companyname == null ? null : companyname.trim();
    }

    public TCustomerInfo(Integer companycode, String companyname) {
        this.companycode = companycode;
        this.companyname = companyname;
    }

    public TCustomerInfo() {
    }

    @Override
    public String toString() {
        return "TCustomerInfo{" +
                "id=" + id +
                ", companycode=" + companycode +
                ", companyname='" + companyname + '\'' +
                '}';
    }
}