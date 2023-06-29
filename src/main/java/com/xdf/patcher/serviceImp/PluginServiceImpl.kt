package com.xdf.patcher.serviceImp

import com.xdf.patcher.entity.Plugin
import com.xdf.patcher.mapper.PluginsMapper
import com.xdf.patcher.service.PluginService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.sql.Timestamp
import java.util.*


@Service
class PluginServiceImpl : PluginService {

    @Autowired
    private lateinit var pluginMapper: PluginsMapper

    override fun findAllPluginsByAppVersion(appVersion: String): List<Plugin>? {
        return pluginMapper.findPluginsByAppVersion(appVersion)
    }

    override fun uploadPlugin(appVersion: String, apkPath: String, flavor: String, mark: String?):Boolean {
        val currentTimestamp = Timestamp(Date().time)
        val plugin = Plugin().apply{
            this.mark = mark
            this.flavor = flavor
            this.time = currentTimestamp
            this.status = Plugin.STATUS_INIT
            this.versionName = appVersion
            this.apkPath = apkPath
        }
        pluginMapper.uploadPlugin(plugin)
        return plugin.id >0
    }

}