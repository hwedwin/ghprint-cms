package com.ghprint.cms.controller.biz.Order;

import cn.com.bestpay.Response;
import com.ghprint.cms.common.AuthorityKey;
import com.ghprint.cms.controller.BaseAction;
import com.ghprint.cms.model.order.OrderInit;
import com.ghprint.cms.services.OrderService;
import com.ghprint.cms.utils.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/4/9.
 */
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class InitOrderController extends BaseAction {

    private static Logger log = LoggerFactory.getLogger(InitOrderController.class);

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/orders/initorder.do", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public Response<OrderInit> OrderInit(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "company")Boolean company,
                                         @RequestParam(value = "product")Boolean product,@RequestParam(value = "material")Boolean material,
                                         @RequestParam(value = "standard")Boolean standard
            ){
        Response<OrderInit> responses = new Response<>();
        try {
            Boolean flag = super.execute(request, response);
            if (flag) {
                OrderInit orderInit = orderService.getProductionInit(company, product, material, standard);
                    if(orderInit!=null){
                        responses.setErrorCode(Constant.errorCodeEnum.SUCCESS.getCode());
                        responses.setErrorMsg(Constant.errorCodeEnum.SUCCESS.getName());
                        responses.setResult(orderInit);
                    }else {
                        responses.setErrorCode(Constant.errorCodeEnum.FAILURE.getCode());
                        responses.setErrorMsg("订单参数构造器初始化异常");
                    }
                    return  responses;
            } else {
                responses.setErrorCode(Constant.errorCodeEnum.LOGIN_TIMEOUT_ERROE.getCode());
                responses.setErrorMsg(request.getAttribute("message").toString());
                return responses;
            }
                } catch (Exception e) {
            log.error("订单参数构造器初始化失败=:", e);
            responses.setErrorCode(Constant.errorCodeEnum.FAILURE.getCode());
            responses.setErrorMsg("订单参数构造器异常");
            return responses;
        }
    }



    @Override
    public String getAuthorityId() {
        return AuthorityKey.ORDER_INIT;
    }
}
