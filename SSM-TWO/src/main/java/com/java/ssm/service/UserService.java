package com.java.ssm.service;

import com.github.pagehelper.PageInfo;
import com.java.ssm.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    /*
    查询所有
     */
    List<User> getList() ;

    /*
    登陆
     */
    User getUser(String username , String password) ;

    /*
    注册
     */
    Integer insert(User user) ;

    /*
    分页数据
     */
    PageInfo<User> getUserPage(Integer pageNumber);

    /*
    删除
     */
    Integer delete( Integer id) ;

    /*
    根据id查询用户
     */
    User getUserById(Integer id) ;

    /*
    修改
     */
    Integer update(User user) ;
}
