package com.javatar.tag

import kotlinx.serialization.json.JsonElement

sealed interface Tag {

    val name: String

    fun int(key: String): Int
    fun long(key: String): Long
    fun double(key: String): Double
    fun float(key: String): Float
    fun string(key: String): String
    fun boolean(key: String): Boolean
    fun tag(key: String): Tag

    fun ints(key: String): List<Int>
    fun longs(key: String): List<Long>
    fun doubles(key: String): List<Double>
    fun floats(key: String): List<Float>
    fun strings(key: String): List<String>
    fun booleans(key: String): List<Boolean>
    fun tags(key: String): List<Tag>

}