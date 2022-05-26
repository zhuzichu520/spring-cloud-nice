package com.zhuzichu.system.controller

import com.zhuzichu.shared.entity.system.bean.TokenPayload
import com.zhuzichu.shared.entity.system.dto.GetAdmin
import com.zhuzichu.shared.entity.system.dto.Login
import com.zhuzichu.shared.entity.system.dto.SaveAdmin
import com.zhuzichu.shared.entity.system.param.LoginParam
import com.zhuzichu.shared.entity.system.param.SaveAdminParam
import com.zhuzichu.shared.interceptor.CheckToken
import com.zhuzichu.shared.response.Result
import com.zhuzichu.shared.utils.BusinessUtil
import com.zhuzichu.system.service.AdminService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletRequest

@RestController
@RequestMapping(value = ["/api/system/admin"], produces = ["application/json"])
@Api(tags = ["admin"], description = "管理员用户相关接口")
class AdminController {

    @Autowired
    private lateinit var adminService: AdminService

    @ResponseBody
    @ApiOperation(value = "用户登录", nickname = "login")
    @RequestMapping(value = ["/login"], method = [RequestMethod.POST])
    fun login(@RequestBody param: LoginParam): Result<Login> {
        param.formatCheck()
        val admin = adminService.login(param)
        return Result.success(data = admin.toLoginResult(BusinessUtil.createToken(admin)))
    }

    @ResponseBody
    @CheckToken
    @ApiOperation(value = "获取用户信息", nickname = "getAdmin")
    @RequestMapping(value = ["/getAdmin"], method = [RequestMethod.POST])
    fun getAdmin(
        request: HttpServletRequest,
    ): Result<GetAdmin> {
        val tokenPayload = TokenPayload.from(request)
        return Result.success(data = adminService.getAdminById(tokenPayload.id))
    }

    @ResponseBody
    @CheckToken
    @ApiOperation(value = "添加管理员", nickname = "saveAdmin")
    @RequestMapping(value = ["/saveAdmin"], method = [RequestMethod.POST])
    fun saveAdmin(@RequestBody param: SaveAdminParam): Result<SaveAdmin> {
        param.formatCheck()
        return Result.success(data = adminService.addAdmin(param).toSaveAdminResult())
    }

}