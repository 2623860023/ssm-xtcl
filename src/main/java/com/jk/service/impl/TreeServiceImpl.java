/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: TreeServiceImpl
 * Author:   zlh
 * Date:     2018/4/29 21:15
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.service.impl;

import com.jk.dao.TreeMapper;
import com.jk.model.Tree;
import com.jk.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author zlh
 * @create 2018/4/29
 * @since 1.0.0
 */
@Service("treeService")
    public class TreeServiceImpl implements TreeService{
    @Autowired
    private TreeMapper treeDao;
    /*@Cacheable(value = "redis",key="'selectTreeList'")*/
    public List<Tree> selectTreeList(){
        List<Tree> list=treeDao.selectTreeList();
        return list;
    }

    public List<Tree> queryTreeByUserId(Integer roleId) {
        return treeDao.queryTreeByUserId(roleId);
    }

    public void updateTreeRelation(String ids,Integer roleId) {
        //删除角色的权限
        treeDao.deleteTree(roleId);
        //再将ids存到关联表
        String [] id=ids.split(",");
        for (int i = 0; i < id.length; i++) {
            treeDao.saveRoleTree(Integer.valueOf(id[i]),roleId);
        }
    }
}