package com.ghprint.cms.controller.biz.Stocks;

import cn.com.bestpay.Response;
import com.ghprint.cms.common.AuthorityKey;
import com.ghprint.cms.controller.BaseAction;
import com.ghprint.cms.model.stock.TProductionStock;
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
public class UpdateStocksController extends BaseAction {
    private static Logger log = LoggerFactory.getLogger(UpdateStocksController.class);
    @Autowired
    private ProStockService proStockService;

    @RequestMapping(value = "/prostocks/editprostocks.do", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public Response<TProductionStock> prostockedit(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "sid") Integer sid) {
        Response<TProductionStock> responses = new Response<>();
        try {
            Assert.hasText(String.valueOf(sid), "sid  is null or 空字符串。");
            log.info("editprostocks request param:{}", sid);
            Boolean flag = super.execute(request, response);
            if (flag) {
                TProductionStock productionStock = proStockService.getProStockbyId(sid);
                if(productionStock!=null) {
                    responses.setErrorCode(Constant.errorCodeEnum.SUCCESS.getCode());
                    responses.setErrorMsg(Constant.errorCodeEnum.SUCCESS.getName());
                    responses.setResult(productionStock);
                }else{
                    responses.setErrorCode(Constant.errorCodeEnum.PARAM_ERROR.getCode());
                    responses.setErrorMsg(Constant.errorCodeEnum.PARAM_ERROR.getName());
                    log.info("prostockedit edit fail ,no this record");
                }
                return responses;
            } else {
                responses.setErrorCode(Constant.errorCodeEnum.LOGIN_TIMEOUT_ERROE.getCode());
                responses.setErrorMsg(request.getAttribute("message").toString());
                return responses;
            }
        } catch (Exception e) {
            log.error("编辑成品库存初始化失败=:", e);
            responses.setErrorCode(Constant.errorCodeEnum.FAILURE.getCode());
            responses.setErrorMsg("编辑成品库存初始化异常");
            return responses;
        }

    }


    @RequestMapping(value = "/prostocks/updateprostocks.do", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public  Response<String> prostocksupdate(HttpServletRequest request, HttpServletResponse response, @RequestBody TProductionStock productionStock) {
        Response<String> responses = new Response<>();
        try {
            Assert.hasText(String.valueOf(productionStock.getId()), " 主键 id  is null or 空字符串。");
            log.info("prostocksupdate request param:{}", productionStock.toString());
            Boolean flag = super.execute(request, response);
            if (flag) {
                Integer record = proStockService.updateProStock(productionStock);
                if (record > 0) {
                    responses.setErrorCode(Constant.errorCodeEnum.SUCCESS.getCode());
                    responses.setErrorMsg(Constant.errorCodeEnum.SUCCESS.getName());
                    responses.setResult(String.valueOf(record));
                } else {
                    responses.setErrorCode(Constant.errorCodeEnum.FAILURE.getCode());
                    responses.setErrorMsg("修改成品库存记录异常");
                }
                return responses;
            } else {
                responses.setErrorCode(Constant.errorCodeEnum.LOGIN_TIMEOUT_ERROE.getCode());
                responses.setErrorMsg(request.getAttribute("message").toString());
                return responses;
            }
        } catch (Exception e) {
            log.error("修改成品库存记录失败=:", e);
            responses.setErrorCode(Constant.errorCodeEnum.FAILURE.getCode());
            responses.setErrorMsg("修改成品库存记录异常");
            return responses;
        }
    }

        @RequestMapping(value = "/prostocks/addstocksum.do", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
        @ResponseBody
        public  Response<String> addprostocksum(HttpServletRequest request, HttpServletResponse response,@RequestParam(value = "sid") Integer sid ,@RequestParam(value = "sum") Integer sum)
        {
            Response<String> responses = new Response<>();
            try {
                Assert.hasText(String.valueOf(sid), "sid  is null or 空字符串。");
                Assert.hasText(String.valueOf(sum), "sum  is null or 空字符串。");
                log.info("addstocksum request param:{},{}", sid,sum);
                Boolean flag = super.execute(request, response);
                if (flag) {
                    Integer record = proStockService.addStocksum(sid,sum);
                    if (record > 0) {
                        responses.setErrorCode(Constant.errorCodeEnum.SUCCESS.getCode());
                        responses.setErrorMsg(Constant.errorCodeEnum.SUCCESS.getName());
                        responses.setResult(String.valueOf(record));
                    } else {
                        responses.setErrorCode(Constant.errorCodeEnum.FAILURE.getCode());
                        responses.setErrorMsg("增加成品库存数量异常");
                    }
                    return responses;
                } else {
                    responses.setErrorCode(Constant.errorCodeEnum.LOGIN_TIMEOUT_ERROE.getCode());
                    responses.setErrorMsg(request.getAttribute("message").toString());
                    return responses;
                }
            } catch (Exception e) {
                log.error("增加成品库存数量失败=:", e);
                responses.setErrorCode(Constant.errorCodeEnum.FAILURE.getCode());
                responses.setErrorMsg("增加成品库存数量异常");
                return responses;
            }
        }

    @RequestMapping(value = "/prostocks/substocksum.do", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public  Response<String> subprostocksum(HttpServletRequest request, HttpServletResponse response,@RequestParam(value = "sid") Integer sid ,@RequestParam(value = "sum") Integer sum)
    {
        Response<String> responses = new Response<>();
        try {
            Assert.hasText(String.valueOf(sid), "sid  is null or 空字符串。");
            Assert.hasText(String.valueOf(sum), "sum  is null or 空字符串。");
            log.info("substocksum request param:{},{}", sid,sum);
            Boolean flag = super.execute(request, response);
            if (flag) {
                Integer record = proStockService.subStocksum(sid,sum);
                if (record > 0) {
                    responses.setErrorCode(Constant.errorCodeEnum.SUCCESS.getCode());
                    responses.setErrorMsg(Constant.errorCodeEnum.SUCCESS.getName());
                    responses.setResult(String.valueOf(record));
                } else {
                    responses.setErrorCode(Constant.errorCodeEnum.FAILURE.getCode());
                    responses.setErrorMsg("减少成品库存数量异常");
                }
                return responses;
            } else {
                responses.setErrorCode(Constant.errorCodeEnum.LOGIN_TIMEOUT_ERROE.getCode());
                responses.setErrorMsg(request.getAttribute("message").toString());
                return responses;
            }
        } catch (Exception e) {
            log.error("减少成品库存数量失败=:", e);
            responses.setErrorCode(Constant.errorCodeEnum.FAILURE.getCode());
            responses.setErrorMsg("减少成品库存数量异常");
            return responses;
        }
    }


    @Override
    public String getAuthorityId() {
        return AuthorityKey.PROSTOCKS_UPDATE;
    }
}
