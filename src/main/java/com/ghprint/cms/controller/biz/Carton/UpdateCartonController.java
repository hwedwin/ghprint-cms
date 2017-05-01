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
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/4/5.
 */
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class UpdateCartonController extends BaseAction {
    private static Logger log = LoggerFactory.getLogger(UpdateCartonController.class);
    @Autowired
    private CartonStockService cartonStockService;

    @RequestMapping(value = "/cartonstocks/editcartonstocks.do", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public Response<TCartonStock> cartonstockedit(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "cid") Integer cid) {
        Response<TCartonStock> responses = new Response<>();
        try {
            Assert.hasText(String.valueOf(cid), "cid  is null or 空字符串。");
            log.info("cartonstockedit request param:{}", cid);
            Boolean flag = super.execute(request, response);
            if (flag) {
                TCartonStock cartonStock = cartonStockService.getCartonStockbyId(cid);
                if (cartonStock != null) {
                    responses.setErrorCode(Constant.errorCodeEnum.SUCCESS.getCode());
                    responses.setErrorMsg(Constant.errorCodeEnum.SUCCESS.getName());
                    responses.setResult(cartonStock);
                } else {
                    responses.setErrorCode(Constant.errorCodeEnum.PARAM_ERROR.getCode());
                    responses.setErrorMsg(Constant.errorCodeEnum.PARAM_ERROR.getName());
                    log.info("cartonstockedit edit fail ,no this record");
                }
                return responses;
            } else {
                responses.setErrorCode(Constant.errorCodeEnum.LOGIN_TIMEOUT_ERROE.getCode());
                responses.setErrorMsg(request.getAttribute("message").toString());
                return responses;
            }
        } catch (Exception e) {
            log.error("编辑纸箱库存初始化失败=:", e);
            responses.setErrorCode(Constant.errorCodeEnum.FAILURE.getCode());
            responses.setErrorMsg("编辑纸箱库存初始化异常");
            return responses;
        }

    }


    @RequestMapping(value = "/cartonstocks/updatecartonstocks.do", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public Response<String> cartonstocksupdate(HttpServletRequest request, HttpServletResponse response, @RequestBody TCartonStock cartonStock) {
        Response<String> responses = new Response<>();
        try {
            Assert.hasText(String.valueOf(cartonStock.getId()), " 主键 id  is null or 空字符串。");
            log.info("cartonstocksupdate request param:{}", cartonStock.toString());
            Boolean flag = super.execute(request, response);
            if (flag) {
                Integer record = cartonStockService.updateCartonStocks(cartonStock);
                if (record > 0) {
                    responses.setErrorCode(Constant.errorCodeEnum.SUCCESS.getCode());
                    responses.setErrorMsg(Constant.errorCodeEnum.SUCCESS.getName());
                    responses.setResult(String.valueOf(record));
                } else {
                    responses.setErrorCode(Constant.errorCodeEnum.FAILURE.getCode());
                    responses.setErrorMsg("修改纸箱库存记录异常");
                }
                return responses;
            } else {
                responses.setErrorCode(Constant.errorCodeEnum.LOGIN_TIMEOUT_ERROE.getCode());
                responses.setErrorMsg(request.getAttribute("message").toString());
                return responses;
            }
        } catch (Exception e) {
            log.error("修改纸箱库存记录失败=:", e);
            responses.setErrorCode(Constant.errorCodeEnum.FAILURE.getCode());
            responses.setErrorMsg("修改纸箱库存记录异常");
            return responses;
        }
    }

    @RequestMapping(value = "/cartonstocks/addstocksum.do", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public  Response<String> addcartonstocksum(HttpServletRequest request, HttpServletResponse response,@RequestParam(value = "cid") Integer cid ,@RequestParam(value = "sum") Integer sum)
    {
        Response<String> responses = new Response<>();
        try {
            Assert.hasText(String.valueOf(cid), "sid  is null or 空字符串。");
            Assert.hasText(String.valueOf(sum), "sum  is null or 空字符串。");
            log.info("addcartonstocksum request param:{},{}", cid,sum);
            Boolean flag = super.execute(request, response);
            if (flag) {
                Integer record = cartonStockService.addStockCount(cid,sum);
                if (record > 0) {
                    responses.setErrorCode(Constant.errorCodeEnum.SUCCESS.getCode());
                    responses.setErrorMsg(Constant.errorCodeEnum.SUCCESS.getName());
                    responses.setResult(String.valueOf(record));
                } else {
                    responses.setErrorCode(Constant.errorCodeEnum.FAILURE.getCode());
                    responses.setErrorMsg("增加纸箱库存数量异常");
                }
                return responses;
            } else {
                responses.setErrorCode(Constant.errorCodeEnum.LOGIN_TIMEOUT_ERROE.getCode());
                responses.setErrorMsg(request.getAttribute("message").toString());
                return responses;
            }
        } catch (Exception e) {
            log.error("增加纸箱库存数量失败=:", e);
            responses.setErrorCode(Constant.errorCodeEnum.FAILURE.getCode());
            responses.setErrorMsg("增加纸箱库存数量异常");
            return responses;
        }
    }

    @RequestMapping(value = "/cartonstocks/substocksum.do", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public  Response<String> subcartonstocksum(HttpServletRequest request, HttpServletResponse response,@RequestParam(value = "cid") Integer cid ,@RequestParam(value = "sum") Integer sum)
    {
        Response<String> responses = new Response<>();
        try {
            Assert.hasText(String.valueOf(cid), "cid  is null or 空字符串。");
            Assert.hasText(String.valueOf(sum), "sum  is null or 空字符串。");
            log.info("subcartonstocksum request param:{},{}", cid,sum);
            Boolean flag = super.execute(request, response);
            if (flag) {
                Integer record = cartonStockService.subStockCount(cid,sum);
                if (record >=0) {
                    responses.setErrorCode(Constant.errorCodeEnum.SUCCESS.getCode());
                    responses.setErrorMsg(Constant.errorCodeEnum.SUCCESS.getName());
                    responses.setResult(String.valueOf(record));
                } else {
                    responses.setErrorCode(Constant.errorCodeEnum.FAILURE.getCode());
                    responses.setErrorMsg("减少纸箱库存数量异常");
                }
                return responses;
            } else {
                responses.setErrorCode(Constant.errorCodeEnum.LOGIN_TIMEOUT_ERROE.getCode());
                responses.setErrorMsg(request.getAttribute("message").toString());
                return responses;
            }
        } catch (Exception e) {
            log.error("减少纸箱库存数量失败=:", e);
            responses.setErrorCode(Constant.errorCodeEnum.FAILURE.getCode());
            responses.setErrorMsg("减少纸箱库存数量异常");
            return responses;
        }
    }

    @Override
    public String getAuthorityId() {
        return AuthorityKey.CARTONSTOCKS_UPDATE;
    }
}
