package com.ghprint.cms.controller.biz.Carton;

import com.ghprint.cms.common.AuthorityKey;
import com.ghprint.cms.controller.BaseAction;
import com.ghprint.cms.pagination.DataGridResult;
import com.ghprint.cms.services.CartonStockService;
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
public class QueryCartonController extends BaseAction {

    private static Logger log = LoggerFactory.getLogger(QueryCartonController.class);

    @Autowired
    private CartonStockService cartonStockService;

    @RequestMapping(value = "/cartonstocks/selectstocks.do", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public DataGridResult getCartonStocksList(HttpServletRequest request, HttpServletResponse response ,
                                        @RequestParam(value = "key")String key , @RequestParam(value = "value")String value,
                                        @RequestParam(value = "page")Integer page , @RequestParam(value = "rows")Integer rows){
        DataGridResult dataGridResult = new DataGridResult();
        try {
            Assert.hasText(String.valueOf(page), "page  is null or 空字符串。");
            Assert.hasText(String.valueOf(rows), "rows  is null or 空字符串。");
            log.info("getCartonStocksList request Param:key {},value {},page {},rows {}", new String[]{key,value, String.valueOf(page), String.valueOf(rows)});
            Boolean flag = super.execute(request, response);
            if (flag) {
                if(key.equals("")){key=null;}
                if(value.equals("")){value=null;}
                dataGridResult =  cartonStockService.selectCartonStocks( key ,value, page ,rows);
                if(dataGridResult!=null) {
                    dataGridResult.setSuccess(Boolean.TRUE);
                }else{
                    dataGridResult.setSuccess(Boolean.FALSE);
                }
                log.info("getCartonStocksList response Param:{}", dataGridResult.toString());
                return dataGridResult;
            } else {
                dataGridResult.setSuccess(Boolean.FALSE);
                dataGridResult.setMessage(request.getAttribute("message").toString());
                return dataGridResult;
            }

        }catch (Exception e) {
            log.error("查询纸箱库存列表失败=:", e);
            dataGridResult.setSuccess(Boolean.FALSE);
            dataGridResult.setMessage("查询纸箱库存列表异常");
            return  dataGridResult;
        }

    }

    @Override
    public String getAuthorityId() {
        return AuthorityKey.CARTONSTOCKS_SELECT;
    }
}
