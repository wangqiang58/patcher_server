package com.xdf.patcher.controller

import com.xdf.patcher.entity.Admin
import com.xdf.patcher.entity.ApiResult
import com.xdf.patcher.entity.Login
import com.xdf.patcher.serviceImp.LoginServiceImpl
import com.xdf.patcher.util.ApiResultHandler
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class LoginController {

    @Autowired
    lateinit var loginService: LoginServiceImpl

    @RequestMapping("/login", method = [RequestMethod.POST])
    fun login(@RequestBody login: Login): ApiResult<Any?> {

        val admin: Admin? = loginService.adminLogin(login.userName, login.password)
        if (admin != null)
            return ApiResultHandler.buildApiResult(200, "登陆成功", admin)
        else
            return ApiResultHandler.buildApiResult(400, "登陆失败", null)
    }
}