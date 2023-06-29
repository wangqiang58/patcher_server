package com.xdf.patcher.service

import com.xdf.patcher.entity.AppVersion

interface AppVersionService {
    /**
     * 查找所有app版本
     */
    fun findAllAppVersion(): List<AppVersion>?

    /**
     * 插入APP版本号
     */
    fun insertAppVesionIfNotExist(versionName: String)
}