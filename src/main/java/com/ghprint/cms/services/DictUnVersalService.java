package com.ghprint.cms.services;


import com.ghprint.cms.model.sys.DictItemVO;

import java.util.List;

public interface DictUnVersalService {
    /**
     * 根据ID查询数据字段项
     * @param headID int
     * @return List
     */
    public List<DictItemVO> findDictItems(String headID);

    /**
     * 查询数据字典名称
     * @param headID int
     * @param itemID int
     * @return String
     */
    public String getDicItemName(String headID, String itemID);


}
