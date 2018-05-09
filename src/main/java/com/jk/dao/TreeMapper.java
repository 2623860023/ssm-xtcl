/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: TreeMapper
 * Author:   zlh
 * Date:     2018/4/29 21:17
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.dao;

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
public interface TreeMapper {

    List<Tree> selectTreeList();

    List<Tree> queryTreeByUserId(Integer roleId);

    void deleteTree(Integer roleId);

    void saveRoleTree(@Param("id") Integer id, @Param("roleId") Integer roleId);
}