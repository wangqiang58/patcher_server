package com.xdf.patcher.service

import com.xdf.patcher.entity.Admin
import com.xdf.patcher.entity.AppVersion
import com.xdf.patcher.entity.Plugin

interface PluginService {
    /**
     * 查看app版本对应的所有插件
     */
    fun findAllPluginsByAppVersion(appVersion: String): List<Plugin>?

    /**
     * appVersion：插件对应版本
     * apkPath:cdn apk文件路径
     * flavor:渠道
     * mark 备注
     */
    fun uploadPlugin(appVersion: String, apkPath: String, flavor: String, mark: String?):Boolean
}