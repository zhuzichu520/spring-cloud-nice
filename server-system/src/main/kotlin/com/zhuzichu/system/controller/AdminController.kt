package com.zhuzichu.system.controller

import com.zhuzichu.system.service.AdminService
import com.zhuzichu.shared.entity.system.bean.TokenPayload
import com.zhuzichu.shared.entity.system.dto.AddAdminDto
import com.zhuzichu.shared.entity.system.dto.LoginDto
import com.zhuzichu.shared.entity.system.param.AddAdminParam
import com.zhuzichu.shared.entity.system.param.LoginParam
import com.zhuzichu.shared.entity.system.po.Admin
import com.zhuzichu.shared.interceptor.CheckToken
import com.zhuzichu.shared.response.ResponseController
import com.zhuzichu.shared.utils.BusinessUtil
import io.swagger.annotations.Api
import io.swagger.v3.oas.annotations.Operation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletRequest

@RestController
@ResponseController
@RequestMapping(value = ["/system/admin"], produces = ["application/json"])
@Api(tags = ["用户相关接口"])
class AdminController {

    @Autowired
    private lateinit var adminService: AdminService

    @ResponseBody
    @Operation(summary = "用户登录")
    @RequestMapping(value = ["/login"], method = [RequestMethod.POST])
    fun login(param: LoginParam):LoginDto{
        param.formatCheck()
        val user = adminService.login(param)
        return user.loginDto(BusinessUtil.createToken(user))
    }

    @ResponseBody
    @CheckToken
    @Operation(summary = "获取用户信息")
    @RequestMapping(value = ["/getAdmin"], method = [RequestMethod.POST])
    fun getAdmin(
        request: HttpServletRequest,
    ):TokenPayload{
        return TokenPayload.from(request)
    }

    @ResponseBody
    @CheckToken
    @Operation(summary = "添加管理员")
    @RequestMapping(value = ["/addAdmin"], method = [RequestMethod.POST])
    fun addAdmin(param: AddAdminParam): AddAdminDto {
        param.formatCheck()
        return adminService.addAdmin(param).addAdminDto()
    }

}