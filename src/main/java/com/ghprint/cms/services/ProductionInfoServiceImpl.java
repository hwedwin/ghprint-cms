package com.ghprint.cms.services;

import com.ghprint.cms.model.production.ProductionInfoView;
import com.ghprint.cms.pagination.DataGridResult;
import com.ghprint.cms.serviceDao.ProductionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/3/1.
 */
@Service
public class ProductionInfoServiceImpl implements  ProductionInfoService {

    private static Logger logger = LoggerFactory.getLogger(ProductionInfoServiceImpl.class);

    @Autowired
    private ProductionMapper productionMapper;


    /*
    * 查询生产质量标准列表
    * */
    @Override
    public DataGridResult getProductionList(String key,String value, Integer page, Integer rows) {
        DataGridResult dataGridResult = new DataGridResult();
        Integer pageOffset = (page-1)*rows;
       List<ProductionInfoView> list =productionMapper.selectlist(pageOffset,rows,key,value);
        if(list != null ) {
            dataGridResult.setRows(list);
            Integer sum = productionMapper.getlistcount();
            dataGridResult.setTotalCount(sum);
            dataGridResult.setCurrentPage(page);
            dataGridResult.setEveryPage(rows);
            dataGridResult.setTotalPage(sum / rows);
        }
        return dataGridResult;
    }
}
