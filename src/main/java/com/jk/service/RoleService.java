/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: RoleService
 * Author:   zlh
 * Date:     2018/4/29 21:39
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.service;

import com.jk.model.Role;
import com.jk.model.Tree;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author zlh
 * @create 2018/4/29
 * @since 1.0.0
 */

public interface RoleService {

    List<Role> selectRoleList();

    List<Role> queryRoleByUserId(Integer userId);

    void updateUserRole(Integer userId, Integer roleId);

    void addFile(String fileUrl);

    List queryCountRole();

    List<Tree> queryCountTree();
}