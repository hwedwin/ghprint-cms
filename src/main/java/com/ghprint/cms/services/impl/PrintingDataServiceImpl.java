package com.ghprint.cms.services.impl;

import com.ghprint.cms.model.production.TPrintingData;
import com.ghprint.cms.serviceDao.TPrintingDataMapper;
import com.ghprint.cms.services.PrintingDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/3/12.
 */
@Service
public class PrintingDataServiceImpl implements PrintingDataService {

    @Autowired
    private TPrintingDataMapper printingDataMapper;

    @Override
    public Integer addPrintingData(TPrintingData printingData) {
        Integer record = printingDataMapper.insertSelective(printingData);
        return  record;
    }
}
