package com.productivity.gtd.businesslogic

import com.productivity.gtd.models.NextAction
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonDataException
import com.squareup.moshi.ToJson

class ActionsAdapter {

    @ToJson
    fun toJson(nextActions: List<NextAction>): List<NextAction> {
        return nextActions
    }

    @FromJson
    fun fromJson(nextActions: Array<NextAction>): Array<NextAction> {
        return nextActions
    }
}