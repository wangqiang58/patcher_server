package com.xdf.patcher.serviceImp

import com.xdf.patcher.entity.Admin
import com.xdf.patcher.mapper.LoginMapper
import com.xdf.patcher.service.LoginService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class LoginServiceImpl : LoginService {

    @Autowired
    private lateinit var loginMapper: LoginMapper

    override fun adminLogin(userName: Int, password: String): Admin? {
       return loginMapper.adminLogin(userName,password)
    }
}