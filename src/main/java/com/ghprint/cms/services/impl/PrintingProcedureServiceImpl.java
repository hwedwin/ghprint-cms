package com.ghprint.cms.services.impl;

import com.ghprint.cms.model.production.TPrintingProcedure;
import com.ghprint.cms.serviceDao.TPrintingProcedureMapper;
import com.ghprint.cms.services.PrintingProcedureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/3/12.
 */
@Service
public class PrintingProcedureServiceImpl implements PrintingProcedureService {

    @Autowired
    private TPrintingProcedureMapper printingProcedureMapper;



    @Override
    public Integer addPrintingProcedure(TPrintingProcedure printingProcedure) {
        Integer record = printingProcedureMapper.insertSelective(printingProcedure);
        return record;
    }

    @Override
    public Integer delPrintingProcedure(Integer pid) {
        Integer redord = printingProcedureMapper.deleteByPrimaryKey(pid);
        return  redord;
    }

    @Override
    public Integer updataPrintingProcedure(TPrintingProcedure printingProcedure) {
        Integer record = printingProcedureMapper.updateByPrimaryKeySelective(printingProcedure);
        return  record;
    }

    @Override
    public TPrintingProcedure getPrintingProcedurebyId(Integer pid) {
        TPrintingProcedure printingProcedure = printingProcedureMapper.selectByPrimaryKey(pid);
        return  printingProcedure;
    }
}
