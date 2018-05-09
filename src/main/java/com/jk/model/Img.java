/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: Img
 * Author:   zlh
 * Date:     2018/4/30 0:52
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
 * @create 2018/4/30
 * @since 1.0.0
 */
public class Img implements Serializable{
    private static final long serialVersionUID = -2920092882629354022L;
    private Integer id;
    private String url;
    @Override
    public String toString() {
        return "Img{" +
                "id=" + id +
                ", url='" + url + '\'' +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }
}