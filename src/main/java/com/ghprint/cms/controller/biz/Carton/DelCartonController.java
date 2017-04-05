package com.ghprint.cms.controller.biz.Carton;

import cn.com.bestpay.Response;
import com.ghprint.cms.common.AuthorityKey;
import com.ghprint.cms.controller.BaseAction;
import com.ghprint.cms.services.CartonStockService;
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
 * Created by Administrator on 2017/4/5.
 */
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class DelCartonController  extends BaseAction {
    private static Logger log = LoggerFactory.getLogger(DelCartonController.class);

    @Autowired
    private CartonStockService cartonStockService ;

    @RequestMapping(value = "/cartonstocks/delcartonstocks.do", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public Response<String> cartonstockdelel(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "cid") Integer cid) {
        Response<String> responses = new Response<>();
        try {
            Assert.hasText(String.valueOf(cid), "cid  is null or 空字符串。");
            log.info("cartonstockdelel request param:{}", cid);
            Boolean flag = super.execute(request, response);
            if (flag) {
                Integer record = cartonStockService.delCartonStocks(cid);
                if (record > 0) {
                    responses.setErrorCode(Constant.errorCodeEnum.SUCCESS.getCode());
                    responses.setErrorMsg(Constant.errorCodeEnum.SUCCESS.getName());
                    responses.setResult(record.toString());
                } else {
                    responses.setErrorCode(Constant.errorCodeEnum.PARAM_ERROR.getCode());
                    responses.setErrorMsg(Constant.errorCodeEnum.PARAM_ERROR.getName());
                    log.info("cartonstockdelel delete fail ,no this record");
                }
                return responses;

            } else {
                responses.setErrorCode(Constant.errorCodeEnum.LOGIN_TIMEOUT_ERROE.getCode());
                responses.setErrorMsg(request.getAttribute("message").toString());
                return responses;
            }
        } catch (Exception e) {
            log.error("删除纸箱库存失败=:", e);
            responses.setErrorCode(Constant.errorCodeEnum.FAILURE.getCode());
            responses.setErrorMsg("删除纸箱库存异常");
            return responses;
        }


    }


    @Override
    public String getAuthorityId() {
        return AuthorityKey.CARTONSTOCKS_DEL;
    }
}
