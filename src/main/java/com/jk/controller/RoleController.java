/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: RoleController
 * Author:   zlh
 * Date:     2018/4/29 21:39
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.controller;

import com.jk.model.Ro;
import com.jk.model.Role;
import com.jk.model.Tree;
import com.jk.service.RoleService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author zlh
 * @create 2018/4/29
 * @since 1.0.0
 */
@Controller
@RequestMapping("roleController")
public class RoleController {
    @Autowired
    private RoleService roleService;

    /**
     * 获取所有角色
     * @return
     */
    @RequestMapping("selectRoleList")
    @ResponseBody
    public List<Role> selectRoleList(){
        List<Role> list=roleService.selectRoleList();
        Configuration configuration = new Configuration();
        try {
            configuration.setDirectoryForTemplateLoading(new  File("H:\\ideaworkspace\\src\\main\\webapp\\templates"));
            configuration.setDefaultEncoding("utf-8");
            Template template = null;
            template = configuration.getTemplate("role.ftl");
            Writer out= null;
            out = new FileWriter(new File("H:\\ideaworkspace\\src\\main\\webapp\\templates\\role.html"));
            Map root=new HashMap();
            root.put("list", list);
            try {
                template.process(root, out);
            } catch (TemplateException e) {
                e.printStackTrace();
            }
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 根据用户id获取角色
     * @param userId
     * @return
     */
    @RequestMapping("queryRoleByUserId")
    @ResponseBody
    public List<Role> queryRoleByUserId(Integer userId){
        List<Role> list=roleService.queryRoleByUserId(userId);
        return list;
    }

/*
    */
/**
     * 修改用户角色
     * @param userId
     * @return
     *//*

    @RequestMapping("updateUserRole")
    @ResponseBody
    public void updateUserRole(Integer userId, Integer roleId){
        roleService.updateUserRole(userId,roleId);
    }
    @RequestMapping(value="addOss", method = RequestMethod.POST, produces = "application/json;charset=utf8")
    @ResponseBody
    public void addOss(@RequestParam(value="fileName",required=false)MultipartFile file) throws FileNotFoundException {
        CommonsMultipartFile cf = (CommonsMultipartFile)file;
        //这个myfile是MultipartFile的
        DiskFileItem fi = (DiskFileItem) cf.getFileItem();
        File file1 = fi.getStoreLocation();
        FileInputStream fis=null;
        //通过UUID给前台传过来的文件名重命名
        String newFileName = UUID.randomUUID().toString();
        // endpoint以杭州为例，其它region请按实际情况填写
        String endpoint = "http://oss-cn-beijing.aliyuncs.com";
        // 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建
        String accessKeyId = "LTAIQ3SqH2L5XBm2";
        String accessKeySecret = "yMu4GeXWLJSC1hcUPQUDQYlb8a8jo9";
        // 创建OSSClient实例
        //OSSClient是OSS服务的Java客户端，它为调用者提供了一系列的方法，用于和OSS服务进行交互。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        fis = new FileInputStream(file1);
        ossClient.putObject("zlh142857", "img/"+newFileName, fis);
        Date expiration=new Date(System.currentTimeMillis()+ 3600 * 1000 * 24 * 3);
        URL url = ossClient.generatePresignedUrl("zlh142857", "img/"+newFileName, expiration);
        String fileUrl=url.toString();
        roleService.addFile(fileUrl);
        ossClient.shutdown();
    }
*/

    /**
     * 查询角色个数,highcharts
     * @return
     */
    @RequestMapping("queryCountRole")
    @ResponseBody
    public List queryCountRole(){
        List<Role> list=roleService.queryCountRole();
        List<Ro> list1=new ArrayList<Ro>();
        for (int i=0;i<list.size();i++){
            Ro ro=new Ro();
            ro.setName(list.get(i).getName());
            ro.setY(list.get(i).getCount());
            list1.add(ro);
        }
        System.out.print(list1);
        return list1;
    }
    @RequestMapping("queryCountTree")
    @ResponseBody
    public List queryCountTree(){
        List<Tree> list=roleService.queryCountTree();
        List<Ro> list1=new ArrayList<Ro>();
        for (int i=0;i<list.size();i++){
            Ro ro=new Ro();
            ro.setName(list.get(i).getText());
            ro.setY(list.get(i).getCount());
            list1.add(ro);
        }
        System.out.print(list1);
        return list1;
    }
    @RequestMapping("tohighcharts")
    public String tohighcharts(){
        return "highcharts";
    }
    @RequestMapping("tohighcharts2")
    public String tohighcharts2(){
        return "highcharts2";
    }
    @RequestMapping("touserrole")
    public String touserrole(){
        return "user_role";
    }
}