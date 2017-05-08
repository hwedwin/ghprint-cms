package com.ghprint.cms.controller.biz.Material;

import cn.com.bestpay.Response;
import com.ghprint.cms.common.AuthorityKey;
import com.ghprint.cms.controller.BaseAction;
import com.ghprint.cms.model.stock.TMaterialCost;
import com.ghprint.cms.model.stock.TMaterialStock;
import com.ghprint.cms.pagination.DataGridResult;
import com.ghprint.cms.services.MaterialCostService;
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
import java.util.List;

/**
 * Created by Administrator on 2017/4/7.
 */
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class QueryMaterialController extends BaseAction {

    private static Logger log = LoggerFactory.getLogger(QueryMaterialController.class);

    @Autowired
    private MaterialStockService  materialStockService ;

    @Autowired
    private MaterialCostService materialCostService;


    @RequestMapping(value = "/materialstocks/selectstocks.do", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public DataGridResult getMaterialStocksList(HttpServletRequest request, HttpServletResponse response ,
                                              @RequestParam(value = "key")String key , @RequestParam(value = "value")String value,
                                              @RequestParam(value = "page")Integer page , @RequestParam(value = "rows")Integer rows){
        DataGridResult dataGridResult = new DataGridResult();
        try {
            Assert.hasText(String.valueOf(page), "page  is null or 空字符串。");
            Assert.hasText(String.valueOf(rows), "rows  is null or 空字符串。");
            log.info("getMaterialStocksList request Param:key {},value {},page {},rows {}", new String[]{key,value, String.valueOf(page), String.valueOf(rows)});
            Boolean flag = super.execute(request, response);
            if (flag) {
                if(key.equals("")){key=null;}
                if(value.equals("")){value=null;}
                dataGridResult =  materialStockService.selectMaterialStockList( key ,value, page ,rows);
                if(dataGridResult!=null) {
                    dataGridResult.setSuccess(Boolean.TRUE);
                }else{
                    dataGridResult.setSuccess(Boolean.FALSE);
                }
                log.info("getMaterialStocksList response Param:{}", dataGridResult.toString());
                return dataGridResult;
            } else {
                dataGridResult.setSuccess(Boolean.FALSE);
                dataGridResult.setMessage(request.getAttribute("message").toString());
                return dataGridResult;
            }

        }catch (Exception e) {
            log.error("查询原材料库存列表失败=:", e);
            dataGridResult.setSuccess(Boolean.FALSE);
            dataGridResult.setMessage("查询原材料库存列表异常");
            return  dataGridResult;
        }

    }

    @RequestMapping(value = "/materialstocks/selectdetail.do", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public List<TMaterialCost> SelectMaterialStocksDetailList(HttpServletRequest request, HttpServletResponse response ,
                                                @RequestParam(value = "stockid")Integer stockid ,
                                                @RequestParam(value = "startime")String startime , @RequestParam(value = "endtime")String endtime){
        try {
            Assert.hasText(String.valueOf(stockid), "stockid  is null or 空字符串。");
            log.info("SelectMaterialStocksDetailList request Param:stockid {},startime {},endtime {}", new String[]{stockid.toString(),startime, endtime});
            Boolean flag = super.execute(request, response);
            if (flag) {
                if (startime.equals("")) {
                    startime = null;
                }
                if (endtime.equals("")) {
                    endtime = null;
                }
                List<TMaterialCost> list = materialCostService.selectitems(stockid, startime, endtime);
                log.info("SelectMaterialStocksDetailList response Param:{}", list.toString());
                return list==null?null:list;
            }
        }catch (Exception e) {
            log.error("查询原材料收支列表失败=:", e);
            return  null;
        }
        return  null;
    }


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

    @Override
    public String getAuthorityId() {
        return AuthorityKey.MATERIALSTOCK_SELECT;
    }
}
