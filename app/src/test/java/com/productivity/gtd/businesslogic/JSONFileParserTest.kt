package com.productivity.gtd.businesslogic

import com.productivity.gtd.models.Capture
import com.productivity.gtd.models.Items
import com.productivity.gtd.models.NextAction
import com.productivity.gtd.models.Project
import com.squareup.moshi.Json
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonClass
import com.squareup.moshi.Moshi
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Assert
import org.junit.Test
import java.io.File

class JSONFileParserTest {

    @Test
    fun write_project_json() {
        val project = Project(1, "TestProject", NextAction(1, "TestAction", "Do something"))

        val moshi: Moshi = Moshi.Builder()
                .build()
        val adapter: JsonAdapter<Project> = moshi.adapter(Project::class.java).lenient()
        val jsonString = adapter.toJson(project)
        
        val jsonStringTarget = "{\"id\":1,\"title\":\"TestProject\",\"nextAction\":{\"id\":1,\"name\":\"TestAction\",\"content\":\"Do something\"}}"
        Assert.assertEquals(jsonString, jsonStringTarget)
    }

    @Test
    fun read_project_json() {
        val jsonString = "{\"id\":1,\"title\":\"TestProject\",\"nextAction\":{\"id\":1,\"name\":\"TestAction\",\"content\":\"Do something\"}}"

        val moshi: Moshi = Moshi.Builder()
                .build()
        val adapter: JsonAdapter<Project> = moshi.adapter(Project::class.java).lenient()
        val projectJson = adapter.fromJson(jsonString)

        val projectOriginal = Project(1, "TestProject", NextAction(1, "TestAction", "Do something"))

        Assert.assertEquals(projectJson, projectOriginal)
    }

    @Test
    fun write_json_items() {
        val items = Items(
                listOf(
                    Project(1,"FirstItem", NextAction(1, "TestAction", "Do Something")),
                    Project(2,"SecondItem", NextAction(1, "TestAction", "Do Something"))
                ),
                listOf(
                    NextAction(1, "Name1", "Content"),
                    NextAction(2, "Name2", "Content2")
                ),
                listOf(
                    Capture(1, "Content"),
                    Capture(2, "Content")
                )
        )

        val moshi: Moshi = Moshi.Builder()
        .build()
        val adapter: JsonAdapter<Items> = moshi.adapter(Items::class.java).lenient()
        val jsonString = adapter.toJson(items)

        val jsonResponse = "{\"projects\":[{\"id\":1,\"title\":\"FirstItem\",\"nextAction\":{\"id\":1,\"name\":\"TestAction\",\"content\":\"Do Something\"}},{\"id\":2,\"title\":\"SecondItem\",\"nextAction\":{\"id\":1,\"name\":\"TestAction\",\"content\":\"Do Something\"}}],\"nextAction\":[{\"id\":1,\"name\":\"Name1\",\"content\":\"Content\"},{\"id\":2,\"name\":\"Name2\",\"content\":\"Content2\"}],\"action\":[{\"id\":1,\"content\":\"Content\"},{\"id\":2,\"content\":\"Content\"}]}"

        Assert.assertEquals(jsonResponse, jsonString)
    }

    @Test
    fun read_json_items() {
        val jsonString = "{\"projects\":[{\"id\":1,\"title\":\"FirstItem\",\"nextAction\":{\"id\":1,\"name\":\"TestAction\",\"content\":\"Do Something\"}},{\"id\":2,\"title\":\"SecondItem\",\"nextAction\":{\"id\":1,\"name\":\"TestAction\",\"content\":\"Do Something\"}}],\"nextAction\":[{\"id\":1,\"name\":\"Name1\",\"content\":\"Content\"},{\"id\":2,\"name\":\"Name2\",\"content\":\"Content2\"}],\"action\":[{\"id\":1,\"content\":\"Content\"},{\"id\":2,\"content\":\"Content\"}]}"

        val moshi: Moshi = Moshi.Builder()
                .build()
        val adapter: JsonAdapter<Items> = moshi.adapter(Items::class.java).lenient()
        val itemsFromJson = adapter.fromJson(jsonString)

        val items = Items(
                listOf(
                        Project(1,"FirstItem", NextAction(1, "TestAction", "Do Something")),
                        Project(2,"SecondItem", NextAction(1, "TestAction", "Do Something"))
                ),
                listOf(
                        NextAction(1, "Name1", "Content"),
                        NextAction(2, "Name2", "Content2")
                ),
                listOf(
                        Capture(1, "Content"),
                        Capture(2, "Content")
                )
        )

        Assert.assertEquals(itemsFromJson, items)
    }
}