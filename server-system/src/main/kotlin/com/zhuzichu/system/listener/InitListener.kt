package com.zhuzichu.system.listener

import com.zhuzichu.shared.ext.logi
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.stereotype.Component
import java.util.concurrent.atomic.AtomicBoolean


@Component
class InitListener : ApplicationListener<ContextRefreshedEvent> {

    @Value("\${server.port}")
    private var port:Int=0

    @Volatile
    private var isInit = AtomicBoolean(false)

    override fun onApplicationEvent(event: ContextRefreshedEvent) {
        if(!isInit.compareAndSet(false,true)) {
            return
        }
        init()
    }

    private fun init(){
        logi("微服务启动完成")
        logi("接口地址：http://localhost:${port}/swagger-ui/index.html")
        logi("接口地址：http://localhost:${port}/doc.html")
    }

}