package com.zhuzichu.shared.response

import cn.hutool.core.exceptions.ExceptionUtil
import com.zhuzichu.shared.ext.loge
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(value = [BizException::class])
    @ResponseBody
    fun bizExceptionHandler( e: BizException): Result<String> {
        loge("业务异常->${e.result.code}:${e.result.message}")
        return Result.failure(e.result.code,e.result.message)
    }

    @ExceptionHandler(value = [Exception::class])
    @ResponseBody
    fun exceptionHandler(e: Exception): Result<String> {
        loge(ExceptionUtil.getMessage(e))
        return Result.failure(ResultCode.RC500.code,ResultCode.RC500.message)
    }

}