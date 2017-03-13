package com.ghprint.cms.controller.biz.ProductionStandard;

import cn.com.bestpay.Response;
import com.ghprint.cms.common.AuthorityKey;
import com.ghprint.cms.controller.BaseAction;
import com.ghprint.cms.model.production.ProductionInit;
import com.ghprint.cms.model.sys.DictItemVO;
import com.ghprint.cms.services.DictUnVersalService;
import com.ghprint.cms.services.ProductionInfoService;
import com.ghprint.cms.utils.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Administrator on 2017/3/13.
 */
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class AddProductStandController extends BaseAction{

    private static Logger log = LoggerFactory.getLogger(AddProductStandController.class);
    @Autowired
    private ProductionInfoService productionInfoService;
    @Autowired
    private DictUnVersalService dictUnVersalService;


    @RequestMapping(value = "/product/addpreproduct.do", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public Response<ProductionInit>   addpreproduct(HttpServletRequest request, HttpServletResponse response){
        Response <ProductionInit> responses = new Response<>();
        try {
            Boolean flag = super.execute(request, response);
            if (flag) {
                List<DictItemVO> packaging= dictUnVersalService.findDictItems("packaging");
                List <DictItemVO> printingmode = dictUnVersalService.findDictItems("printingmode");
                ProductionInit productionInit = new ProductionInit(packaging,printingmode);

                responses.setErrorCode(Constant.errorCodeEnum.SUCCESS.getCode());
                responses.setErrorMsg(Constant.errorCodeEnum.SUCCESS.getName());
                responses.setResult(productionInit);
                return  responses;
            } else {
                responses.setErrorCode(Constant.errorCodeEnum.LOGIN_TIMEOUT_ERROE.getCode());
                responses.setErrorMsg(request.getAttribute("message").toString());
                return responses;
            }
        }catch (Exception e) {
            log.error("添加生产标准初始化失败=:", e);
            responses.setErrorCode(Constant.errorCodeEnum.FAILURE.getCode());
            responses.setErrorMsg("添加生产标准初始化异常");
            return  responses;
        }

    }








    @Override
    public String getAuthorityId() {
        return AuthorityKey.PRODUCTION_ADD;
    }
}
