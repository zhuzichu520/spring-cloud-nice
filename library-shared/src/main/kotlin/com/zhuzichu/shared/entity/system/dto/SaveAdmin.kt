package com.zhuzichu.shared.entity.system.dto

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "添加用户成功后返回数据")
data class SaveAdmin(
    @Schema(description = "用户id")
    val id:Long?,
    @Schema(description = "用户名")
    val username:String
)