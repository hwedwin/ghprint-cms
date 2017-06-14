package com.ghprint.cms.controller.biz.Order;

import cn.com.bestpay.Response;
import com.ghprint.cms.common.AuthorityKey;
import com.ghprint.cms.controller.BaseAction;
import com.ghprint.cms.model.order.OrderEdit;
import com.ghprint.cms.pagination.DataGridResult;
import com.ghprint.cms.services.OrderDetailService;
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
public class QueryOrderController extends BaseAction {
    private static Logger log = LoggerFactory.getLogger(QueryOrderController.class);

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderDetailService orderDetailService;

    @RequestMapping(value = "/orders/selectorders.do", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public DataGridResult getOrdersList(HttpServletRequest request, HttpServletResponse response ,
                                                @RequestParam(value = "key")String key , @RequestParam(value = "value")String value,
                                                @RequestParam(value = "page")Integer page , @RequestParam(value = "rows")Integer rows){
        DataGridResult dataGridResult = new DataGridResult();
        try {
            Assert.hasText(String.valueOf(page), "page  is null or 空字符串。");
            Assert.hasText(String.valueOf(rows), "rows  is null or 空字符串。");
            log.info("getOrdersList request Param:key {},value {},page {},rows {}", new String[]{key,value, String.valueOf(page), String.valueOf(rows)});
            Boolean flag = super.execute(request, response);
            if (flag) {
                if(key.equals("")){key=null;}
                if(value.equals("")){value=null;}
                dataGridResult =  orderService.selectOrderList( key ,value, page ,rows);
                if(dataGridResult!=null) {
                    dataGridResult.setSuccess(Boolean.TRUE);
                }else{
                    dataGridResult.setSuccess(Boolean.FALSE);
                }
                log.info("getOrdersList response Param:{}", dataGridResult.toString());
                return dataGridResult;
            } else {
                dataGridResult.setSuccess(Boolean.FALSE);
                dataGridResult.setMessage(request.getAttribute("message").toString());
                return dataGridResult;
            }

        }catch (Exception e) {
            log.error("查询订单列表失败=:", e);
            dataGridResult.setSuccess(Boolean.FALSE);
            dataGridResult.setMessage("查询订单列表异常");
            return  dataGridResult;
        }

    }


    @RequestMapping(value = "/orders/selectdetail.do", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public DataGridResult getOrdersDetailList(HttpServletRequest request, HttpServletResponse response ,
                                        @RequestParam(value = "key")String key , @RequestParam(value = "value")String value,
                                        @RequestParam(value = "page")Integer page , @RequestParam(value = "rows")Integer rows){
        DataGridResult dataGridResult = new DataGridResult();
        try {
            Assert.hasText(String.valueOf(page), "page  is null or 空字符串。");
            Assert.hasText(String.valueOf(rows), "rows  is null or 空字符串。");
            log.info("getOrdersDetailList request Param:key {},value {},page {},rows {}", new String[]{key,value, String.valueOf(page), String.valueOf(rows)});
            Boolean flag = super.execute(request, response);
            if (flag) {
                if(key.equals("")){key=null;}
                if(value.equals("")){value=null;}
                dataGridResult =  orderDetailService.selectOrderDetailList( key ,value, page ,rows);
                if(dataGridResult!=null) {
                    dataGridResult.setSuccess(Boolean.TRUE);
                }else{
                    dataGridResult.setSuccess(Boolean.FALSE);
                }
                log.info("getOrdersDetailList response Param:{}", dataGridResult.toString());
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

    @RequestMapping(value = "/orders/editorder.do", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public Response<OrderEdit> OrderDetailEdit(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "orderId") Integer orderId) {
        Response<OrderEdit> responses = new Response<>();
        try {
            Assert.hasText(String.valueOf(orderId), "orderId  is null or 空字符串。");
            log.info("OrderDetailEdit request param:{}", orderId);
            Boolean flag = super.execute(request, response);
            if (flag) {
                OrderEdit orderInfo = orderService.getOrderEdit(orderId);
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
    @Override
    public String getAuthorityId() {
        return AuthorityKey.ORDER_SELECT;
    }
}
