/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: RoleMapper
 * Author:   zlh
 * Date:     2018/4/29 21:41
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.dao;

import com.jk.model.Img;
import com.jk.model.Role;
import com.jk.model.Tree;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author zlh
 * @create 2018/4/29
 * @since 1.0.0
 */
public interface RoleMapper {

    List<Role> selectRoleList();

    List<Role> queryRoleByUserId(Integer userId);

    void updateUserRole(@Param("userId") Integer userId, @Param("roleId") Integer roleId);

    void addFile(String fileUrl);

    List queryCountRole();

    List<Tree> queryCountTree();

    List<Img> selectImgList();
}