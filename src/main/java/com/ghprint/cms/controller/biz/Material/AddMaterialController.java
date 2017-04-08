package com.ghprint.cms.controller.biz.Material;

import cn.com.bestpay.Response;
import com.ghprint.cms.common.AuthorityKey;
import com.ghprint.cms.controller.BaseAction;
import com.ghprint.cms.model.stock.TMaterialStock;
import com.ghprint.cms.services.MaterialStockService;
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
 * Created by Administrator on 2017/4/7.
 */
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class AddMaterialController extends BaseAction{

    private static Logger log = LoggerFactory.getLogger(AddMaterialController.class);

    @Autowired
    private MaterialStockService materialStockService;

    @RequestMapping(value = "/materialstocks/addmaterialstocks.do", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public Response<String> MaterialStockAdd(HttpServletRequest request, HttpServletResponse response , @RequestBody TMaterialStock materialStock)  {
        Response<String> responses = new Response<>();
        log.info("MaterialStockAdd request param:{}",materialStock.toString());
        try {
            Assert.hasText(materialStock.getName(), "materialStock 中 NAME  is null or 空字符串。");
            Assert.hasText(String.valueOf(materialStock.getSpecification()), "materialStock 中 Specification  is null or 空字符串。");
            Boolean flag = super.execute(request, response);
            if (flag) {
                Integer result = materialStockService.addMaterialStock(materialStock);
                if(result>0) {
                    responses.setErrorCode(Constant.errorCodeEnum.SUCCESS.getCode());
                    responses.setErrorMsg(Constant.errorCodeEnum.SUCCESS.getName());
                    responses.setResult(result.toString());
                }else {
                    responses.setErrorCode(Constant.errorCodeEnum.FAILURE.getCode());
                    responses.setErrorMsg("添加原材料库存异常");
                }

                return  responses;

            } else {
                responses.setErrorCode(Constant.errorCodeEnum.LOGIN_TIMEOUT_ERROE.getCode());
                responses.setErrorMsg(request.getAttribute("message").toString());
                return responses;
            }
        } catch (Exception e) {
            log.error("添加原材料库存失败=:", e);
            responses.setErrorCode(Constant.errorCodeEnum.FAILURE.getCode());
            responses.setErrorMsg("添加原材料库存异常");
            return responses;
        }
    }




    @Override
    public String getAuthorityId() {
        return AuthorityKey.MATERIALSTOCK_ADD;
    }
}
