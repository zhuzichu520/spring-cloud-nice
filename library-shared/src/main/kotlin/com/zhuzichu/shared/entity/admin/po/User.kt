package com.zhuzichu.shared.entity.admin.po

import com.baomidou.mybatisplus.annotation.TableName
import com.zhuzichu.shared.entity.admin.dto.UserDto

@TableName("admin_user")
data class User(
     val id: Long?,
     val username:String,
     val password:String
){
    fun toDto(token:String):UserDto{
        return UserDto(
             username,
             token
        )
    }
}
