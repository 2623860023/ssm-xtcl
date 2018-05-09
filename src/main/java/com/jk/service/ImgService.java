/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ImgService
 * Author:   zlh
 * Date:     2018/4/30 23:48
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.service;

import com.jk.model.Img;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author zlh
 * @create 2018/4/30
 * @since 1.0.0
 */
@WebService
public interface ImgService {
    @WebMethod
    List<Img> selectImgList();
}