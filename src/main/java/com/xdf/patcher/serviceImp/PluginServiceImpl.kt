package com.xdf.patcher.serviceImp

import com.xdf.patcher.entity.Admin
import com.xdf.patcher.entity.AppVersion
import com.xdf.patcher.entity.Plugin
import com.xdf.patcher.mapper.AppVersionMapper
import com.xdf.patcher.mapper.LoginMapper
import com.xdf.patcher.mapper.PluginsMapper
import com.xdf.patcher.service.AppVersionService
import com.xdf.patcher.service.LoginService
import com.xdf.patcher.service.PluginService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class PluginServiceImpl : PluginService {

    @Autowired
    private lateinit var pluginMapper: PluginsMapper

    override fun findAllPluginsByAppVersion(appVersion: String): List<Plugin>? {
        return pluginMapper.findPluginsByAppVersion(appVersion)
    }

}