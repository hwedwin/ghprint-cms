package com.ghprint.cms.controller.biz.Stocks;

import cn.com.bestpay.Response;
import com.ghprint.cms.common.AuthorityKey;
import com.ghprint.cms.controller.BaseAction;
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

/**
 * Created by Administrator on 2017/3/30.
 */
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class DelStocksController extends BaseAction {

    private static Logger log = LoggerFactory.getLogger(DelStocksController.class);

    @Autowired
    private ProStockService proStockService;


    @RequestMapping(value = "/prostocks/delprostocks.do", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public Response<String> prostockdelel(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "sid") Integer sid) {
        Response<String> responses = new Response<>();
        try {
            Assert.hasText(String.valueOf(sid), "sid  is null or 空字符串。");
            log.info("prostockdelel request param:{}", sid);
            Boolean flag = super.execute(request, response);
            if (flag) {
                Integer record = proStockService.delProStock(sid);
                if (record > 0) {
                    responses.setErrorCode(Constant.errorCodeEnum.SUCCESS.getCode());
                    responses.setErrorMsg(Constant.errorCodeEnum.SUCCESS.getName());
                    responses.setResult(record.toString());
                } else {
                    responses.setErrorCode(Constant.errorCodeEnum.PARAM_ERROR.getCode());
                    responses.setErrorMsg(Constant.errorCodeEnum.PARAM_ERROR.getName());
                    log.info("prostockdelel delete fail ,no this record");
                }
                return responses;

            } else {
                responses.setErrorCode(Constant.errorCodeEnum.LOGIN_TIMEOUT_ERROE.getCode());
                responses.setErrorMsg(request.getAttribute("message").toString());
                return responses;
            }
        } catch (Exception e) {
            log.error("删除成品库存初始化失败=:", e);
            responses.setErrorCode(Constant.errorCodeEnum.FAILURE.getCode());
            responses.setErrorMsg("删除成品库存初始化异常");
            return responses;
        }


    }


    @Override
    public String getAuthorityId() {
        return AuthorityKey.PROSTOCKS_DEL;
    }
}
