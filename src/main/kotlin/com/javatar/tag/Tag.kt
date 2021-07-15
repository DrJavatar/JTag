package com.javatar.tag

sealed interface Tag {

    val name: String

    fun getInt(key: String): Int
    fun getLong(key: String): Long
    fun getDouble(key: String): Double
    fun getFloat(key: String): Float
    fun getString(key: String): String
    fun getBoolean(key: String): Boolean
    fun getTag(key: String): Tag

    fun getInts(key: String): List<Int>
    fun getLongs(key: String): List<Long>
    fun getDoubles(key: String): List<Double>
    fun getFloats(key: String): List<Float>
    fun getStrings(key: String): List<String>
    fun getBooleans(key: String): List<Boolean>
    fun getTags(key: String): List<Tag>

    fun has(key: String) : Boolean

}