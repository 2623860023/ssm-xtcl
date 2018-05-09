/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: Tree
 * Author:   zlh
 * Date:     2018/4/29 21:09
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
public class Tree implements Serializable{
    private static final long serialVersionUID = -5904752379550068189L;
    private Integer id;
    private String text;
    private Integer pid;
    private String url;
    private boolean checked;
    private Integer count;

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getCount() {
        return count;
    }

    public Integer getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public Integer getPid() {
        return pid;
    }

    public String getUrl() {
        return url;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", pid=" + pid +
                ", url='" + url + '\'' +
                ", checked=" + checked +
                ", count=" + count +
                '}';
    }
}