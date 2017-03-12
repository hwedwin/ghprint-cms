package com.ghprint.cms.services.impl;

import com.ghprint.cms.model.production.TPrintingProcedureafter;
import com.ghprint.cms.serviceDao.TPrintingProcedureafterMapper;
import com.ghprint.cms.services.PrintingProcedureafterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/3/12.
 */
@Service
public class PrintingProcedureafterServiceImpl implements PrintingProcedureafterService {

    @Autowired
    private TPrintingProcedureafterMapper printingProcedureafterMapper;


    @Override
    public Integer addPrintingProcedureafter(TPrintingProcedureafter printingProcedureafter) {
        Integer record = printingProcedureafterMapper.insertSelective(printingProcedureafter);
        return  record;
    }
}
