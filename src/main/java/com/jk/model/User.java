/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: User
 * Author:   zlh
 * Date:     2018/4/27 14:31
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.model;


import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author zlh
 * @create 2018/4/27
 * @since 1.0.0
 */
public class User implements Serializable{
    private static final long serialVersionUID = 627318954985616524L;
    private Integer id;

    private String name;

    private Integer age;

    private String birthday;

    private String loginname;

    private String pwd;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getLoginname() {
        return loginname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birthday='" + birthday + '\'' +
                ", loginname='" + loginname + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}