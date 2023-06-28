package com.xdf.patcher.controller

import com.xdf.patcher.entity.ApiResult
import com.xdf.patcher.serviceImp.AppVersionServiceImpl
import com.xdf.patcher.serviceImp.PluginServiceImpl
import com.xdf.patcher.util.ApiResultHandler
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class PluginsController {

    @Autowired
    lateinit var pluginService: PluginServiceImpl

    @RequestMapping("/plugins", method = [RequestMethod.GET])
    fun getAllApps(@RequestParam appVersionName: String): ApiResult<Any?> {

        val plugins = pluginService.findAllPluginsByAppVersion(appVersionName)
        if (plugins?.isEmpty() == false)
            return ApiResultHandler.buildApiResult(200, "", plugins)
        else
            return ApiResultHandler.buildApiResult(400, "暂无数据", null)
    }
}