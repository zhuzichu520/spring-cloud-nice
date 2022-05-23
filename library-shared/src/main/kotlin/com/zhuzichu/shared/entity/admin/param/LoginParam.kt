package com.zhuzichu.shared.entity.admin.param

import io.swagger.v3.oas.annotations.Parameter

data class LoginParam(
    @Parameter(description = "用户名")
    val username: String,
    @Parameter(description = "密码")
    val password: String,
)
