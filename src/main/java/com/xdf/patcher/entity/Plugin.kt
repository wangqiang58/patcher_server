package com.xdf.patcher.entity

import java.sql.Timestamp
class Plugin {
    var versionName: String? = null
    var flavor: String? = null
    var status: Int = STATUS_INIT
    var mark: String? = null
    var id: Int = -1
    var time: Timestamp? = null
    var apkPath:String? = null

    companion object {
        const val STATUS_INIT:Int = 0
    }
}
