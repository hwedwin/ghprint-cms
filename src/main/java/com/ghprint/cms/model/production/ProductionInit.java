package com.ghprint.cms.model.production;

import com.ghprint.cms.model.sys.DictItemVO;

import java.util.List;

/**
 * Created by Administrator on 2017/3/13.
 */
public class ProductionInit {

    private List<DictItemVO> packaging;
    private List<DictItemVO> printingmode;
    private List <DictItemVO> productstyle;
    private List <DictItemVO> scrolldirection;
    private List <DictItemVO> splitsum;

    public List<DictItemVO> getPackaging() {
        return packaging;
    }

    public void setPackaging(List<DictItemVO> packaging) {
        this.packaging = packaging;
    }

    public List<DictItemVO> getPrintingmode() {
        return printingmode;
    }

    public void setPrintingmode(List<DictItemVO> printingmode) {
        this.printingmode = printingmode;
    }

    public List<DictItemVO> getProductstyle() {
        return productstyle;
    }

    public void setProductstyle(List<DictItemVO> productstyle) {
        this.productstyle = productstyle;
    }

    public List<DictItemVO> getScrolldirection() {
        return scrolldirection;
    }

    public void setScrolldirection(List<DictItemVO> scrolldirection) {
        this.scrolldirection = scrolldirection;
    }

    public List<DictItemVO> getSplitsum() {
        return splitsum;
    }

    public void setSplitsum(List<DictItemVO> splitsum) {
        this.splitsum = splitsum;
    }

    public ProductionInit() {
    }

    public ProductionInit(List<DictItemVO> packaging, List<DictItemVO> printingmode, List<DictItemVO> productstyle, List<DictItemVO> scrolldirection, List<DictItemVO> splitsum) {
        this.packaging = packaging;
        this.printingmode = printingmode;
        this.productstyle = productstyle;
        this.scrolldirection = scrolldirection;
        this.splitsum = splitsum;
    }
}
