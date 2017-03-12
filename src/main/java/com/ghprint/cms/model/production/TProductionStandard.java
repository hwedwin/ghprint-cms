package com.ghprint.cms.model.production;

import java.util.Date;

public class TProductionStandard {
    private Integer id;

    private String codeid;

    private String printingmode;

    private String material;

    private Integer crosswiseshrink;

    private Integer portraitshrink;

    private Integer companyid;

    private Integer productid;

    private Integer printdataid;

    private Integer procedureid;

    private Integer procedureafterid;

    private Integer packaging;

    private String note;

    private Date createtime;

    private String createauthor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodeid() {
        return codeid;
    }

    public void setCodeid(String codeid) {
        this.codeid = codeid == null ? null : codeid.trim();
    }

    public String getPrintingmode() {
        return printingmode;
    }

    public void setPrintingmode(String printingmode) {
        this.printingmode = printingmode == null ? null : printingmode.trim();
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material == null ? null : material.trim();
    }

    public Integer getCrosswiseshrink() {
        return crosswiseshrink;
    }

    public void setCrosswiseshrink(Integer crosswiseshrink) {
        this.crosswiseshrink = crosswiseshrink;
    }

    public Integer getPortraitshrink() {
        return portraitshrink;
    }

    public void setPortraitshrink(Integer portraitshrink) {
        this.portraitshrink = portraitshrink;
    }

    public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public Integer getPrintdataid() {
        return printdataid;
    }

    public void setPrintdataid(Integer printdataid) {
        this.printdataid = printdataid;
    }

    public Integer getProcedureid() {
        return procedureid;
    }

    public void setProcedureid(Integer procedureid) {
        this.procedureid = procedureid;
    }

    public Integer getProcedureafterid() {
        return procedureafterid;
    }

    public void setProcedureafterid(Integer procedureafterid) {
        this.procedureafterid = procedureafterid;
    }

    public Integer getPackaging() {
        return packaging;
    }

    public void setPackaging(Integer packaging) {
        this.packaging = packaging;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getCreateauthor() {
        return createauthor;
    }

    public void setCreateauthor(String createauthor) {
        this.createauthor = createauthor == null ? null : createauthor.trim();
    }

    public TProductionStandard() {
    }

    public TProductionStandard(String codeid, String printingmode, String material, Integer crosswiseshrink, Integer portraitshrink, Integer packaging, String note, Date createtime, String createauthor) {
        this.codeid = codeid;
        this.printingmode = printingmode;
        this.material = material;
        this.crosswiseshrink = crosswiseshrink;
        this.portraitshrink = portraitshrink;
        this.packaging = packaging;
        this.note = note;
        this.createtime = createtime;
        this.createauthor = createauthor;
    }

    @Override
    public String toString() {
        return "TProductionStandard{" +
                "id=" + id +
                ", codeid='" + codeid + '\'' +
                ", printingmode='" + printingmode + '\'' +
                ", material='" + material + '\'' +
                ", crosswiseshrink=" + crosswiseshrink +
                ", portraitshrink=" + portraitshrink +
                ", companyid=" + companyid +
                ", productid=" + productid +
                ", printdataid=" + printdataid +
                ", procedureid=" + procedureid +
                ", procedureafterid=" + procedureafterid +
                ", packaging=" + packaging +
                ", note='" + note + '\'' +
                ", createtime=" + createtime +
                ", createauthor='" + createauthor + '\'' +
                '}';
    }
}