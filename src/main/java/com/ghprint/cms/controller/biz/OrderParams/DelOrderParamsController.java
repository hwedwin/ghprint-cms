package com.ghprint.cms.controller.biz.OrderParams;

import cn.com.bestpay.Response;
import com.ghprint.cms.common.AuthorityKey;
import com.ghprint.cms.controller.BaseAction;
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
public class DelOrderParamsController   extends BaseAction{

    private static Logger log = LoggerFactory.getLogger(DelOrderParamsController.class);

    @Autowired
    private OrderParamsService orderParamsService;


    @RequestMapping(value = "/orderparams/delorderparams.do", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public Response<Integer> OrderParamsDEl(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "opid") Integer opid) {
        Response<Integer> responses = new Response<>();
        try {
            Assert.hasText(String.valueOf(opid), "opid  is null or 空字符串。");
            log.info("OrderParamsDEl request param:{}", opid);
            Boolean flag = super.execute(request, response);
            if (flag) {
                Integer record = orderParamsService.delOrderParams(opid);
                if (record > 0) {
                    responses.setErrorCode(Constant.errorCodeEnum.SUCCESS.getCode());
                    responses.setErrorMsg(Constant.errorCodeEnum.SUCCESS.getName());
                    responses.setResult(record);
                } else {
                    responses.setErrorCode(Constant.errorCodeEnum.PARAM_ERROR.getCode());
                    responses.setErrorMsg(Constant.errorCodeEnum.PARAM_ERROR.getName());
                    log.info("OrderParamsDEl delete fail ,no this record");
                }
                return responses;

            } else {
                responses.setErrorCode(Constant.errorCodeEnum.LOGIN_TIMEOUT_ERROE.getCode());
                responses.setErrorMsg(request.getAttribute("message").toString());
                return responses;
            }
        } catch (Exception e) {
            log.error("删除订单明细失败=:", e);
            responses.setErrorCode(Constant.errorCodeEnum.FAILURE.getCode());
            responses.setErrorMsg("删除订单明细异常");
            return responses;
        }


    }








    @Override
    public String getAuthorityId() {
        return  AuthorityKey.ORDERPARAMS_DEL;
    }
}
