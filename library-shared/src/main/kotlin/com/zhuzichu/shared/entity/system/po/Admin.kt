package com.zhuzichu.shared.entity.system.po

import com.baomidou.mybatisplus.annotation.TableName
import com.zhuzichu.shared.entity.system.dto.GetAdmin
import com.zhuzichu.shared.entity.system.dto.SaveAdmin
import com.zhuzichu.shared.entity.system.dto.Login

@TableName("sys_admin")
data class Admin(
     val id: Long?,
     val username:String,
     val password:String
){
    fun toLoginResult(token:String):Login{
        return Login(
             username,
             token
        )
    }
    fun toSaveAdminResult():SaveAdmin{
        return SaveAdmin(
            id,
            username
        )
    }
    fun toGetAdminResult():GetAdmin{
        return GetAdmin(
            id,
            username
        )
    }
}
