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
public class UpdateMaterialController extends BaseAction {
    private static Logger log = LoggerFactory.getLogger(UpdateMaterialController.class);
    @Autowired
    private MaterialStockService materialStockService;

    @RequestMapping(value = "/materialstocks/editmaterialstocks.do", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public Response<TMaterialStock> MaterialStockEdit(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "mid") Integer mid) {
        Response<TMaterialStock> responses = new Response<>();
        try {
            Assert.hasText(String.valueOf(mid), "mid  is null or 空字符串。");
            log.info("MaterialStockEdit request param:{}", mid);
            Boolean flag = super.execute(request, response);
            if (flag) {
                TMaterialStock materialStock = materialStockService.getMaterialStockById(mid);
                if (materialStock != null) {
                    responses.setErrorCode(Constant.errorCodeEnum.SUCCESS.getCode());
                    responses.setErrorMsg(Constant.errorCodeEnum.SUCCESS.getName());
                    responses.setResult(materialStock);
                } else {
                    responses.setErrorCode(Constant.errorCodeEnum.PARAM_ERROR.getCode());
                    responses.setErrorMsg(Constant.errorCodeEnum.PARAM_ERROR.getName());
                    log.info("MaterialStocEdit edit fail ,no this record");
                }
                return responses;
            } else {
                responses.setErrorCode(Constant.errorCodeEnum.LOGIN_TIMEOUT_ERROE.getCode());
                responses.setErrorMsg(request.getAttribute("message").toString());
                return responses;
            }
        } catch (Exception e) {
            log.error("编辑原材料库存初始化失败=:", e);
            responses.setErrorCode(Constant.errorCodeEnum.FAILURE.getCode());
            responses.setErrorMsg("编辑原材料库存初始化异常");
            return responses;
        }

    }


    @RequestMapping(value = "/materialstocks/updatematerialstocks.do", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public Response<String> MaterialStockUpdate(HttpServletRequest request, HttpServletResponse response, @RequestBody TMaterialStock materialStock) {
        Response<String> responses = new Response<>();
        try {
            Assert.hasText(String.valueOf(materialStock.getId()), " 主键 id  is null or 空字符串。");
            Assert.hasText(materialStock.getMaterialsum().toString(), "materialStock 中 Materialsum  is null or 空字符串。");
            log.info("MaterialStockUpdate request param:{}", materialStock.toString());
            Boolean flag = super.execute(request, response);
            if (flag) {
                Integer record = materialStockService.updateMaterialStock(materialStock);
                if (record > 0) {
                    responses.setErrorCode(Constant.errorCodeEnum.SUCCESS.getCode());
                    responses.setErrorMsg(Constant.errorCodeEnum.SUCCESS.getName());
                    responses.setResult(String.valueOf(record));
                } else {
                    responses.setErrorCode(Constant.errorCodeEnum.FAILURE.getCode());
                    responses.setErrorMsg("修改原材料库存记录异常");
                }
                return responses;
            } else {
                responses.setErrorCode(Constant.errorCodeEnum.LOGIN_TIMEOUT_ERROE.getCode());
                responses.setErrorMsg(request.getAttribute("message").toString());
                return responses;
            }
        } catch (Exception e) {
            log.error("修改原材料库存记录失败=:", e);
            responses.setErrorCode(Constant.errorCodeEnum.FAILURE.getCode());
            responses.setErrorMsg("修改原材料库存记录异常");
            return responses;
        }
    }

    @RequestMapping(value = "/materialstocks/addstocksum.do", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public  Response<String> AddMaterialStockSum(HttpServletRequest request, HttpServletResponse response,@RequestParam(value = "mid") Integer mid ,@RequestParam(value = "sum") Float sum)
    {
        Response<String> responses = new Response<>();
        try {
            Assert.hasText(String.valueOf(mid), "mid  is null or 空字符串。");
            Assert.hasText(String.valueOf(sum), "sum  is null or 空字符串。");
            log.info("AddMaterialStockSum request param:{},{}", mid,sum);
            Boolean flag = super.execute(request, response);
            if (flag) {
                float record = materialStockService.addMaterialStocksum(mid,sum);
                if (record > 0) {
                    responses.setErrorCode(Constant.errorCodeEnum.SUCCESS.getCode());
                    responses.setErrorMsg(Constant.errorCodeEnum.SUCCESS.getName());
                    responses.setResult(String.valueOf(record));
                } else {
                    responses.setErrorCode(Constant.errorCodeEnum.FAILURE.getCode());
                    responses.setErrorMsg("增加原材料库存数量异常");
                }
                return responses;
            } else {
                responses.setErrorCode(Constant.errorCodeEnum.LOGIN_TIMEOUT_ERROE.getCode());
                responses.setErrorMsg(request.getAttribute("message").toString());
                return responses;
            }
        } catch (Exception e) {
            log.error("增加原材料库存数量失败=:", e);
            responses.setErrorCode(Constant.errorCodeEnum.FAILURE.getCode());
            responses.setErrorMsg("增加原材料库存数量异常");
            return responses;
        }
    }

    @RequestMapping(value = "/materialstocks/substocksum.do", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public  Response<String> SubMaterialStockSum(HttpServletRequest request, HttpServletResponse response,@RequestParam(value = "mid") Integer mid ,@RequestParam(value = "sum") Float sum)
    {
        Response<String> responses = new Response<>();
        try {
            Assert.hasText(String.valueOf(mid), "cid  is null or 空字符串。");
            Assert.hasText(String.valueOf(sum), "sum  is null or 空字符串。");
            log.info("SubMaterialStockSum request param:{},{}", mid,sum);
            Boolean flag = super.execute(request, response);
            if (flag) {
                float record = materialStockService.subMaterialStocksum(mid,sum);
                if (record > 0) {
                    responses.setErrorCode(Constant.errorCodeEnum.SUCCESS.getCode());
                    responses.setErrorMsg(Constant.errorCodeEnum.SUCCESS.getName());
                    responses.setResult(String.valueOf(record));
                } else {
                    responses.setErrorCode(Constant.errorCodeEnum.FAILURE.getCode());
                    responses.setErrorMsg("减少原材料库存数量异常");
                }
                return responses;
            } else {
                responses.setErrorCode(Constant.errorCodeEnum.LOGIN_TIMEOUT_ERROE.getCode());
                responses.setErrorMsg(request.getAttribute("message").toString());
                return responses;
            }
        } catch (Exception e) {
            log.error("减少原材料库存数量失败=:", e);
            responses.setErrorCode(Constant.errorCodeEnum.FAILURE.getCode());
            responses.setErrorMsg("减少原材料库存数量异常");
            return responses;
        }
    }


    @Override
    public String getAuthorityId() {
        return AuthorityKey.MATERIALSTOCK_UPDATE;
    }
}
