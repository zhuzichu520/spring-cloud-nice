package com.zhuzichu.shared.response

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import java.io.Serializable

@ApiModel
data class Result<T>(
    @ApiModelProperty(value = "业务是否处理成功")
    val success: Boolean,
    @ApiModelProperty(value = "错误码")
    val code: Int,
    @ApiModelProperty(value = "错误信息")
    val message: String,
    @ApiModelProperty(value = "数据结果集")
    val data: T? = null,
    @ApiModelProperty(value = "时间戳")
    val timestamp: Long = System.currentTimeMillis(),
) : Serializable {
    companion object {

        fun <T> success(data: T? = null, code: Int? = null, message: String? = null): Result<T> {
            return Result(true, code ?: ResultCode.RC200.code, message ?: ResultCode.RC200.message, data)
        }

        fun <T> failure(code: Int? = null, message: String? = null, data: T? = null): Result<T> {
            return Result(false, code ?: ResultCode.RC999.code, message ?: ResultCode.RC999.message, data)
        }

    }
}
