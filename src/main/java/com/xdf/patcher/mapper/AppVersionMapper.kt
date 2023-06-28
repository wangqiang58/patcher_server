package com.xdf.patcher.mapper

import com.xdf.patcher.entity.AppVersion
import org.apache.ibatis.annotations.Result
import org.apache.ibatis.annotations.Results
import org.apache.ibatis.annotations.Select

interface AppVersionMapper {
    @Results(
            Result(column = "id", property = "versionId"),
            Result(column = "version_name", property = "versionName")
    )
    @Select("select id, version_name from version_app")
    fun findAllVersions(): List<AppVersion>?
}