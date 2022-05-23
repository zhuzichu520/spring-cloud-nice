package com.zhuzichu.shared.entity.system.po

import com.baomidou.mybatisplus.annotation.TableName
import com.zhuzichu.shared.entity.system.dto.AddAdminDto
import com.zhuzichu.shared.entity.system.dto.LoginDto

@TableName("sys_admin")
data class Admin(
     val id: Long?,
     val username:String,
     val password:String
){
    fun loginDto(token:String):LoginDto{
        return LoginDto(
             username,
             token
        )
    }
    fun addAdminDto():AddAdminDto{
        return AddAdminDto(
            id,
            username
        )
    }
}
