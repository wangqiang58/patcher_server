package com.xdf.patcher.service

import com.xdf.patcher.entity.Admin

interface LoginService {
    /**
     * 管理员登陆
     */
    fun adminLogin(userName: Int, password: String): Admin
}