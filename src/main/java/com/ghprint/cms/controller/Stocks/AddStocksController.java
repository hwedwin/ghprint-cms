package com.ghprint.cms.controller.Stocks;

import cn.com.bestpay.Response;
import com.ghprint.cms.common.AuthorityKey;
import com.ghprint.cms.controller.BaseAction;
import com.ghprint.cms.model.production.TCustomerInfo;
import com.ghprint.cms.model.stock.TProductionStock;
import com.ghprint.cms.services.CustomerInfoService;
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
import java.util.List;

/**
 * Created by Administrator on 2017/3/29.
 */
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class AddStocksController extends BaseAction{

    private static Logger log = LoggerFactory.getLogger(AddStocksController.class);
    @Autowired
    private ProStockService proStockService;
    @Autowired
    private CustomerInfoService customerInfoService;

    @RequestMapping(value = "/prostocks/initprostocks.do", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public Response<List<TCustomerInfo>> prostocksinit(HttpServletRequest request, HttpServletResponse response) {
        Response<List<TCustomerInfo>> responses = new Response<>();
        try {
            Boolean flag = super.execute(request, response);
            if (flag) {
                List<TCustomerInfo> customerInfo = customerInfoService.selectCustomers();
                if(customerInfo!=null) {
                    responses.setErrorCode(Constant.errorCodeEnum.SUCCESS.getCode());
                    responses.setErrorMsg(Constant.errorCodeEnum.SUCCESS.getName());
                    responses.setResult(customerInfo);
                }
                return  responses;

            } else {
                responses.setErrorCode(Constant.errorCodeEnum.LOGIN_TIMEOUT_ERROE.getCode());
                responses.setErrorMsg(request.getAttribute("message").toString());
                return responses;
            }
        } catch (Exception e) {
            log.error("添加成品库存初始化失败=:", e);
            responses.setErrorCode(Constant.errorCodeEnum.FAILURE.getCode());
            responses.setErrorMsg("添加成品库存初始化异常");
            return responses;
        }

    }

    @RequestMapping(value = "/prostocks/addprostocks.do", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public   Response<String> prostocksadd(HttpServletRequest request, HttpServletResponse response , @RequestBody TProductionStock productionStock)  {
        Response<String> responses = new Response<>();
        log.info("AddProStocks request param:{}",productionStock.toString());
        try {
            Assert.hasText(productionStock.getStockid(), "productionStock 中 Stockid  is null or 空字符串。");
            Assert.hasText(productionStock.getCustomerid().toString(), "productionStock 中 Customerid  is null or 空字符串。");
            Boolean flag = super.execute(request, response);
            if (flag) {
                Integer result = proStockService.addProStock(productionStock);
                if(result>0) {
                    responses.setErrorCode(Constant.errorCodeEnum.SUCCESS.getCode());
                    responses.setErrorMsg(Constant.errorCodeEnum.SUCCESS.getName());
                    responses.setResult(result.toString());
                }else {
                    responses.setErrorCode(Constant.errorCodeEnum.FAILURE.getCode());
                    responses.setErrorMsg("添加成品库存异常");
                }

                return  responses;

            } else {
                responses.setErrorCode(Constant.errorCodeEnum.LOGIN_TIMEOUT_ERROE.getCode());
                responses.setErrorMsg(request.getAttribute("message").toString());
                return responses;
            }
        } catch (Exception e) {
            log.error("添加成品库存失败=:", e);
            responses.setErrorCode(Constant.errorCodeEnum.FAILURE.getCode());
            responses.setErrorMsg("添加成品库存异常");
            return responses;
        }
    }
    @Override
    public String getAuthorityId() {
        return AuthorityKey.PROSTOCKS_ADD;
    }
}
