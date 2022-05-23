package com.zhuzichu.shared.interceptor

import com.zhuzichu.shared.response.BizException
import com.zhuzichu.shared.response.ResultCode
import com.zhuzichu.shared.utils.BusinessUtil
import org.springframework.web.method.HandlerMethod
import org.springframework.web.servlet.AsyncHandlerInterceptor
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


class AuthInterceptor : AsyncHandlerInterceptor {

    override fun preHandle(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any,
    ): Boolean {
        if (handler is HandlerMethod && handler.method.isAnnotationPresent(CheckToken::class.java)) {
            val token = request.getHeader("token")?:throw BizException(ResultCode.RC802)
            if(!BusinessUtil.verifyToken(token)){
                throw BizException(ResultCode.RC802)
            }
            BusinessUtil.getTokenPayload(token).toRequest(request)
        }
        return true
    }

}