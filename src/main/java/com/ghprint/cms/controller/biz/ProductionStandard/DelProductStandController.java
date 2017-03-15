package com.ghprint.cms.controller.biz.ProductionStandard;

import cn.com.bestpay.Response;
import com.ghprint.cms.common.AuthorityKey;
import com.ghprint.cms.controller.BaseAction;
import com.ghprint.cms.services.ProductionInfoService;
import com.ghprint.cms.utils.Constant;
import com.wordnik.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/3/15.
 */
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class DelProductStandController extends BaseAction {

    private static Logger log = LoggerFactory.getLogger(DelProductStandController.class);
    @Autowired
    private ProductionInfoService productionInfoService;

    @RequestMapping(value = "/product/delproduct.do", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    @ApiOperation(value = "删除生产质量标准")
    public Response<String> delproduct(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "pid")Integer pid){
        Response <String> responses = new Response<>();
        try{
            Assert.hasText(String.valueOf(pid), "pid  is null or 空字符串。");
            log.info("DELProduct request param:{}",pid);
            Boolean flag = super.execute(request, response);
            if (flag) {
                Integer p =  productionInfoService.delProductionitems(pid);
                if(p>0) {
                    responses.setErrorCode(Constant.errorCodeEnum.SUCCESS.getCode());
                    responses.setErrorMsg(Constant.errorCodeEnum.SUCCESS.getName());
                    responses.setResult(p.toString());
                    log.info("DELProduct delete success:{}", p);
                }else {
                    responses.setErrorCode(Constant.errorCodeEnum.PARAM_ERROR.getCode());
                    responses.setErrorMsg(Constant.errorCodeEnum.PARAM_ERROR.getName());
                    log.info("DELProduct delete fail ,no this record");
                }
                return  responses;
            } else {
                responses.setErrorCode(Constant.errorCodeEnum.LOGIN_TIMEOUT_ERROE.getCode());
                responses.setErrorMsg(request.getAttribute("message").toString());
                return responses;
            }
        }catch (Exception e) {
            log.error("删除生产标准记录失败=:", e);
            responses.setErrorCode(Constant.errorCodeEnum.FAILURE.getCode());
            responses.setErrorMsg("删除生产标准记录异常");
            return  responses;
        }

    }

    @Override
    public String getAuthorityId() {
        return AuthorityKey.PRODUCTION_DELETE;
    }
}
