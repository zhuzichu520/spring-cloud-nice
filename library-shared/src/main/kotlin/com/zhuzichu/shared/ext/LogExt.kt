package com.zhuzichu.shared.ext

import cn.hutool.log.LogFactory


fun Any.logd(text:String) {
    LogFactory.get(this::class.java).debug(text)
}

fun Any.logi(text:String) {
     LogFactory.get(this::class.java).info(text)
}

fun Any.logw(text:String) {
    LogFactory.get(this::class.java).warn(text)
}

fun Any.loge(text:String) {
    LogFactory.get(this::class.java).error(text)
}