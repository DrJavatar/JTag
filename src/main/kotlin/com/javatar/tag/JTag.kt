package com.javatar.tag

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import kotlinx.serialization.json.*

@Serializable
class JTag(override val name: String) : MutableTag<JTag> {

    private val values = linkedMapOf<String, JsonElement>()

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
        values[key] = JsonObject(tag.values)
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
        this.values[key] = TagModule.json.encodeToJsonElement(values)
    }

    override fun int(key: String): Int {
        return values[key]?.jsonPrimitive?.int ?: 0
    }

    override fun long(key: String): Long {
        return values[key]?.jsonPrimitive?.long ?: 0L
    }

    override fun double(key: String): Double {
        return values[key]?.jsonPrimitive?.double ?: 0.0
    }

    override fun float(key: String): Float {
        return values[key]?.jsonPrimitive?.float ?: 0f
    }

    override fun string(key: String): String {
        return values[key]?.jsonPrimitive?.content ?: ""
    }

    override fun boolean(key: String): Boolean {
        return values[key]?.jsonPrimitive?.boolean ?: false
    }

    override fun tag(key: String): JTag {
        val json = this.values[key]?.jsonObject
        if (json != null) {
            return JTag(key).also { it.values.putAll(json) }
        }
        return this
    }

    override fun ints(key: String): List<Int> {
        return this.values[key]?.jsonArray?.mapNotNull { it.jsonPrimitive.int } ?: mutableListOf()
    }

    override fun longs(key: String): List<Long> {
        return this.values[key]?.jsonArray?.mapNotNull { it.jsonPrimitive.long } ?: mutableListOf()
    }

    override fun doubles(key: String): List<Double> {
        return this.values[key]?.jsonArray?.mapNotNull { it.jsonPrimitive.double } ?: mutableListOf()
    }

    override fun floats(key: String): List<Float> {
        return this.values[key]?.jsonArray?.mapNotNull { it.jsonPrimitive.float } ?: mutableListOf()
    }

    override fun strings(key: String): List<String> {
        return this.values[key]?.jsonArray?.mapNotNull { it.jsonPrimitive.content } ?: mutableListOf()
    }

    override fun booleans(key: String): List<Boolean> {
        return this.values[key]?.jsonArray?.mapNotNull { it.jsonPrimitive.boolean } ?: mutableListOf()
    }

    override fun tags(key: String): List<Tag> {
        return this.values[key]?.jsonArray?.mapNotNull { Json.decodeFromJsonElement(it) } ?: mutableListOf()
    }

    override fun toString(): String {
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