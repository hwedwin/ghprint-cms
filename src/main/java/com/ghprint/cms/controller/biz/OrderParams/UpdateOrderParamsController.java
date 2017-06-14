package com.ghprint.cms.controller.biz.OrderParams;

import cn.com.bestpay.Response;
import com.ghprint.cms.common.AuthorityKey;
import com.ghprint.cms.controller.BaseAction;
import com.ghprint.cms.model.order.OrderEdit;
import com.ghprint.cms.model.order.TOrderParams;
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
public class UpdateOrderParamsController extends BaseAction {

    private static Logger log = LoggerFactory.getLogger(UpdateOrderParamsController.class);

    @Autowired
    private OrderParamsService orderParamsService;

    @RequestMapping(value = "/orderparams/updateorderparams.do", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public Response<String> OrderParamsUpdate(HttpServletRequest request, HttpServletResponse response, @RequestBody TOrderParams orderEdit) {
        Response<String> responses = new Response<>();
        try {
            Assert.hasText(String.valueOf(orderEdit.getId()), " 主键 id  is null or 空字符串。");
            Assert.hasText(orderEdit.getMaterialid().toString(), "OrderParams 中 原材料ID  is null or 空字符串。");
            Assert.hasText(orderEdit.getProductid().toString(), "OrderParams 中 成品ID  is null or 空字符串。");
            Assert.hasText(orderEdit.getProportion().toString(), "OrderParams 中 比重  is null or 空字符串。");
            Assert.hasText(orderEdit.getHeight().toString(), "OrderParams 中 高度  is null or 空字符串。");
            Assert.hasText(orderEdit.getThickness().toString(), "OrderParams 中 厚度  is null or 空字符串。");
            Assert.hasText(orderEdit.getSpellcount().toString(), "OrderParams 中 拼数  is null or 空字符串。");
            log.info("OrderParamsUpdate request param:{}", orderEdit.toString());
            Boolean flag = super.execute(request, response);
            if (flag) {
                Integer record = orderParamsService.updateOrderParams(orderEdit );
                if (record > 0) {
                    responses.setErrorCode(Constant.errorCodeEnum.SUCCESS.getCode());
                    responses.setErrorMsg(Constant.errorCodeEnum.SUCCESS.getName());
                    responses.setResult(String.valueOf(record));
                } else {
                    responses.setErrorCode(Constant.errorCodeEnum.FAILURE.getCode());
                    responses.setErrorMsg("修改订单明细记录异常");
                }
                return responses;
            } else {
                responses.setErrorCode(Constant.errorCodeEnum.LOGIN_TIMEOUT_ERROE.getCode());
                responses.setErrorMsg(request.getAttribute("message").toString());
                return responses;
            }
        } catch (Exception e) {
            log.error("修改订单明细记录失败=:", e);
            responses.setErrorCode(Constant.errorCodeEnum.FAILURE.getCode());
            responses.setErrorMsg("修改订单明细记录异常");
            return responses;
        }
    }







    @Override
    public String getAuthorityId() {
        return AuthorityKey.ORDERPARAMS_UPDATE;
    }
}
