package com.ghprint.cms.controller.biz.ProductionStandard;

import com.ghprint.cms.common.AuthorityKey;
import com.ghprint.cms.controller.BaseAction;
import com.ghprint.cms.pagination.DataGridResult;
import com.ghprint.cms.services.ProductionInfoService;
import com.ghprint.cms.utils.Constant;
import com.ghprint.cms.utils.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/3/14.
 */
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class QueryProductStandController extends BaseAction {

    private static Logger log = LoggerFactory.getLogger(QueryProductStandController.class);

    @Autowired
    private ProductionInfoService productionInfoService;

    @RequestMapping(value = "/product/queryproductlist.do", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public DataGridResult getProductionList(HttpServletRequest request, HttpServletResponse response ,
                                                      @RequestParam(value = "key")String key ,@RequestParam(value = "value")String value,
                                                      @RequestParam(value = "page")Integer page ,@RequestParam(value = "rows")Integer rows){
        DataGridResult dataGridResult = new DataGridResult();
        try {

            Assert.hasText(String.valueOf(page), "page  is null or 空字符串。");
            Assert.hasText(String.valueOf(rows), "rows  is null or 空字符串。");
            log.info("queryproductlist request Param:key{},value{},page{},rows{}", new String[]{key,value, String.valueOf(page), String.valueOf(rows)});
            Boolean flag = super.execute(request, response);
            if (flag) {
                if(key.equals("")){key=null;};
                if(value.equals("")){value=null;};
                dataGridResult =  productionInfoService.getProductionList( key ,value, page ,  rows);
                dataGridResult.setSuccess(Boolean.TRUE);
                log.info("queryproductlist response Param:{}", dataGridResult.toString());
                return dataGridResult;

            } else {
                dataGridResult.setSuccess(Boolean.FALSE);
                dataGridResult.setMessage(request.getAttribute("message").toString());
                return dataGridResult;
            }

        }catch (Exception e) {
            log.error("查询生产标准列表失败=:", e);
            dataGridResult.setSuccess(Boolean.FALSE);
            dataGridResult.setMessage("查询生产标准列表异常");
            return  dataGridResult;
        }
    }



    @Override
    public String getAuthorityId() {
        return AuthorityKey.PRODUCTION_SELECT;
    }
}
