package com.ghprint.cms.controller.biz.Order;

import cn.com.bestpay.Response;
import com.ghprint.cms.common.AuthorityKey;
import com.ghprint.cms.controller.BaseAction;
import com.ghprint.cms.model.order.OrderAdd;
import com.ghprint.cms.model.order.OrderView;
import com.ghprint.cms.model.order.TPurchaseDetail;
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
public class AddOrderController extends BaseAction{

    private static Logger log = LoggerFactory.getLogger(AddOrderController.class);

    @Autowired
    private OrderService orderService;


    @RequestMapping(value = "/orders/addorder.do", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public Response<OrderView> OrderAdd(HttpServletRequest request, HttpServletResponse response , @RequestBody OrderAdd order)  {
        Response<OrderView> responses = new Response<>();
        log.info("OrderAdd request param:{}",order.toString());
        try {
            Assert.hasText(order.getCompanyid().toString(), "order 中 公司ID  is null or 空字符串。");
            Assert.hasText(order.getOrderparamsid().toString(), "order 中 订单明细ID  is null or 空字符串。");
            Assert.hasText(order.getStandardid().toString(), "order 中 生产标准ID  is null or 空字符串。");
            Assert.hasText(order.getOrderid().toString(), "order 中 订单ID  is null or 空字符串。");
            Assert.hasText(order.getOrdercount().toString(), "order 中 订单数量  is null or 空字符串。");
            Boolean flag = super.execute(request, response);
            if (flag) {
                OrderView result = orderService.addOrderItem(order);
                if(result!=null) {
                    responses.setErrorCode(Constant.errorCodeEnum.SUCCESS.getCode());
                    responses.setErrorMsg(Constant.errorCodeEnum.SUCCESS.getName());
                    responses.setResult(result);
                }else {
                    responses.setErrorCode(Constant.errorCodeEnum.FAILURE.getCode());
                    responses.setErrorMsg("添加订单异常");
                }

                return  responses;

            } else {
                responses.setErrorCode(Constant.errorCodeEnum.LOGIN_TIMEOUT_ERROE.getCode());
                responses.setErrorMsg(request.getAttribute("message").toString());
                return responses;
            }
        } catch (Exception e) {
            log.error("添加订单失败=:", e);
            responses.setErrorCode(Constant.errorCodeEnum.FAILURE.getCode());
            responses.setErrorMsg("添加订单异常");
            return responses;
        }
    }







    @Override
    public String getAuthorityId() {
        return AuthorityKey.ORDER_ADD;
    }
}
