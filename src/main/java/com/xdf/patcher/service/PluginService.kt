package com.xdf.patcher.service

import com.xdf.patcher.entity.Admin
import com.xdf.patcher.entity.AppVersion
import com.xdf.patcher.entity.Plugin

interface PluginService {
    /**
     * 查看app版本对应的所有插件
     */
    fun findAllPluginsByAppVersion(appVersion: String): List<Plugin>?
}