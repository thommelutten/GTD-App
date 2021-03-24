package com.productivity.gtd.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Items (
        val projects: List<Project>,
        val nextAction: List<NextAction>,
        val action: List<Capture>
)