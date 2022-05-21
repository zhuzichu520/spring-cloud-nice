package com.zhuzichu.shared.entity.admin.bean

import cn.hutool.core.convert.Convert
import javax.servlet.http.HttpServletRequest

data class TokenPayload(
    val id:Long?,
    val username:String,
    val expireTime:Long
){
    fun toRequest(request: HttpServletRequest):HttpServletRequest {
        request.setAttribute("id",id)
        request.setAttribute("username",username)
        request.setAttribute("expireTime",expireTime)
        return request
    }

    companion object{
        fun from(request: HttpServletRequest):TokenPayload{
            val id = Convert.toLong(request.getAttribute("id"))
            val username = Convert.toStr(request.getAttribute("username"))
            val expireTime = Convert.toLong(request.getAttribute("expireTime"))
           return TokenPayload(id,username,expireTime)
        }
    }


}