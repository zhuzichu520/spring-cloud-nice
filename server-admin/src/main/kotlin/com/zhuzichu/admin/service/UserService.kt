package com.zhuzichu.admin.service

import cn.hutool.crypto.SecureUtil
import cn.hutool.log.LogFactory
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.zhuzichu.admin.dao.UserMapper
import com.zhuzichu.shared.entity.admin.po.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {

    @Autowired
    private lateinit var userMapper: UserMapper

    fun login(username: String, password: String): User {
        val user = userMapper.selectOne(QueryWrapper<User>().eq("username", username))
            ?: throw IllegalAccessException("用户名不存在")
        if (user.password != SecureUtil.md5(password)) {
            LogFactory.get().info("SecureUtil.md5(password):${SecureUtil.md5(password)}")
            LogFactory.get().info("user.password:${user.password}")
            throw IllegalAccessException("密码错误")
        }
        return user
    }

}