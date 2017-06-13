package com.ghprint.cms.services.impl;

import com.ghprint.cms.model.order.OrderParams;
import com.ghprint.cms.model.order.TOrderParams;
import com.ghprint.cms.model.order.TOrderParamsExample;
import com.ghprint.cms.model.stock.TMaterialStock;
import com.ghprint.cms.model.stock.TProductionStock;
import com.ghprint.cms.pagination.DataGridResult;
import com.ghprint.cms.serviceDao.TOrderParamsMapper;
import com.ghprint.cms.services.MaterialStockService;
import com.ghprint.cms.services.OrderParamsService;
import com.ghprint.cms.services.ProStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lipeiting on 2017/6/13.
 */
@Service
public class OrderParamsServiceImpl implements OrderParamsService {

    @Autowired
    private TOrderParamsMapper orderParamsMapper;
    @Autowired
    private MaterialStockService materialStockService;
    @Autowired
    private ProStockService proStockService;

    @Override
    public Integer addOrderParams(TOrderParams orderParams) {
        if(orderParams.getMaterialid()!= null){
            TMaterialStock materialStock = materialStockService.getMaterialStockById(orderParams.getMaterialid());
            orderParams.setMaterialsum(materialStock.getMaterialsum());
        }
        if(orderParams.getProductid()!=null){
            TProductionStock productionStock = proStockService.getProStockbyId(orderParams.getProductid());
            orderParams.setStocksum(productionStock.getStocksum());
        }
        Integer record = orderParamsMapper.insertSelective(orderParams);
        return record;
    }

    @Override
    public Integer delOrderParams(Integer opid) {
        Integer record =  orderParamsMapper.deleteByPrimaryKey(opid);
        return record;
    }

    @Override
    public Integer updateOrderParams(TOrderParams orderParams) {
        Integer record = orderParamsMapper.updateByPrimaryKey(orderParams);
        return record;
    }

    @Override
    public DataGridResult selectOrderParamsList(String key, String value, Integer page, Integer rows) {
        Integer pageOffset = (page-1)*rows;
        List<TOrderParams> list = orderParamsMapper.selectlist(pageOffset,rows,key,value);
        DataGridResult dataGridResult = new DataGridResult();
        if(list!=null) {
            dataGridResult.setRows(list);
            Integer sum = orderParamsMapper.getlistcount(key,value);
            dataGridResult.setTotalCount(sum);
            dataGridResult.setCurrentPage(page);
            dataGridResult.setEveryPage(rows);
            dataGridResult.setTotalPage((sum-1)/rows+1);
        }
        return dataGridResult;
    }

    @Override
    public OrderParams getOrderParamsById(Integer opid) {
        OrderParams orderParams = orderParamsMapper.getOneitem(opid);
        return orderParams;
    }

    @Override
    public List<TOrderParams> selectAllist() {
        TOrderParamsExample example = new TOrderParamsExample();
        List<TOrderParams> orderParamses =  orderParamsMapper.selectByExample(example);
        return orderParamses;
    }


}
