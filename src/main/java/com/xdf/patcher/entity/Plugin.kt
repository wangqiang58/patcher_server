package com.xdf.patcher.entity

import java.sql.Timestamp

class Plugin {
    lateinit var versionName: String;
    lateinit var flavor: String;
    var status: Int = 0
    val mark: String? = null
    var id: Int = 0
    lateinit var time: Timestamp
}