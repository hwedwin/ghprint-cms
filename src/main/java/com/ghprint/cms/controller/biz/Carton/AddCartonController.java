package com.ghprint.cms.controller.biz.Carton;

import cn.com.bestpay.Response;
import com.ghprint.cms.common.AuthorityKey;
import com.ghprint.cms.controller.BaseAction;
import com.ghprint.cms.model.stock.TCartonStock;
import com.ghprint.cms.services.CartonStockService;
import com.ghprint.cms.utils.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/4/5.
 */
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class AddCartonController  extends BaseAction {

    private static Logger log = LoggerFactory.getLogger(AddCartonController.class);

    @Autowired
    private CartonStockService cartonStockService ;

    @RequestMapping(value = "/cartonstocks/addcartonstocks.do", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public Response<String> cartonstocksadd(HttpServletRequest request, HttpServletResponse response , @RequestBody TCartonStock  cartonStock)  {
        Response<String> responses = new Response<>();
        log.info("AddCartonController request param:{}",cartonStock.toString());
        try {
            Boolean flag = super.execute(request, response);
            if (flag) {
                Integer result = cartonStockService.addCartonStocks(cartonStock);
                if(result>0) {
                    responses.setErrorCode(Constant.errorCodeEnum.SUCCESS.getCode());
                    responses.setErrorMsg(Constant.errorCodeEnum.SUCCESS.getName());
                    responses.setResult(result.toString());
                }else {
                    responses.setErrorCode(Constant.errorCodeEnum.FAILURE.getCode());
                    responses.setErrorMsg("添加纸箱库存异常");
                }

                return  responses;

            } else {
                responses.setErrorCode(Constant.errorCodeEnum.LOGIN_TIMEOUT_ERROE.getCode());
                responses.setErrorMsg(request.getAttribute("message").toString());
                return responses;
            }
        } catch (Exception e) {
            log.error("添加纸箱库存失败=:", e);
            responses.setErrorCode(Constant.errorCodeEnum.FAILURE.getCode());
            responses.setErrorMsg("添加纸箱库存异常");
            return responses;
        }
    }


    @Override
    public String getAuthorityId() {
       return AuthorityKey.CARTONSTOCKS_ADD;
    }
}
