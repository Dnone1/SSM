package com.java.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java.ssm.mapper.UserMapper;
import com.java.ssm.pojo.User;
import com.java.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper ;

    @Override
    public List<User> getList() {
        return userMapper.getList();
    }

    @Override
    public User getUser(String username, String password) {
        return userMapper.getUser(username, password);
    }

    @Override
    public Integer insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public PageInfo<User> getUserPage(Integer pageNumber) {
        //开启分页功能
        PageHelper.startPage(pageNumber , 5) ;
        //查询所有员工信息
        List<User> list = userMapper.getList();
        //获取分页相关数据
        PageInfo<User> pageInfo = new PageInfo<>(list , 5);
        return pageInfo;
    }

    @Override
    public Integer delete(Integer id) {
        return userMapper.delete(id);
    }

    @Override
    public User getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    @Override
    public Integer update(User user) {
        return userMapper.update(user);
    }


}
