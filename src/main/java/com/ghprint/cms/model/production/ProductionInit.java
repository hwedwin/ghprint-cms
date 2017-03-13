package com.ghprint.cms.model.production;

import com.ghprint.cms.model.sys.DictItemVO;

import java.util.List;

/**
 * Created by Administrator on 2017/3/13.
 */
public class ProductionInit {

    private List<DictItemVO> packaging;
    private List<DictItemVO> printingmode;

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

    public ProductionInit() {
    }

    public ProductionInit(List<DictItemVO> packaging, List<DictItemVO> printingmode) {
        this.packaging = packaging;
        this.printingmode = printingmode;
    }
}
