package com.zhuzichu.shared.response

class BizException(
    val result:ResultCode
) : RuntimeException()