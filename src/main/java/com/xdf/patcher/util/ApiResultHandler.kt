package com.xdf.patcher.util

import com.xdf.patcher.entity.ApiResult

class ApiResultHandler {
    companion object {

        fun <T> buildApiResult(code: Int, message: String, data: T): ApiResult<T> {
            return ApiResult(code, message, data)
        }
    }
}