/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: Ro
 * Author:   zlh
 * Date:     2018/4/30 22:42
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.model;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author zlh
 * @create 2018/4/30
 * @since 1.0.0
 */
public class Ro {
    private String name;
    private Integer y;

    @Override
    public String toString() {
        return "Ro{" +
                "name='" + name + '\'' +
                ", y=" + y +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public Integer getY() {
        return y;
    }
}