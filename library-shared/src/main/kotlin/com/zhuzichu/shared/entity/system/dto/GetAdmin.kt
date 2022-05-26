package com.zhuzichu.shared.entity.system.dto

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "获取用户信息返回数据")
data class GetAdmin(
    @Schema(description = "用户id")
    val id:Long?,
    @Schema(description = "用户名")
    val username:String
)