package com.zhuzichu.admin.controller

import com.zhuzichu.admin.service.UserService
import com.zhuzichu.shared.entity.admin.dto.UserDto
import com.zhuzichu.shared.utils.BusinessUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping(value = ["/admin/user"], produces = ["application/json"])
class UserController {

    @Autowired
    private lateinit var userService: UserService

    @ResponseBody
    @RequestMapping(value = ["/login"], method = [RequestMethod.POST])
    fun login(
        @RequestParam("username")
        username:String,
        @RequestParam("password")
        password:String
    ):UserDto{
        val user = userService.login(username, password)
        return user.toDto(BusinessUtil.createToken(user))
    }

}