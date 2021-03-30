package com.yangxi.boot.sample.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yangxi.boot.sample.dao.UserDAO;
import com.yangxi.boot.sample.domain.entity.UserDO;
import com.yangxi.boot.sample.mapper.UserMapper;
import org.springframework.stereotype.Repository;

/**
 * @author yangxi
 * @version 1.0
 */
@Repository
public class UserDAOImpl extends ServiceImpl<UserMapper, UserDO> implements UserDAO {

    @Override
    public UserDO findUserByPhone(String phone) {
        QueryWrapper<UserDO> queryWrapper = new QueryWrapper<UserDO>().eq("phone", phone);
        return baseMapper.selectOne(queryWrapper);
    }
}