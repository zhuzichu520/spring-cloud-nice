package com.zhuzichu.shared.interceptor

import com.zhuzichu.shared.ext.logi
import com.zhuzichu.shared.response.BizException
import com.zhuzichu.shared.response.ResultCode
import com.zhuzichu.shared.utils.BusinessUtil
import org.springframework.web.method.HandlerMethod
import org.springframework.web.servlet.AsyncHandlerInterceptor
import org.springframework.web.servlet.ModelAndView
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


class AuthInterceptor : AsyncHandlerInterceptor {

    override fun preHandle(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any,
    ): Boolean {
        logi("---------------开始拦截请求---------------")
        if (handler is HandlerMethod && !handler.method.isAnnotationPresent(PassToken::class.java)) {
            val token = request.getHeader("token")?:throw BizException(ResultCode.RC401)
            if(!BusinessUtil.verifyToken(token)){
                throw BizException(ResultCode.RC401)
            }
            BusinessUtil.getTokenPayload(token).toRequest(request)
        }
        return true
    }

}