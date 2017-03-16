package com.ghprint.cms.services;

import com.ghprint.cms.model.production.TPrintingData;

/**
 * Created by Administrator on 2017/3/12.
 */
public interface PrintingDataService {

    public  Integer addPrintingData(TPrintingData printingData);
    public  Integer delPrintingData(Integer pid);
    public  Integer updatePrintingData(TPrintingData printingData);
    public  TPrintingData getPrintingData(Integer pid);
}
