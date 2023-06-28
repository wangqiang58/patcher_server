package com.xdf.patcher.mapper

import com.xdf.patcher.entity.Plugin
import org.apache.ibatis.annotations.Result
import org.apache.ibatis.annotations.Results
import org.apache.ibatis.annotations.Select

interface PluginsMapper {

    @Results(
            Result(column = "id", property = "id"),
            Result(column = "version_name", property = "versionName"),
            Result(column = "flavor", property = "flavor"),
            Result(column = "status", property = "status"),
            Result(column = "time", property = "time"),
            Result(column = "mark", property = "mark"),
    )
    /**
     * 查看当前app版本的所有插件
     */
    @Select("select id, version_name,flavor, status, time, mark from plugin where version_name = #{versionName}")
    fun findPluginsByAppVersion(versionName: String): List<Plugin>?
}