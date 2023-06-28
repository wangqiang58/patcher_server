package com.xdf.patcher.service

import com.xdf.patcher.entity.Admin
import com.xdf.patcher.entity.AppVersion

interface AppVersionService {
    /**
     * 查找所有app版本
     */
    fun findAllAppVersion(): List<AppVersion>?
}