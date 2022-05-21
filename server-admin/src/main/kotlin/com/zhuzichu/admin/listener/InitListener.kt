package com.zhuzichu.admin.listener

import com.zhuzichu.shared.ext.logi
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.stereotype.Component
import java.util.concurrent.atomic.AtomicBoolean


@Component
class InitListener : ApplicationListener<ContextRefreshedEvent> {

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
        logi("接口地址：http://localhost:8080/swagger-ui/index.html");
    }

}