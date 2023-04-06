package com.java.ssm.mapper;

import com.java.ssm.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    /*
    查询所有
     */
    List<User> getList() ;

    /*
    登陆
     */
    User getUser(@Param("username") String username , @Param("password") String password) ;

    /*
    注册
     */
    Integer insert(User user) ;

    /*
    删除
     */

    Integer delete(@Param("id") Integer id) ;

    /*
    根据id查询用户
     */
    User getUserById(@Param("id") Integer id) ;

    /*
    修改
     */
    Integer update(User user) ;
}
