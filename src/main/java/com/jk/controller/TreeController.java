/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: TreeController
 * Author:   zlh
 * Date:     2018/4/29 21:14
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.controller;

import com.jk.model.Tree;
import com.jk.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author zlh
 * @create 2018/4/29
 * @since 1.0.0
 */
@Controller
@RequestMapping("treeController")
public class TreeController {
    @Autowired
    private TreeService treeService;
    /**
     * 查询所有树
     * @return
     */
    @RequestMapping("selectTreeList")
    @ResponseBody
    public List<Tree> selectTreeList(){
        List<Tree> list=treeService.selectTreeList();
        return list;
    }
    @RequestMapping("queryRoleTree")
    @ResponseBody
    public List<Tree> queryRoleTree(Integer roleId){
        //先查询所有的树
        List<Tree> listTree=treeService.selectTreeList();
        //查询当前用户的树
        List<Tree> list=treeService.queryTreeByUserId(roleId);
        //如果当前用户的权限有的,就返回一个true
        for (Tree ttree : listTree) {
            for (Tree ttree1: list) {
                if(ttree.getId()==ttree1.getId()){
                    ttree.setChecked(true);
                }
            }
        }
        return listTree;
    }
    @RequestMapping("updateTreeRelation")
    @ResponseBody
    public void updateTreeRelation(String ids,Integer roleId){
        treeService.updateTreeRelation(ids,roleId);
    }
}