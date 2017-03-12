package com.ghprint.cms.model.production;

public class TPrintingData {
    private Integer id;

    private String templatenum;

    private Integer printsize;

    private Integer templatelength;

    private Integer templateperimeter;

    private String spellcount;

    private Integer bankuncount;

    private String color;

    private String printnote;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTemplatenum() {
        return templatenum;
    }

    public void setTemplatenum(String templatenum) {
        this.templatenum = templatenum == null ? null : templatenum.trim();
    }

    public Integer getPrintsize() {
        return printsize;
    }

    public void setPrintsize(Integer printsize) {
        this.printsize = printsize;
    }

    public Integer getTemplatelength() {
        return templatelength;
    }

    public void setTemplatelength(Integer templatelength) {
        this.templatelength = templatelength;
    }

    public Integer getTemplateperimeter() {
        return templateperimeter;
    }

    public void setTemplateperimeter(Integer templateperimeter) {
        this.templateperimeter = templateperimeter;
    }

    public String getSpellcount() {
        return spellcount;
    }

    public void setSpellcount(String spellcount) {
        this.spellcount = spellcount == null ? null : spellcount.trim();
    }

    public Integer getBankuncount() {
        return bankuncount;
    }

    public void setBankuncount(Integer bankuncount) {
        this.bankuncount = bankuncount;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    public String getPrintnote() {
        return printnote;
    }

    public void setPrintnote(String printnote) {
        this.printnote = printnote == null ? null : printnote.trim();
    }

    public TPrintingData() {
    }

    public TPrintingData(String printnote, String color, Integer bankuncount, String spellcount, Integer templateperimeter, Integer templatelength, Integer printsize, String templatenum) {
        this.printnote = printnote;
        this.color = color;
        this.bankuncount = bankuncount;
        this.spellcount = spellcount;
        this.templateperimeter = templateperimeter;
        this.templatelength = templatelength;
        this.printsize = printsize;
        this.templatenum = templatenum;
    }

    @Override
    public String toString() {
        return "TPrintingData{" +
                "id=" + id +
                ", templatenum='" + templatenum + '\'' +
                ", printsize=" + printsize +
                ", templatelength=" + templatelength +
                ", templateperimeter=" + templateperimeter +
                ", spellcount='" + spellcount + '\'' +
                ", bankuncount=" + bankuncount +
                ", color='" + color + '\'' +
                ", printnote='" + printnote + '\'' +
                '}';
    }
}