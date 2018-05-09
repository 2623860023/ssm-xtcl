/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: RoleServiceImpl
 * Author:   zlh
 * Date:     2018/4/29 21:39
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.service.impl;

import com.jk.dao.RoleMapper;
import com.jk.model.Role;
import com.jk.model.Tree;
import com.jk.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.jws.WebService;
import java.util.List;


/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author zlh
 * @create 2018/4/29
 * @since 1.0.0
 */
@Service("roleService")

public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleMapper roleDao;

    public List<Role> selectRoleList() {
        return roleDao.selectRoleList();
    }

    public List<Role> queryRoleByUserId(Integer userId) {
        return roleDao.queryRoleByUserId(userId);
    }

    public void updateUserRole(Integer userId, Integer roleId) {
        roleDao.updateUserRole(userId,roleId);
    }

    public void addFile(String fileUrl) {
        roleDao.addFile(fileUrl);
    }

    public List queryCountRole() {
        return roleDao.queryCountRole();
    }

    public List<Tree> queryCountTree() {
        return roleDao.queryCountTree();
    }
}