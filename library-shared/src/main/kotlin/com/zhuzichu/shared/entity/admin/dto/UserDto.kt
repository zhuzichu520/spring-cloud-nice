package com.zhuzichu.shared.entity.admin.dto

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "用户数据")
data class UserDto(
    @Schema(description = "用户名")
    val username:String,
    @Schema(description = "密钥")
    val token:String
)