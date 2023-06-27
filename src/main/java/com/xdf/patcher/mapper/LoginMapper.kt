package com.xdf.patcher.mapper

import com.xdf.patcher.entity.Admin
import org.apache.ibatis.annotations.Results
import org.apache.ibatis.annotations.Result
import org.apache.ibatis.annotations.Select

interface LoginMapper {

    @Results(
            Result(column = "admin_id", property = "adminId"),
            Result(column = "admin_name", property = "adminName"),
            Result(column = "password", property = "password"),
    )
    @Select("select admin_id,admin_name,password from admin where admin_id = #{username} and password = #{password}")
    fun adminLogin(username: Int?, password: String?): Admin?
}