package com.zhuzichu.shared.response

import java.io.Serializable

data class Result<T>(
    val success:Boolean,
    val code:Int,
    val message:String,
    val data:T?=null,
    val timestamp:Long = System.currentTimeMillis()
) :Serializable{
    companion object{

        fun <T> success(code: Int?=null, message:String?=null, data: T?=null): Result<T> {
            return Result(true, code?:ResultCode.RC200.code, message?:ResultCode.RC200.message,data)
        }

        fun <T> failure(code: Int?=null, message:String?=null, data: T?=null): Result<T> {
            return Result(true, code?:ResultCode.RC999.code, message?:ResultCode.RC999.message,data)
        }

    }
}
