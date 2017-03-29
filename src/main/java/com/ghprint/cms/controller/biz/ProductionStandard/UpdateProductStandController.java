package com.ghprint.cms.controller.biz.ProductionStandard;

import cn.com.bestpay.Response;
import com.ghprint.cms.common.AuthorityKey;
import com.ghprint.cms.controller.BaseAction;
import com.ghprint.cms.model.production.ProductionInfoView;
import com.ghprint.cms.services.ProductionInfoService;
import com.ghprint.cms.utils.Constant;
import com.wordnik.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Administrator on 2017/3/16.
 */
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class UpdateProductStandController extends BaseAction {
    private static Logger log = LoggerFactory.getLogger(UpdateProductStandController.class);

    @Autowired
    private ProductionInfoService productionInfoService;

    @RequestMapping(value = "/product/PreUpdateproduct.do", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    @ApiOperation(value = "修改生产质量标准初始化")
    public Response<ProductionInfoView> updatepreproduct(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "pid") Integer pid) {
        Response<ProductionInfoView> responses = new Response<>();
        try {
            Boolean flag = super.execute(request, response);
            if (flag) {
                ProductionInfoView productionInfoView = productionInfoService.getProductionitem(pid);
                responses.setErrorCode(Constant.errorCodeEnum.SUCCESS.getCode());
                responses.setErrorMsg(Constant.errorCodeEnum.SUCCESS.getName());
                responses.setResult(productionInfoView);
                return responses;
            } else {
                responses.setErrorCode(Constant.errorCodeEnum.LOGIN_TIMEOUT_ERROE.getCode());
                responses.setErrorMsg(request.getAttribute("message").toString());
                return responses;
            }
        } catch (Exception e) {
            log.error("修改生产标准初始化失败=:", e);
            responses.setErrorCode(Constant.errorCodeEnum.FAILURE.getCode());
            responses.setErrorMsg("修改生产标准初始化异常");
            return responses;
        }

    }


    @RequestMapping(value = "/product/updateproduct.do", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    @ApiOperation(value = "修改生产质量标准")
    public Response<String> updateproduct(HttpServletRequest request, HttpServletResponse response, @RequestBody ProductionInfoView prod) {
        Response<String> responses = new Response<>();
        try {
            log.info("UPDATEProduct request param:{}", prod.toString());
            Boolean flag = super.execute(request, response);
            if (flag) {
                Integer record = productionInfoService.updateProductionitems(prod);
                if(record==6) {
                    responses.setErrorCode(Constant.errorCodeEnum.SUCCESS.getCode());
                    responses.setErrorMsg(Constant.errorCodeEnum.SUCCESS.getName());
                    responses.setResult(String.valueOf(record));
                }else{
                    responses.setErrorCode(Constant.errorCodeEnum.FAILURE.getCode());
                    responses.setErrorMsg("修改生产标准记录异常");
                }
                return responses;
            } else {
                responses.setErrorCode(Constant.errorCodeEnum.LOGIN_TIMEOUT_ERROE.getCode());
                responses.setErrorMsg(request.getAttribute("message").toString());
                return responses;
            }
        } catch (Exception e) {
            log.error("修改生产标准记录失败=:", e);
            responses.setErrorCode(Constant.errorCodeEnum.FAILURE.getCode());
            responses.setErrorMsg("修改生产标准记录异常");
            return responses;
        }
    }

    @Override
    public String getAuthorityId() {
        return AuthorityKey.PRODUCTION_UPDATE;
    }
}
