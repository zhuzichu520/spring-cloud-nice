package com.zhuzichu.system.service

import cn.hutool.crypto.SecureUtil
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.zhuzichu.system.dao.AdminMapper
import com.zhuzichu.shared.entity.admin.po.Admin
import com.zhuzichu.shared.response.BizException
import com.zhuzichu.shared.response.ResultCode
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AdminService {

    @Autowired
    private lateinit var userMapper: AdminMapper

    fun login(username: String, password: String): Admin {
        val user = userMapper.selectOne(QueryWrapper<Admin>().eq("username", username))
            ?: throw BizException(ResultCode.RC800)
        if (user.password != SecureUtil.md5(password)) {
            throw BizException(ResultCode.RC801)
        }
        return user
    }

}