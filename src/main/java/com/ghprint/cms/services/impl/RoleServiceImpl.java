package com.ghprint.cms.services.impl;

import cn.com.bestpay.Response;
import com.ghprint.cms.common.util.ExceptionConstant;
import com.ghprint.cms.framework.exception.BusinessException;
import com.ghprint.cms.model.sys.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ghprint.cms.pagination.DataGridResult;
import com.ghprint.cms.serviceDao.TSysPrivilegeMapper;
import com.ghprint.cms.serviceDao.TSysRoleMapper;
import com.ghprint.cms.serviceDao.TSysRolePrivilegeMapper;
import com.ghprint.cms.serviceDao.TSysUserRoleMapper;
import com.ghprint.cms.services.RoleService;
import com.ghprint.cms.utils.Constant;
import com.ghprint.cms.utils.ResultView;
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
public class RoleServiceImpl implements RoleService {

    private static Logger logger = LoggerFactory.getLogger(RoleService.class);

    @Autowired
    private TSysRoleMapper roleMapper;

    @Autowired
    private TSysRolePrivilegeMapper rolePrivilegeMapper;

    @Autowired
    private TSysUserRoleMapper userRoleMapper;

    @Autowired
    private TSysPrivilegeMapper privilegeMapper;

    @Override
    public DataGridResult getRoleList(TSysRole tSysRole, Integer page, Integer rows) {

        TSysRoleExample roleExample = new TSysRoleExample();
//        TSysRoleExample.Criteria criteria= roleExample.createCriteria();
//        if(StringUtils.isNotBlank(tSysRole.getRoledesc())) {
//            criteria.andRoledescLike(tSysRole.getRoledesc());
//        }
//        if(StringUtils.isNotBlank(tSysRole.getRoleid())) {
//            criteria.andRoleidLike(tSysRole.getRoleid());
//        }
//        if(StringUtils.isNotBlank(tSysRole.getRolename())) {
//            criteria.andRolenameLike(tSysRole.getRolename());
//        }
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
    public Response<String> addRoleInfo(TSysRole role, String ids[]) {
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

    @Override
    public Response<String> deleteRoleInfo(Integer roleid) {
        Response<String> response = new Response<>();
        logger.info("enter into delRole of RoleImpl ");
        try {
            TSysRoleExample roleExample = new TSysRoleExample();
            TSysUserRoleExample userRoleExample = new TSysUserRoleExample();
            TSysRolePrivilegeExample rolePrivilegeExample = new TSysRolePrivilegeExample();
            TSysUserRoleExample.Criteria criteria = userRoleExample.createCriteria();
            TSysRolePrivilegeExample.Criteria rolepricriteria = rolePrivilegeExample.createCriteria();
            TSysRoleExample.Criteria rolecriteria = roleExample.createCriteria();
            rolecriteria.andIdEqualTo(roleid);
            criteria.andRoleidEqualTo(String.valueOf(roleid));
            rolepricriteria.andRoleidEqualTo(String.valueOf(roleid));

            List list = userRoleMapper.selectByExample(userRoleExample);
            if ((list != null) && (list.size() > 0)) {
                logger.info("该角色已经被使用，不能删除");
                response.setErrorCode(Constant.errorCodeEnum.FAILURE.getCode());
                response.setErrorMsg("该角色已经被使用，不能删除");
                return response;
            }
            List<TSysRole> lists = roleMapper.selectByExample(roleExample);
            int res = 0;
            if ((lists != null) && (lists.size() > 0)) {
                for (TSysRole role : lists) {
                    rolePrivilegeExample.clear();
                    rolepricriteria = rolePrivilegeExample.createCriteria();
                    rolepricriteria.andRoleidEqualTo(role.getRoleid());
                    res = rolePrivilegeMapper.deleteByExample(rolePrivilegeExample);
                }
            }
            logger.info("delete role_privilege succ!!");

            // delete the instance
            int result = roleMapper.deleteByExample(roleExample);
            if (result > 0 && res > 0) {
                response.setErrorCode(Constant.errorCodeEnum.SUCCESS.getCode());
                response.setErrorMsg("删除角色成功");
            }
        } catch (Exception ex) {
            logger.error("delRole exception.");
            throw new BusinessException(Constant.errorCodeEnum.FAILURE.getCode(), ex.getMessage());
        }
        logger.info(" leave delRole of RoleImpl");
        return response;
    }

    @Override
    public List queryPrivilege() {
        logger.info("enter into queryPrivilege of RoleImpl ");
        List listnodes = new ArrayList();
        try {
            TSysPrivilegeExample privilegeExample = new TSysPrivilegeExample();
            List<TSysPrivilege> list1 = privilegeMapper.selectByExample(privilegeExample);
            if (list1 != null && list1.size() > 0) {

                GradePrivilegeView gradeview = new GradePrivilegeView();
                List listnode = new ArrayList();
                for (int i = 0; i < list1.size(); i++) {
                    ListNode node = new ListNode();
                    node.setKey(list1.get(i).getPrivilegeid());
                    node.setValue(list1.get(i).getPrivilegename());
                    listnode.add(node);
                }
                gradeview.setPrivilegeList(listnode);
               listnodes.add(gradeview);
            }
        } catch (Exception ex) {
            logger.error("queryPrivilegeList exception.");
            ex.printStackTrace();
        }
        logger.info(" left queryPrivilege of RoleImpl");
        return listnodes;
    }

    @Override
    public RoleInfoView queryRole(Integer roleid) {
        logger.info("enter into queryRole of RoleImpl ");
        RoleInfoView roleview = null;
        try {

            TSysRole roleinfo = roleMapper.selectByPrimaryKey(roleid);
            if (roleinfo == null) {
                logger.info("没有符合条件的记录");
            } else {
                roleview = new RoleInfoView();
                roleview.setRoleId(Integer.parseInt(roleinfo.getRoleid()));
                roleview.setRoleName(roleinfo.getRolename());
                roleview.setDescription(roleinfo.getRoledesc());
                roleview.setGrade(roleinfo.getGrade());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                roleview.setCreatTime(sdf.format(roleinfo.getCreatetime()));
                roleview.setRoleStatus(Integer.parseInt(roleinfo.getRolestatus()));
                roleview.setPrivilegeInfoList(this.getPrivilege(roleinfo
                        .getRoleid()));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        logger.info(" left queryRole of RoleImpl");
        return roleview;
    }

    @Override
    public List queryPrivilege(Integer roleid) {
        logger.info("enter into queryPrivilege of RoleImpl ");
        if (roleid <= 0) {
            logger.error(" roleid: parameter is null");
        }
        List privilegeList = null;
        try {
            List privilege = privilegeMapper.getPrivilege(roleid);
            if (privilege != null) {
                privilegeList = new ArrayList();
                int size = privilege.size();
                for (int i = 0; i < size; i++) {
                    ListNode node = new ListNode();
                    node.setKey(String.valueOf(((TSysPrivilege) privilege.get(i))
                            .getPrivilegeid()));
                    node.setValue(((TSysPrivilege) privilege.get(i))
                            .getPrivilegename());
                    privilegeList.add(node);
                }
            }
            return privilegeList;
        } catch (Exception e) {
            e.printStackTrace();
            return  null;
        }
    }

    @Override
    public int updateRoleStatus(Integer roleid, String status) {
        logger.info("enter into updateRoleStatus of RoleImpl ");
        int resultFlag = 1001;
        try {
            TSysRole roleinfo = roleMapper.selectByPrimaryKey(roleid);
            roleinfo.setRolestatus(status);
            int result=roleMapper.updateByPrimaryKey(roleinfo);
            if(result >0){
                resultFlag =1000;
            }
        } catch (Exception e) {
            logger.error("Exception is : ", e);
        }
        return resultFlag;
    }

    @Override
    public boolean queryRoleUserd(Integer roleid) {
        logger.info("enter into queryRoleUserd of RoleServiceBean ");
        boolean resultFlag = false;
        int count = 0;
        try {
            TSysUserRoleExample userRoleExample = new TSysUserRoleExample();
            TSysUserRoleExample.Criteria criteria = userRoleExample.createCriteria();
            criteria.andRoleidEqualTo(String.valueOf(roleid));
            count = userRoleMapper.countByExample(userRoleExample);
            if(count>0){
                resultFlag = true;
            }
        } catch (Exception e) {
            logger.error("Exception is : ", e);
        }
        return resultFlag;
    }

    @Override
    public Response<String> editRole(TSysRole tSysRole, String ids[]) {
        logger.info("Enter editRole mothod");
       Response <String> response = new Response<>();
        int sss = 0;
        try {
            TSysRole po = roleMapper.selectByPrimaryKey(tSysRole.getId());
            if (po == null) {
                response.setErrorCode(Constant.errorCodeEnum.FAILURE.getCode());
                response.setErrorMsg("要更新的记录不存在getSpseqId = "+tSysRole.getId());
                return  response;
            } else {
                po.setRolename(tSysRole.getRolename());
                po.setRoledesc(tSysRole.getRoledesc());
                po.setEdittime(new Date());
                po.setRolestatus(tSysRole.getRolestatus());
                int result=roleMapper.updateByPrimaryKey(po);
                if(result <= 0){
                    response.setErrorCode(Constant.errorCodeEnum.FAILURE.getCode());
                    response.setErrorMsg("更新失败");
                    return  response;
                }
                // 先删除已有的权限
                logger.info("delete role_privilege ");
                String roleid = po.getRoleid();
                logger.info("delete role_privilege succ!!");
                TSysRolePrivilegeExample example = new TSysRolePrivilegeExample();
                TSysRolePrivilegeExample.Criteria criteria = example.createCriteria();
                criteria.andRoleidEqualTo(roleid);
                rolePrivilegeMapper.deleteByExample(example);

                logger.info("add role_privilege ");

                if (ids.length > 0) {
                    int size = ids.length;
                    if (size > 0) {
                        for (int i = 0; i < size; i++) {
                            TSysRolePrivilege rolePrivilege = new TSysRolePrivilege();
                            rolePrivilege.setRoleid(roleid);
                            rolePrivilege.setPrivilegeid(ids[i]);
                            sss =rolePrivilegeMapper.insert(rolePrivilege);
                        }
                        logger.info("add role_privilege succ");
                    }
                }
            }
            if(sss > 0){
                response.setErrorCode(Constant.errorCodeEnum.SUCCESS.getCode());
                response.setErrorMsg(Constant.errorCodeEnum.SUCCESS.getName());
                return response;
            }
        } catch (Exception ex) {
            logger.error("editRole exception.");
        }
        return response;
    }

    public List getPrivilege(String roleid) {
        try {
            List privilegeList = null;
            @SuppressWarnings("rawtypes")
            List <RolePrivilegeInfo>list = rolePrivilegeMapper.queryRoleList(roleid);

                if (list != null) {
                    privilegeList = new ArrayList();
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        ListNode node = new ListNode();
                        node.setKey(list.get(i).getPrivilegeInfo().getPrivilegeid());
                        node.setValue(list.get(i).getPrivilegeInfo().getPrivilegename());
                        privilegeList.add(node);
                    }
                }
            return privilegeList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }



}
