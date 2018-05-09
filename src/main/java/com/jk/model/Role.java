/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: Role
 * Author:   zlh
 * Date:     2018/4/29 21:49
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
 * @create 2018/4/29
 * @since 1.0.0
 */
public class Role implements Serializable{
    private static final long serialVersionUID = -7789513084464208310L;
    private Integer id;
    private String name;
    private Integer count;

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}