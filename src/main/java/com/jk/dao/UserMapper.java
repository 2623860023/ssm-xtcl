/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: UserMapper
 * Author:   zlh
 * Date:     2018/4/27 14:50
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.dao;

import com.jk.model.User;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author zlh
 * @create 2018/4/27
 * @since 1.0.0
 */
public interface UserMapper {

    List<User> selectUser();
}