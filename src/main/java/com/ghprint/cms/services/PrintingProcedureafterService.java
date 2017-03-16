package com.ghprint.cms.services;

import com.ghprint.cms.model.production.TPrintingProcedureafter;

/**
 * Created by Administrator on 2017/3/12.
 */
public interface PrintingProcedureafterService {

    public  Integer addPrintingProcedureafter(TPrintingProcedureafter printingProcedureafter);
    public  Integer delPrintingProcedureafter(Integer pid);
    public Integer updatePrintingProcedureafter(TPrintingProcedureafter printingProcedureafter);
    public  TPrintingProcedureafter getPrintingProcedureafterbyId(Integer pid);
}
