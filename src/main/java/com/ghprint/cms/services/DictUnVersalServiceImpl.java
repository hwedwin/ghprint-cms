package com.ghprint.cms.services;

import com.ghprint.cms.common.util.CommonConstant;
import com.ghprint.cms.model.sys.DictItemVO;
import com.ghprint.cms.model.sys.TDictionaryInfo;
import com.ghprint.cms.model.sys.TDictionaryInfoExample;
import com.ghprint.cms.serviceDao.TDictionaryInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/28.
 */
@Service
public class DictUnVersalServiceImpl implements DictUnVersalService {

    @Autowired
    private TDictionaryInfoMapper dictionaryInfoMapper;

    @Override
    public List<DictItemVO> findDictItems(String headID) {
        String status = CommonConstant.STATUS_NORMAL;
        DictItemVO vo = null;
        List<DictItemVO> items = new ArrayList<DictItemVO>();
        TDictionaryInfoExample dictionaryInfoExample = new TDictionaryInfoExample();
        TDictionaryInfoExample.Criteria criteria = dictionaryInfoExample.createCriteria();
        criteria.andHeadidEqualTo(headID).andStatusEqualTo(status);
        List<TDictionaryInfo> values = dictionaryInfoMapper.selectByExample(dictionaryInfoExample);  //根据字典项ID，找该字典项的所有值
        if (values == null) {
            return null;
        }
        for (TDictionaryInfo item : values) {
            vo = new DictItemVO();
            vo.setItemName(item.getName());
            vo.setItemValue(item.getValue());
            items.add(vo);
        }
        return items;

    }

    @Override
    public String getDicItemName(String headID, String itemID) {
        TDictionaryInfoExample dictionaryInfoExample = new TDictionaryInfoExample();
        TDictionaryInfoExample.Criteria criteria = dictionaryInfoExample.createCriteria();
        criteria.andHeadidEqualTo(headID).andStatusEqualTo(itemID);
        TDictionaryInfo dicItem = (TDictionaryInfo) dictionaryInfoMapper.selectByExample(dictionaryInfoExample).get(0);
        if (dicItem != null) {
            return dicItem.getName();
        } else {
            return "";
        }
    }
}
