package com.ghprint.cms.model.production;

public class TPrintingProcedureafter {
    private Integer id;

    private String qualitycheck;

    private Integer splitsizr;

    private Integer transparentkeep;

    private String mergesize;

    private Integer splithigh;

    private String glueplace;

    private String foldplace;

    private String tearlinesize;

    private String tearlineplace;

    private String productstyle;

    private Integer scrolldirection;

    private String scrolllength;

    private String repeatscrollsize;

    private String proceduresum;

    private Integer interfacecount;

    private Integer hemcount;

    private String boxway;

    private String boxsize;

    private Integer splitsum;

    private String mould;

    private  String note;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQualitycheck() {
        return qualitycheck;
    }

    public void setQualitycheck(String qualitycheck) {
        this.qualitycheck = qualitycheck == null ? null : qualitycheck.trim();
    }

    public Integer getSplitsizr() {
        return splitsizr;
    }

    public void setSplitsizr(Integer splitsizr) {
        this.splitsizr = splitsizr;
    }

    public Integer getTransparentkeep() {
        return transparentkeep;
    }

    public void setTransparentkeep(Integer transparentkeep) {
        this.transparentkeep = transparentkeep;
    }

    public String getMergesize() {
        return mergesize;
    }

    public void setMergesize(String mergesize) {
        this.mergesize = mergesize == null ? null : mergesize.trim();
    }

    public Integer getSplithigh() {
        return splithigh;
    }

    public void setSplithigh(Integer splithigh) {
        this.splithigh = splithigh;
    }

    public String getGlueplace() {
        return glueplace;
    }

    public void setGlueplace(String glueplace) {
        this.glueplace = glueplace == null ? null : glueplace.trim();
    }

    public String getFoldplace() {
        return foldplace;
    }

    public void setFoldplace(String foldplace) {
        this.foldplace = foldplace == null ? null : foldplace.trim();
    }

    public String getTearlinesize() {
        return tearlinesize;
    }

    public void setTearlinesize(String tearlinesize) {
        this.tearlinesize = tearlinesize == null ? null : tearlinesize.trim();
    }

    public String getTearlineplace() {
        return tearlineplace;
    }

    public void setTearlineplace(String tearlineplace) {
        this.tearlineplace = tearlineplace == null ? null : tearlineplace.trim();
    }

    public String getProductstyle() {
        return productstyle;
    }

    public void setProductstyle(String productstyle) {
        this.productstyle = productstyle == null ? null : productstyle.trim();
    }

    public Integer getScrolldirection() {
        return scrolldirection;
    }

    public void setScrolldirection(Integer scrolldirection) {
        this.scrolldirection = scrolldirection;
    }

    public String getScrolllength() {
        return scrolllength;
    }

    public void setScrolllength(String scrolllength) {
        this.scrolllength = scrolllength == null ? null : scrolllength.trim();
    }

    public String getRepeatscrollsize() {
        return repeatscrollsize;
    }

    public void setRepeatscrollsize(String repeatscrollsize) {
        this.repeatscrollsize = repeatscrollsize == null ? null : repeatscrollsize.trim();
    }

    public String getProceduresum() {
        return proceduresum;
    }

    public void setProceduresum(String proceduresum) {
        this.proceduresum = proceduresum == null ? null : proceduresum.trim();
    }

    public Integer getInterfacecount() {
        return interfacecount;
    }

    public void setInterfacecount(Integer interfacecount) {
        this.interfacecount = interfacecount;
    }

    public Integer getHemcount() {
        return hemcount;
    }

    public void setHemcount(Integer hemcount) {
        this.hemcount = hemcount;
    }

    public String getBoxway() {
        return boxway;
    }

    public void setBoxway(String boxway) {
        this.boxway = boxway == null ? null : boxway.trim();
    }

    public String getBoxsize() {
        return boxsize;
    }

    public void setBoxsize(String boxsize) {
        this.boxsize = boxsize == null ? null : boxsize.trim();
    }

    public Integer getSplitsum() {
        return splitsum;
    }

    public void setSplitsum(Integer splitsum) {
        this.splitsum = splitsum;
    }

    public String getMould() {
        return mould;
    }

    public void setMould(String mould) {
        this.mould = mould == null ? null : mould.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public TPrintingProcedureafter() {
    }

    public TPrintingProcedureafter(String qualitycheck, Integer splitsizr, Integer transparentkeep, String mergesize, Integer splithigh, String glueplace, String foldplace, String tearlinesize, String tearlineplace, String productstyle, Integer scrolldirection, String scrolllength, String repeatscrollsize, String proceduresum, Integer interfacecount, Integer hemcount, String boxway, String boxsize, Integer splitsum, String mould, String note) {
        this.qualitycheck = qualitycheck;
        this.splitsizr = splitsizr;
        this.transparentkeep = transparentkeep;
        this.mergesize = mergesize;
        this.splithigh = splithigh;
        this.glueplace = glueplace;
        this.foldplace = foldplace;
        this.tearlinesize = tearlinesize;
        this.tearlineplace = tearlineplace;
        this.productstyle = productstyle;
        this.scrolldirection = scrolldirection;
        this.scrolllength = scrolllength;
        this.repeatscrollsize = repeatscrollsize;
        this.proceduresum = proceduresum;
        this.interfacecount = interfacecount;
        this.hemcount = hemcount;
        this.boxway = boxway;
        this.boxsize = boxsize;
        this.splitsum = splitsum;
        this.mould = mould;
        this.note = note;
    }

    @Override
    public String toString() {
        return "TPrintingProcedureafter{" +
                "id=" + id +
                ", qualitycheck='" + qualitycheck + '\'' +
                ", splitsizr=" + splitsizr +
                ", transparentkeep=" + transparentkeep +
                ", mergesize='" + mergesize + '\'' +
                ", splithigh=" + splithigh +
                ", glueplace='" + glueplace + '\'' +
                ", foldplace='" + foldplace + '\'' +
                ", tearlinesize='" + tearlinesize + '\'' +
                ", tearlineplace='" + tearlineplace + '\'' +
                ", productstyle='" + productstyle + '\'' +
                ", scrolldirection=" + scrolldirection +
                ", scrolllength='" + scrolllength + '\'' +
                ", repeatscrollsize='" + repeatscrollsize + '\'' +
                ", proceduresum='" + proceduresum + '\'' +
                ", interfacecount=" + interfacecount +
                ", hemcount=" + hemcount +
                ", boxway='" + boxway + '\'' +
                ", boxsize='" + boxsize + '\'' +
                ", splitsum=" + splitsum +
                ", mould='" + mould + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}