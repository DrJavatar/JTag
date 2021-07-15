package com.javatar.tag

import com.javatar.tag.delegates.int
import com.javatar.tag.delegates.string
import com.javatar.tag.delegates.tag
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import kotlin.properties.Delegates

class JTagTest {

    @Test
    fun `test of setting primitive types`() {
        val tag = JTag("Test")

        tag.setInt("age", 5)

        assert(tag.getInt("age") == 5) { "Failed to add int to tag." }

        tag.setString("name", "Javatar")

        assert(tag.getString("name") == "Javatar") { "Failed to add string to tag." }

        tag.setBoolean("male", true)

        assert(tag.getBoolean("male")) { "Failed to add boolean to tag." }

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

        val extracted = tag.getTag("home")

        assert(extracted.getInt("home_age") == 55) { "Failed to extract tag home from root tag $extracted" }

        println(tag)
    }

    @Test
    fun delegates() {
        val tag = JTag("test")

        var age by tag.int(55)

        assert(age == 55) { "Failed to create integer delegate" }

        age = 255

        assert(tag.getInt("age") == 255) { "Failed to add age data." }

        val home by tag.tag {
            setString("phone", "some phone")
            setString("street", "some street")
        }

        println(home)

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