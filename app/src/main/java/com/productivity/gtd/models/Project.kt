package com.productivity.gtd.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Project (
        val id: Int,
        val title: String,
        val nextAction: NextAction
)

@JsonClass(generateAdapter = true)
data class NextAction(val id: Int, val name: String, val content: String)

@JsonClass(generateAdapter = true)
data class Capture(val id: Int, val content: String)