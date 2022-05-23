package com.zhuzichu.system.service

import cn.hutool.core.util.IdUtil
import cn.hutool.crypto.SecureUtil
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.zhuzichu.shared.entity.system.param.AddAdminParam
import com.zhuzichu.shared.entity.system.param.LoginParam
import com.zhuzichu.system.dao.AdminMapper
import com.zhuzichu.shared.entity.system.po.Admin
import com.zhuzichu.shared.response.BizException
import com.zhuzichu.shared.response.ResultCode
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AdminService {

    @Autowired
    private lateinit var userMapper: AdminMapper

    fun login(param: LoginParam): Admin {
        val user = userMapper.selectOne(QueryWrapper<Admin>().eq("username", param.username))
            ?: throw BizException(ResultCode.RC800)
        if (user.password != SecureUtil.md5(param.password)) {
            throw BizException(ResultCode.RC801)
        }
        return user
    }

    fun addAdmin(param: AddAdminParam): Admin {
        var admin = userMapper.selectOne(QueryWrapper<Admin>().eq("username", param.username))
        if (admin != null) {
            throw BizException(ResultCode.RC803)
        }
        val id = IdUtil.getSnowflake().nextId()
        admin = Admin(id, param.username, SecureUtil.md5(param.password))
        userMapper.insert(admin)
        return admin
    }

}