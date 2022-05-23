package com.zhuzichu.shared.utils

import cn.hutool.core.convert.Convert
import cn.hutool.crypto.SecureUtil
import cn.hutool.jwt.JWTUtil
import com.zhuzichu.shared.entity.admin.bean.TokenPayload
import com.zhuzichu.shared.entity.admin.po.Admin

object BusinessUtil {

    private val sha256:String = SecureUtil.sha256("zhuzichu")

    /**
     * 创建JwtToken
     */
    fun createToken(user: Admin):String{
        return JWTUtil.createToken(HashMap<String,Any?>().apply {
            put("id", user.id)
            put("username", user.username)
            put("expire_time",  System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 15)
        },sha256.toByteArray())
    }

    /**
     * 验证token合法性
     */
    fun verifyToken(token:String):Boolean{
        return JWTUtil.verify(token, sha256.toByteArray())
    }

    /**
     * 获取token中的payload信息
     */
    fun getTokenPayload(token:String):TokenPayload{
        val jwt = JWTUtil.parseToken(token)
        val id = Convert.toLong(jwt.getPayload("id"))
        val username = Convert.toStr(jwt.getPayload("username"))
        val expireTime = Convert.toLong(jwt.getPayload("expire_time"))
        return TokenPayload(id,username,expireTime)
    }

}