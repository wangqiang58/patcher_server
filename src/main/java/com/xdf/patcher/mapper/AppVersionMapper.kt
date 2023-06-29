package com.xdf.patcher.mapper

import com.xdf.patcher.entity.AppVersion
import com.xdf.patcher.entity.Plugin
import org.apache.ibatis.annotations.*

interface AppVersionMapper {
    @Results(
            Result(column = "id", property = "id"),
            Result(column = "version_name", property = "versionName")
    )
    @Select("select id, version_name from version_app")
    fun findAllVersions(): List<AppVersion>?

    @Insert("INSERT INTO version_app (version_name) VALUES (#{versionName})")
    fun insertAppVersion(versionName: String)

    @Results(
            Result(column = "id", property = "id"),
            Result(column = "version_name", property = "versionName")
    )
    @Select("select id, version_name from version_app where version_name = #{versionName}")
    fun isAppVersionExist(versionName:String):List<AppVersion>?
}