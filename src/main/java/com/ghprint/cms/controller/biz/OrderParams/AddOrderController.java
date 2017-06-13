package com.ghprint.cms.controller.biz.OrderParams;

import cn.com.bestpay.Response;
import com.ghprint.cms.common.AuthorityKey;
import com.ghprint.cms.controller.BaseAction;
import com.ghprint.cms.model.order.TOrderParams;
import com.ghprint.cms.services.OrderParamsService;
import com.ghprint.cms.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lipeiting on 2017/6/13.
 */
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class AddOrderController  extends BaseAction{
    private static Logger log = LoggerFactory.getLogger(AddOrderController.class);

    @Autowired
    private OrderParamsService orderParamsService ;

    @RequestMapping(value = "/orderparams/addparams.do", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public Response<String> OrderParamsAdd(HttpServletRequest request, HttpServletResponse response , @RequestBody TOrderParams order)  {
        Response<String> responses = new Response<>();
        log.info("OrderParamsAdd request param:{}",order.toString());
        try {
            Assert.hasText(order.getMaterialid().toString(), "order 中 原材料ID  is null or 空字符串。");
            Assert.hasText(order.getProductid().toString(), "order 中 成品ID  is null or 空字符串。");
            Assert.hasText(order.getProportion().toString(), "order 中 比重  is null or 空字符串。");
            Assert.hasText(order.getHeight().toString(), "order 中 高度  is null or 空字符串。");
            Assert.hasText(order.getThickness().toString(), "order 中 厚度  is null or 空字符串。");
            Assert.hasText(order.getSpellcount().toString(), "order 中 拼数  is null or 空字符串。");
            Boolean flag = super.execute(request, response);
            if (flag) {
                 Integer result = orderParamsService.addOrderParams(order);
                if(result>0) {
                    responses.setErrorCode(Constant.errorCodeEnum.SUCCESS.getCode());
                    responses.setErrorMsg(Constant.errorCodeEnum.SUCCESS.getName());
                    responses.setResult(result.toString());
                }else {
                    responses.setErrorCode(Constant.errorCodeEnum.FAILURE.getCode());
                    responses.setErrorMsg("添加订单明细异常");
                }

                return  responses;

            } else {
                responses.setErrorCode(Constant.errorCodeEnum.LOGIN_TIMEOUT_ERROE.getCode());
                responses.setErrorMsg(request.getAttribute("message").toString());
                return responses;
            }
        } catch (Exception e) {
            log.error("添加订单明细失败=:", e);
            responses.setErrorCode(Constant.errorCodeEnum.FAILURE.getCode());
            responses.setErrorMsg("添加订单明细异常");
            return responses;
        }
    }

    @Override
    public String getAuthorityId() {
        return AuthorityKey.ORDERPARAMS_ADD;
    }

}
