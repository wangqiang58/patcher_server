package com.xdf.patcher.controller

import com.xdf.patcher.entity.ApiResult
import com.xdf.patcher.serviceImp.AppVersionServiceImpl
import com.xdf.patcher.util.ApiResultHandler
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class AppVersionController {

    @Autowired
    lateinit var appVersionService: AppVersionServiceImpl

    @RequestMapping("/apps", method = [RequestMethod.GET])
    fun getAllApps(): ApiResult<Any?> {

        val apps = appVersionService.findAllAppVersion()
        if (apps?.isEmpty()==false)
            return ApiResultHandler.buildApiResult(200, "", apps)
        else
            return ApiResultHandler.buildApiResult(400, "暂无数据", null)
    }
}