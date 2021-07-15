package com.javatar.tag

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import kotlinx.serialization.json.*

@Serializable
class JTag(override val name: String) : MutableTag<JTag> {

    private val values = linkedMapOf<String, JsonElement>()
    @Transient val children = linkedMapOf<String, List<JTag>>()

    override fun setInt(key: String, integer: Int) {
        values[key] = JsonPrimitive(integer)
    }

    override fun setLong(key: String, long: Long) {
        values[key] = JsonPrimitive(long)
    }

    override fun setDouble(key: String, double: Double) {
        values[key] = JsonPrimitive(double)
    }

    override fun setFloat(key: String, float: Float) {
        values[key] = JsonPrimitive(float)
    }

    override fun setString(key: String, value: String) {
        values[key] = JsonPrimitive(value)
    }

    override fun setBoolean(key: String, value: Boolean) {
        values[key] = JsonPrimitive(value)
    }

    override fun setTag(key: String, tag: JTag) {
        children[key] = listOf(tag)
    }

    override fun setInts(key: String, vararg values: Int) {
        this.values[key] = TagModule.json.encodeToJsonElement(values)
    }

    override fun setLongs(key: String, vararg values: Long) {
        this.values[key] = TagModule.json.encodeToJsonElement(values)
    }

    override fun setDoubles(key: String, vararg values: Double) {
        this.values[key] = TagModule.json.encodeToJsonElement(values)
    }

    override fun setFloats(key: String, vararg values: Float) {
        this.values[key] = TagModule.json.encodeToJsonElement(values)
    }

    override fun setStrings(key: String, vararg values: String) {
        this.values[key] = TagModule.json.encodeToJsonElement(values)
    }

    override fun setBooleans(key: String, vararg values: Boolean) {
        this.values[key] = TagModule.json.encodeToJsonElement(values)
    }

    override fun setTags(key: String, vararg values: JTag) {
        children[key] = listOf(*values)
    }

    override fun getInt(key: String): Int {
        return values[key]?.jsonPrimitive?.int ?: 0
    }

    override fun getLong(key: String): Long {
        return values[key]?.jsonPrimitive?.long ?: 0L
    }

    override fun getDouble(key: String): Double {
        return values[key]?.jsonPrimitive?.double ?: 0.0
    }

    override fun getFloat(key: String): Float {
        return values[key]?.jsonPrimitive?.float ?: 0f
    }

    override fun getString(key: String): String {
        return values[key]?.jsonPrimitive?.content ?: ""
    }

    override fun getBoolean(key: String): Boolean {
        return values[key]?.jsonPrimitive?.boolean ?: false
    }

    override fun getTag(key: String): JTag {
        if(children.containsKey(key)) {
            return children[key]?.get(0) ?: this
        }
        return this
    }

    override fun getInts(key: String): List<Int> {
        return this.values[key]?.jsonArray?.mapNotNull { it.jsonPrimitive.int } ?: mutableListOf()
    }

    override fun getLongs(key: String): List<Long> {
        return this.values[key]?.jsonArray?.mapNotNull { it.jsonPrimitive.long } ?: mutableListOf()
    }

    override fun getDoubles(key: String): List<Double> {
        return this.values[key]?.jsonArray?.mapNotNull { it.jsonPrimitive.double } ?: mutableListOf()
    }

    override fun getFloats(key: String): List<Float> {
        return this.values[key]?.jsonArray?.mapNotNull { it.jsonPrimitive.float } ?: mutableListOf()
    }

    override fun getStrings(key: String): List<String> {
        return this.values[key]?.jsonArray?.mapNotNull { it.jsonPrimitive.content } ?: mutableListOf()
    }

    override fun getBooleans(key: String): List<Boolean> {
        return this.values[key]?.jsonArray?.mapNotNull { it.jsonPrimitive.boolean } ?: mutableListOf()
    }

    override fun getTags(key: String): List<JTag> {
        if(children.containsKey(key)) {
            return children[key]!!
        }
        return mutableListOf()
    }

    override fun has(key: String): Boolean {
        return this.values.containsKey(key)
    }

    override fun toString(): String {
        val values = linkedMapOf<String, JsonElement>()
        values.putAll(this.values)
        children.entries.forEach {
            it.value.forEach { tag -> values[tag.name] = JsonObject(tag.values) }
        }
        return JsonObject(values).toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as JTag

        if (values != other.values) return false

        return true
    }

    override fun hashCode(): Int {
        return values.hashCode()
    }
}