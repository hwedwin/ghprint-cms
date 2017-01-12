package com.ghprint.cms.services;

import cn.com.bestpay.Response;
import com.ghprint.cms.common.util.ExceptionConstant;
import com.ghprint.cms.model.sys.TSysRole;

import java.util.Date;
import java.util.List;

import com.ghprint.cms.model.sys.TSysRoleExample;
import com.ghprint.cms.model.sys.TSysRolePrivilege;
import com.ghprint.cms.pagination.DataGridResult;
import com.ghprint.cms.serviceDao.TSysRoleMapper;
import com.ghprint.cms.serviceDao.TSysRolePrivilegeMapper;
import com.ghprint.cms.utils.Constant;
import com.ghprint.cms.utils.SplicingCharacterUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
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

    @Autowired
    private TSysRolePrivilegeMapper rolePrivilegeMapper;

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

    @Override
    public Response<String> addRoleInfo(TSysRole role,String ids[]) {
        Response<String> response = new Response<>();

        try {

            TSysRoleExample roleExample = new TSysRoleExample();
            TSysRoleExample.Criteria criteria = roleExample.createCriteria();
            criteria.andRolenameEqualTo(role.getRolename());

            List rolename = roleMapper.selectByExample(roleExample);
            if (rolename != null && rolename.size() > 0) {
                response.setErrorMsg(ExceptionConstant.SAME_ROLE_NAME);
                return response;
            }
            role.setCreatetime(new Date());
            role.setRoleid(SplicingCharacterUtil.getFourRandom());
            roleMapper.insert(role);
            TSysRolePrivilege rolePrivilege = new TSysRolePrivilege();
            rolePrivilege.setRoleid(role.getRoleid());
            for (int i = 0; i < ids.length; i++) {
                rolePrivilege.setPrivilegeid(ids[i]);
                rolePrivilegeMapper.insert(rolePrivilege);
            }
            response.setErrorCode(Constant.errorCodeEnum.SUCCESS.getCode());
            response.setErrorMsg(Constant.errorCodeEnum.SUCCESS.getName());
            return response;
        } catch (Exception ex) {
            response.setErrorCode(Constant.errorCodeEnum.FAILURE.getCode());
            response.setErrorMsg(ex.toString());
            return response;
        }
    }
}
