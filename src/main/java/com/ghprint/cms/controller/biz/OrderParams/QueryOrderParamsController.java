package com.ghprint.cms.controller.biz.OrderParams;

import cn.com.bestpay.Response;
import com.ghprint.cms.common.AuthorityKey;
import com.ghprint.cms.controller.BaseAction;
import com.ghprint.cms.model.order.OrderParams;
import com.ghprint.cms.pagination.DataGridResult;
import com.ghprint.cms.services.OrderParamsService;
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
 * Created by lipeiting on 2017/6/14.
 */
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class QueryOrderParamsController  extends BaseAction{

    private static Logger log = LoggerFactory.getLogger(QueryOrderParamsController.class);

    @Autowired
    private OrderParamsService orderParamsService;

    @RequestMapping(value = "/orderparams/selectorderparams.do", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public DataGridResult getOrderParamsList(HttpServletRequest request, HttpServletResponse response ,
                                        @RequestParam(value = "key")String key , @RequestParam(value = "value")String value,
                                        @RequestParam(value = "page")Integer page , @RequestParam(value = "rows")Integer rows){
        DataGridResult dataGridResult = new DataGridResult();
        try {
            Assert.hasText(String.valueOf(page), "page  is null or 空字符串。");
            Assert.hasText(String.valueOf(rows), "rows  is null or 空字符串。");
            log.info("getOrderParamsList request Param:key {},value {},page {},rows {}", new String[]{key,value, String.valueOf(page), String.valueOf(rows)});
            Boolean flag = super.execute(request, response);
            if (flag) {
                if(key.equals("")){key=null;}
                if(value.equals("")){value=null;}
                dataGridResult =  orderParamsService.selectOrderParamsList( key ,value, page ,rows);
                if(dataGridResult!=null) {
                    dataGridResult.setSuccess(Boolean.TRUE);
                }else{
                    dataGridResult.setSuccess(Boolean.FALSE);
                }
                log.info("getOrderParamsList response Param:{}", dataGridResult.toString());
                return dataGridResult;
            } else {
                dataGridResult.setSuccess(Boolean.FALSE);
                dataGridResult.setMessage(request.getAttribute("message").toString());
                return dataGridResult;
            }

        }catch (Exception e) {
            log.error("查询订单明细列表失败=:", e);
            dataGridResult.setSuccess(Boolean.FALSE);
            dataGridResult.setMessage("查询订单明细列表异常");
            return  dataGridResult;
        }

    }

    @RequestMapping(value = "/orderparams/editorderparams.do", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public Response<OrderParams> OrderParamsDetailEdit(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "opid") Integer opid) {
        Response<OrderParams> responses = new Response<>();
        try {
            Assert.hasText(String.valueOf(opid), "opid  is null or 空字符串。");
            log.info("OrderParamsDetailEdit request param:{}", opid);
            Boolean flag = super.execute(request, response);
            if (flag) {
                OrderParams orderInfo = orderParamsService.getOrderParamsEdit(opid);
                if (orderInfo != null) {
                    responses.setErrorCode(Constant.errorCodeEnum.SUCCESS.getCode());
                    responses.setErrorMsg(Constant.errorCodeEnum.SUCCESS.getName());
                    responses.setResult(orderInfo);
                } else {
                    responses.setErrorCode(Constant.errorCodeEnum.PARAM_ERROR.getCode());
                    responses.setErrorMsg(Constant.errorCodeEnum.PARAM_ERROR.getName());
                    log.info("OrderParamsDetailEdit edit fail ,no this record");
                }
                return responses;
            } else {
                responses.setErrorCode(Constant.errorCodeEnum.LOGIN_TIMEOUT_ERROE.getCode());
                responses.setErrorMsg(request.getAttribute("message").toString());
                return responses;
            }
        } catch (Exception e) {
            log.error("编辑订单明细初始化失败=:", e);
            responses.setErrorCode(Constant.errorCodeEnum.FAILURE.getCode());
            responses.setErrorMsg("编辑订单明细初始化异常");
            return responses;
        }

    }




    @Override
    public String getAuthorityId() {
        return AuthorityKey.ORDERPARAMS_SELECT;
    }
}
