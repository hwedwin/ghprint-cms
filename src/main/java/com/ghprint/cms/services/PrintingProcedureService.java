package com.ghprint.cms.services;

import com.ghprint.cms.model.production.TPrintingProcedure;

/**
 *
 * Created by Administrator on 2017/3/12.
 */
public interface PrintingProcedureService {

    public  Integer addPrintingProcedure(TPrintingProcedure printingProcedure);
    public  Integer delPrintingProcedure(Integer pid);
    public  Integer updataPrintingProcedure(TPrintingProcedure printingProcedure);
    public  TPrintingProcedure getPrintingProcedurebyId(Integer pid);

}
