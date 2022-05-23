package com.zhuzichu.system.controller

import com.zhuzichu.system.service.AdminService
import com.zhuzichu.shared.entity.admin.bean.TokenPayload
import com.zhuzichu.shared.entity.admin.dto.UserDto
import com.zhuzichu.shared.entity.admin.param.LoginParam
import com.zhuzichu.shared.interceptor.CheckToken
import com.zhuzichu.shared.response.ResponseController
import com.zhuzichu.shared.utils.BusinessUtil
import io.swagger.annotations.Api
import io.swagger.v3.oas.annotations.Operation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.ValidationUtils
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletRequest

@RestController
@ResponseController
@RequestMapping(value = ["/admin/user"], produces = ["application/json"])
@Api(tags = ["用户相关接口"])
class AdminController {

    @Autowired
    private lateinit var userService: AdminService

    @ResponseBody
    @Operation(summary = "用户登录")
    @RequestMapping(value = ["/login"], method = [RequestMethod.POST])
    fun login(loginParam: LoginParam):UserDto{
        loginParam.formatCheck()
        val user = userService.login(loginParam.username, loginParam.password)
        return user.toDto(BusinessUtil.createToken(user))
    }

    @ResponseBody
    @CheckToken
    @Operation(summary = "获取用户信息")
    @RequestMapping(value = ["/getUserInfo"], method = [RequestMethod.POST])
    fun getUserInfo(
        request: HttpServletRequest,
    ):TokenPayload{
        return TokenPayload.from(request)
    }
}