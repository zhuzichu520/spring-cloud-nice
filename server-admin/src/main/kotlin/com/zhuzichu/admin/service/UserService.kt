package com.zhuzichu.admin.service

import cn.hutool.crypto.SecureUtil
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.zhuzichu.admin.dao.UserMapper
import com.zhuzichu.shared.entity.admin.po.User
import com.zhuzichu.shared.response.BizException
import com.zhuzichu.shared.response.ResultCode
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {

    @Autowired
    private lateinit var userMapper: UserMapper

    fun login(username: String, password: String): User {
        val user = userMapper.selectOne(QueryWrapper<User>().eq("username", username))
            ?: throw BizException(ResultCode.RC800)
        if (user.password != SecureUtil.md5(password)) {
            throw BizException(ResultCode.RC801)
        }
        return user
    }

}