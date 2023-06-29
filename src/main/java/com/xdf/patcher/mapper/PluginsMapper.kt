package com.xdf.patcher.mapper

import com.xdf.patcher.entity.Plugin
import org.apache.ibatis.annotations.*
import java.sql.Timestamp

interface PluginsMapper {

    @Results(
            Result(column = "version_name", property = "versionName"),
            Result(column = "status", property = "status"),
            Result(column = "time", property = "time"),
            Result(column = "mark", property = "mark"),
            Result(column = "flavor", property = "flavor"),
            Result(column = "id", property = "id")
            )
    /**
     * 查看当前app版本的所有插件
     */
    @Select("select id, version_name,flavor, status, time, mark from plugin where version_name = #{versionName}")
    fun findPluginsByAppVersion(versionName: String): List<Plugin>?


    @Insert("INSERT INTO plugin (version_name, file_path, flavor, status, time, mark) VALUES (#{versionName}, #{apkPath}, #{flavor}, #{status}, #{time}, #{mark})")
    @Options(useGeneratedKeys=true, keyProperty="id")
    fun uploadPlugin(plugin: Plugin)
}