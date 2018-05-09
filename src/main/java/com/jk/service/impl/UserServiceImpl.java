/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: UserServiceImpl
 * Author:   zlh
 * Date:     2018/4/27 14:30
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.service.impl;

import com.jk.dao.UserMapper;
import com.jk.model.User;
import com.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author zlh
 * @create 2018/4/27
 * @since 1.0.0
 */
@Service("userService")
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userDao;
    public List<User> selectUser(){
        List<User> list=userDao.selectUser();
        return list;
    }

}