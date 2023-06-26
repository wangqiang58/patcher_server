package com.xdf.patcher.entity

/**
 *  请求成功，状态码为200
 */
data class ApiResult<T>(var code: Int = 0, var message: String? = null, var data: T? = null)




