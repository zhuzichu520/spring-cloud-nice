package com.zhuzichu.shared.entity.system.dto

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "管理员登录返回数据")
data class LoginDto(
    @Schema(description = "用户名")
    val username:String,
    @Schema(description = "密钥")
    val token:String
)