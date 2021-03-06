package com.ghprint.cms.controller.biz.Stocks;

import cn.com.bestpay.Response;
import com.ghprint.cms.common.AuthorityKey;
import com.ghprint.cms.controller.BaseAction;
import com.ghprint.cms.model.stock.TProductionStock;
import com.ghprint.cms.pagination.DataGridResult;
import com.ghprint.cms.services.ProStockService;
import com.ghprint.cms.utils.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/3/29.
 */
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class QueryStocksController extends BaseAction {

    private static Logger log = LoggerFactory.getLogger(QueryStocksController.class);

    @Autowired
    private ProStockService proStockService;;

    @RequestMapping(value = "/prostocks/selectstocks.do", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public DataGridResult getStocksList(HttpServletRequest request, HttpServletResponse response ,
                                        @RequestParam(value = "key")String key , @RequestParam(value = "value")String value,
                                        @RequestParam(value = "page")Integer page , @RequestParam(value = "rows")Integer rows){
        DataGridResult dataGridResult = new DataGridResult();
        try {
            Assert.hasText(String.valueOf(page), "page  is null or 空字符串。");
            Assert.hasText(String.valueOf(rows), "rows  is null or 空字符串。");
            log.info("getStocksList request Param:key {},value {},page {},rows {}", new String[]{key,value, String.valueOf(page), String.valueOf(rows)});
            Boolean flag = super.execute(request, response);
            if (flag) {
                if(key.equals("")){key=null;}
                if(value.equals("")){value=null;}
                dataGridResult =  proStockService.selectProStocks( key ,value, page ,rows);
                if(dataGridResult!=null) {
                    dataGridResult.setSuccess(Boolean.TRUE);
                }else{
                    dataGridResult.setSuccess(Boolean.FALSE);
                }
                log.info("getStocksList response Param:{}", dataGridResult.toString());
                return dataGridResult;
            } else {
                dataGridResult.setSuccess(Boolean.FALSE);
                dataGridResult.setMessage(request.getAttribute("message").toString());
                return dataGridResult;
            }

        }catch (Exception e) {
            log.error("查询成品库存列表失败=:", e);
            dataGridResult.setSuccess(Boolean.FALSE);
            dataGridResult.setMessage("查询成品库存列表异常");
            return  dataGridResult;
        }

    }

    @RequestMapping(value = "/prostocks/editprostocks.do", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public Response<TProductionStock> prostockedit(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "sid") Integer sid) {
        Response<TProductionStock> responses = new Response<>();
        try {
            Assert.hasText(String.valueOf(sid), "sid  is null or 空字符串。");
            log.info("editprostocks request param:{}", sid);
            Boolean flag = super.execute(request, response);
            if (flag) {
                TProductionStock productionStock = proStockService.getProStockbyId(sid);
                if(productionStock!=null) {
                    responses.setErrorCode(Constant.errorCodeEnum.SUCCESS.getCode());
                    responses.setErrorMsg(Constant.errorCodeEnum.SUCCESS.getName());
                    responses.setResult(productionStock);
                }else{
                    responses.setErrorCode(Constant.errorCodeEnum.PARAM_ERROR.getCode());
                    responses.setErrorMsg(Constant.errorCodeEnum.PARAM_ERROR.getName());
                    log.info("prostockedit edit fail ,no this record");
                }
                return responses;
            } else {
                responses.setErrorCode(Constant.errorCodeEnum.LOGIN_TIMEOUT_ERROE.getCode());
                responses.setErrorMsg(request.getAttribute("message").toString());
                return responses;
            }
        } catch (Exception e) {
            log.error("编辑成品库存初始化失败=:", e);
            responses.setErrorCode(Constant.errorCodeEnum.FAILURE.getCode());
            responses.setErrorMsg("编辑成品库存初始化异常");
            return responses;
        }

    }

    @Override
    public String getAuthorityId() {
        return AuthorityKey.PROSTOCKS_SELECT;
    }
}
