package com.javatar.tag

sealed interface MutableTag<T : Tag> : Tag {

    fun setInt(key: String, integer: Int)
    fun setLong(key: String, long: Long)
    fun setDouble(key: String, double: Double)
    fun setFloat(key: String, float: Float)
    fun setString(key: String, value: String)
    fun setBoolean(key: String, value: Boolean)
    fun setTag(key: String, tag: T)

    fun setInts(key: String, vararg values: Int)
    fun setLongs(key: String, vararg values: Long)
    fun setDoubles(key: String, vararg values: Double)
    fun setFloats(key: String, vararg values: Float)

    fun setStrings(key: String, vararg values: String)
    fun setBooleans(key: String, vararg values: Boolean)
    fun setTags(key: String, vararg values: T)

}