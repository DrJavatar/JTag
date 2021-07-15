package com.javatar.tag.delegates

import com.javatar.tag.JTag
import com.javatar.tag.delegates.lists.DoubleListDelegate
import com.javatar.tag.delegates.lists.FloatListDelegate
import com.javatar.tag.delegates.lists.IntListDelegate
import com.javatar.tag.delegates.lists.LongListDelegate
import com.javatar.tag.delegates.primitive.*
import com.javatar.tag.delegates.tags.TagDelegate
import com.javatar.tag.delegates.tags.TagListDelegate

fun JTag.int(initialValue: Int = 0) = IntegerDelegate(this, initialValue)
fun JTag.long(initialValue: Long = 0L) = LongDelegate(this, initialValue)
fun JTag.double(initialValue: Double = 0.0) = DoubleDelegate(this, initialValue)
fun JTag.float(initialValue: Float = 0.0f) = FloatDelegate(this, initialValue)
fun JTag.string(initialValue: String = "") = StringDelegate(this, initialValue)
fun JTag.tag(name: String = "", builder: JTag.() -> Unit = {}) = TagDelegate(this, name, builder)

fun JTag.ints(initialValues: List<Int> = mutableListOf()) = IntListDelegate(this, initialValues)
fun JTag.longs(initialValues: List<Long> = mutableListOf()) = LongListDelegate(this, initialValues)
fun JTag.doubles(initialValues: List<Double> = mutableListOf()) = DoubleListDelegate(this, initialValues)
fun JTag.floats(initialValues: List<Float> = mutableListOf()) = FloatListDelegate(this, initialValues)
fun JTag.tags(initialValues: List<JTag> = mutableListOf()) = TagListDelegate(this, initialValues)

