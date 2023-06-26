package com.xdf.patcher.serviceImp

import com.xdf.patcher.entity.Admin
import com.xdf.patcher.service.LoginService

class LoginServiceImpl : LoginService {
    override fun adminLogin(userName: Int, password: String): Admin {
         return Admin(1,"123","male","130")
    }
}