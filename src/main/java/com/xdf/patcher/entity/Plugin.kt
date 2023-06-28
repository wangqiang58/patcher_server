package com.xdf.patcher.entity

import java.sql.Timestamp

data class Plugin(val versionName: String, val flavor: String, val status: Int, val mark: String?, val id: Int,val time:Long)