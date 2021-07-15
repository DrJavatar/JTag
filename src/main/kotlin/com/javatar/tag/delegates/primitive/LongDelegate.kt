package com.javatar.tag.delegates.primitive

import com.javatar.tag.JTag
import kotlin.reflect.KProperty

class LongDelegate(val tag: JTag, val initialValue: Long = 0L) {

    operator fun getValue(any: Any?, prop: KProperty<*>) : Long {
        return if(tag.has(prop.name)) {
            tag.getLong(prop.name)
        } else {
            setValue(any, prop, initialValue)
            initialValue
        }
    }

    operator fun setValue(any: Any?, prop: KProperty<*>, value: Long) {
        tag.setLong(prop.name, value)
    }

}