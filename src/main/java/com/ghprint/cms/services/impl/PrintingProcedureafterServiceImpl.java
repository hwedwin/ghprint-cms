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

    @Override
    public Integer delPrintingProcedureafter(Integer pid) {
        Integer record  = printingProcedureafterMapper.deleteByPrimaryKey(pid);
        return record;
    }

    @Override
    public Integer updatePrintingProcedureafter(TPrintingProcedureafter printingProcedureafter) {
        Integer record = printingProcedureafterMapper.updateByPrimaryKeySelective(printingProcedureafter);
        return record;
    }

    @Override
    public TPrintingProcedureafter getPrintingProcedureafterbyId(Integer pid) {
        TPrintingProcedureafter printingProcedureafter = printingProcedureafterMapper.selectByPrimaryKey(pid);
        return  printingProcedureafter!=null?printingProcedureafter:null;
    }
}
