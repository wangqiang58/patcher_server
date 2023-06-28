package com.xdf.patcher.serviceImp

import com.xdf.patcher.entity.Admin
import com.xdf.patcher.entity.AppVersion
import com.xdf.patcher.mapper.AppVersionMapper
import com.xdf.patcher.mapper.LoginMapper
import com.xdf.patcher.service.AppVersionService
import com.xdf.patcher.service.LoginService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class AppVersionServiceImpl : AppVersionService {

    @Autowired
    private lateinit var appVersionMapper: AppVersionMapper

    override fun findAllAppVersion(): List<AppVersion>? {
        return appVersionMapper.findAllVersions()
    }
}