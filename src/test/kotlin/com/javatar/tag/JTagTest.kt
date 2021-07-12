package com.javatar.tag

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.encodeToJsonElement
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import kotlin.properties.Delegates

class JTagTest {

    @Test
    fun `test of setting primitive types`() {
        val tag = JTag("Test")

        tag.setInt("age", 5)

        assert(tag.int("age") == 5) { "Failed to add int to tag." }

        tag.setString("name", "Javatar")

        assert(tag.string("name") == "Javatar") { "Failed to add string to tag." }

        tag.setBoolean("male", true)

        assert(tag.boolean("male")) { "Failed to add boolean to tag." }

    }

    @Test
    fun `tag in a tag test`() {
        val tag = JTag("Test")
        tag.setString("name", "Javatar")

        val home = JTag("Home")
        home.setString("street", "some street")
        home.setInt("home_age", 55)

        println(home)

        tag.setTag("home", home)

        val extracted = tag.tag("home")

        assert(extracted.int("home_age") == 55) { "Failed to extract tag home from root tag $extracted" }

        println(tag)
    }

    companion object {
        var start by Delegates.notNull<Long>()
        @BeforeAll
        @JvmStatic
        fun initTests() {
            start = System.nanoTime()
        }

        @AfterAll
        @JvmStatic
        fun finish() {
            val end = System.nanoTime()
            val time = (end - start)
            println("Time took: $time nano seconds - ${time / 1_000_000L} ms.")
        }
    }

}