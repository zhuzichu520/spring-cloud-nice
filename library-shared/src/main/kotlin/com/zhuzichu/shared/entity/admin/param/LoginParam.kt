package com.zhuzichu.shared.entity.admin.param

import io.swagger.v3.oas.annotations.media.Schema
import javax.validation.constraints.Size

data class LoginParam (
    @field:Schema(description = "用户名", required = true)
    @field:Size(min = 2, max = 5, message = "用户名长度：3至16")
    val username: String,

    @field:Schema(description = "密码", required = true)
    @field:Size(min = 2, max = 5, message = "密码长度：3至16")
    val password: String,
): BaseParam
