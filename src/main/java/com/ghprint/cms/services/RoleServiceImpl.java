package com.ghprint.cms.services;

import com.ghprint.cms.model.sys.TSysRole;

import java.util.List;

import com.ghprint.cms.model.sys.TSysRoleExample;
import com.ghprint.cms.pagination.DataGridResult;
import com.ghprint.cms.serviceDao.TSysRoleMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lenovo on 2017/1/10.
 */
@Service
public class RoleServiceImpl implements  RoleService {

    private  static Logger logger = LoggerFactory.getLogger(RoleService.class);

    @Autowired
    private TSysRoleMapper roleMapper;

    @Override
    public DataGridResult getRoleList(TSysRole tSysRole, Integer page, Integer rows) {

        TSysRoleExample roleExample = new TSysRoleExample();
        PageHelper.startPage(page, rows);
        List<TSysRole> rolelist = roleMapper.selectByExample(roleExample);
        DataGridResult dataGridResult = new DataGridResult();
        dataGridResult.setRows(rolelist);
        //取记录总条数
        PageInfo<TSysRole> pageInfo = new PageInfo<>(rolelist);

        dataGridResult.setCurrentPage(page);
        dataGridResult.setEveryPage(rows);
        dataGridResult.setTotalCount(pageInfo.getTotal());
        dataGridResult.setTotalPage(pageInfo.getPages());
        return dataGridResult;
    }
}
