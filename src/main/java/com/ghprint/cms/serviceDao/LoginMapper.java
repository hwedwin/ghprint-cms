package com.ghprint.cms.serviceDao;

import java.util.List;

/**
 * Created by lenovo on 2017/1/8.
 */
public interface LoginMapper {


    /**
     * 根据operatorid获取人员信息及权限
     *
     * @param operatorid
     * @return
     * @throws ParameterException
     * @throws DAOException
     */
    List queryOperatroInfo(String operatorid);


}
