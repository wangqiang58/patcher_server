package com.xdf.patcher.controller

import com.xdf.patcher.entity.ApiResult
import com.xdf.patcher.serviceImp.AppVersionServiceImpl
import com.xdf.patcher.serviceImp.PluginServiceImpl
import com.xdf.patcher.util.ApiResultHandler
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.io.IOException




@RestController
class PluginsController {

    @Autowired
    lateinit var pluginService: PluginServiceImpl

    @Autowired
    lateinit var appVersionService: AppVersionServiceImpl

    @RequestMapping("/plugin/list", method = [RequestMethod.GET])
    fun getAllPlugins4AppVersion(@RequestParam appVersionName: String): ApiResult<Any?> {

        val plugins = pluginService.findAllPluginsByAppVersion(appVersionName)
        if (plugins?.isEmpty() == false)
            return ApiResultHandler.buildApiResult(200, "", plugins)
        else
            return ApiResultHandler.buildApiResult(400, "暂无数据", null)
    }

    @PostMapping("/plugin/upload")
    fun addPlugin4Version(@RequestParam("file") file: MultipartFile,
                          @RequestParam("versionName")  versionName:String,
                          @RequestParam("mark") mark:String?,
                          @RequestParam("flavor") flavor:String): ApiResult<Any?>{
        if (file.isEmpty){
            return ApiResultHandler.buildApiResult(400, "apk文件未空", null)
        }
        // 获取文件名
        val fileName = file.originalFilename
        // 设置文件存储路径
        val filePath = "/Users/wangqiang38/Desktop/uploads/"

        try {
            // 创建目标文件对象
            val destFile = File(filePath + fileName)
            // 保存文件
            file.transferTo(destFile)
            val result = pluginService.uploadPlugin(versionName,destFile.path,flavor,mark)
            if (result){
                appVersionService.insertAppVesionIfNotExist(versionName)
            }

        } catch (e: IOException) {
            e.printStackTrace()
            return ApiResultHandler.buildApiResult(400, "文件上传失败，请重试", null)
        }
        return ApiResultHandler.buildApiResult(200, "文件上传成功", null)
    }
}