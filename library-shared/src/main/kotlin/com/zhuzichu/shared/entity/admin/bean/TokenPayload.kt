package com.zhuzichu.shared.entity.admin.bean

data class TokenPayload(
    val id:Long?,
    val username:String,
    val expireTime:Long
)