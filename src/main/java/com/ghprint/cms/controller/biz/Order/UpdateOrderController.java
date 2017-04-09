package com.ghprint.cms.controller.biz.Order;

import cn.com.bestpay.Response;
import com.ghprint.cms.common.AuthorityKey;
import com.ghprint.cms.controller.BaseAction;
import com.ghprint.cms.model.order.OrderEdit;
import com.ghprint.cms.model.order.OrderInfo;
import com.ghprint.cms.services.OrderService;
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
 * Created by Administrator on 2017/4/9.
 */
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class UpdateOrderController extends BaseAction{
    private static Logger log = LoggerFactory.getLogger(UpdateOrderController.class);
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/orders/editorder.do", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public Response<OrderInfo> OrderDetailEdit(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "orderId") Integer orderId) {
        Response<OrderInfo> responses = new Response<>();
        try {
            Assert.hasText(String.valueOf(orderId), "orderId  is null or 空字符串。");
            log.info("OrderDetailEdit request param:{}", orderId);
            Boolean flag = super.execute(request, response);
            if (flag) {
                OrderInfo orderInfo = orderService.getOrderItemById(orderId);
                if (orderInfo != null) {
                    responses.setErrorCode(Constant.errorCodeEnum.SUCCESS.getCode());
                    responses.setErrorMsg(Constant.errorCodeEnum.SUCCESS.getName());
                    responses.setResult(orderInfo);
                } else {
                    responses.setErrorCode(Constant.errorCodeEnum.PARAM_ERROR.getCode());
                    responses.setErrorMsg(Constant.errorCodeEnum.PARAM_ERROR.getName());
                    log.info("OrderDetailEdit edit fail ,no this record");
                }
                return responses;
            } else {
                responses.setErrorCode(Constant.errorCodeEnum.LOGIN_TIMEOUT_ERROE.getCode());
                responses.setErrorMsg(request.getAttribute("message").toString());
                return responses;
            }
        } catch (Exception e) {
            log.error("编辑订单初始化失败=:", e);
            responses.setErrorCode(Constant.errorCodeEnum.FAILURE.getCode());
            responses.setErrorMsg("编辑订单初始化异常");
            return responses;
        }

    }


    @RequestMapping(value = "/orders/updateorder.do", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public Response<String> OrderUpdate(HttpServletRequest request, HttpServletResponse response, @RequestBody OrderEdit orderEdit) {
        Response<String> responses = new Response<>();
        try {
            Assert.hasText(String.valueOf(orderEdit.getId()), " 主键 id  is null or 空字符串。");
            Assert.hasText(String.valueOf(orderEdit.getCompanyid()), " 公司 id  is null or 空字符串。");
            Assert.hasText(String.valueOf(orderEdit.getStandardid()), " 生产标准 id  is null or 空字符串。");
            log.info("OrderUpdate request param:{}", orderEdit.toString());
            Boolean flag = super.execute(request, response);
            if (flag) {
                Integer record = orderService.updateOrderItem(orderEdit );
                if (record > 0) {
                    responses.setErrorCode(Constant.errorCodeEnum.SUCCESS.getCode());
                    responses.setErrorMsg(Constant.errorCodeEnum.SUCCESS.getName());
                    responses.setResult(String.valueOf(record));
                } else {
                    responses.setErrorCode(Constant.errorCodeEnum.FAILURE.getCode());
                    responses.setErrorMsg("修改订单记录异常");
                }
                return responses;
            } else {
                responses.setErrorCode(Constant.errorCodeEnum.LOGIN_TIMEOUT_ERROE.getCode());
                responses.setErrorMsg(request.getAttribute("message").toString());
                return responses;
            }
        } catch (Exception e) {
            log.error("修改订单记录失败=:", e);
            responses.setErrorCode(Constant.errorCodeEnum.FAILURE.getCode());
            responses.setErrorMsg("修改订单记录异常");
            return responses;
        }
    }

    @Override
    public String getAuthorityId() {
        return AuthorityKey.ORDER_UPDATE;
    }
}
