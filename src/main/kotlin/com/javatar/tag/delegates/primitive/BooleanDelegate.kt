package com.javatar.tag.delegates.primitive

import com.javatar.tag.JTag
import kotlin.reflect.KProperty

class BooleanDelegate(val tag: JTag, val initialValue: Boolean = false) {

    operator fun getValue(any: Any?, prop: KProperty<*>) : Boolean {
        return if(tag.has(prop.name)) {
            tag.getBoolean(prop.name)
        } else {
            setValue(any, prop, initialValue)
            initialValue
        }
    }

    operator fun setValue(any: Any?, prop: KProperty<*>, value: Boolean) {
        tag.setBoolean(prop.name, value)
    }

}