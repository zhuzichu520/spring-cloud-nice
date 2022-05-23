package com.zhuzichu.shared.entity.system.param

import io.swagger.annotations.ApiModelProperty
import javax.validation.constraints.Size

data class AddAdminParam (
    @ApiModelProperty(value = "用户名", required = true)
    @field:Size(min = 2, max = 5, message = "用户名长度：3至16")
    val username: String,

    @ApiModelProperty(value = "密码", required = true)
    @field:Size(min = 2, max = 5, message = "密码长度：3至16")
    val password: String,
): BaseParam
