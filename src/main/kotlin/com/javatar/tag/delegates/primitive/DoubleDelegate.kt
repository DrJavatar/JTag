package com.javatar.tag.delegates.primitive

import com.javatar.tag.JTag
import kotlin.reflect.KProperty

class DoubleDelegate(val tag: JTag, val initialValue: Double = 0.0) {

    operator fun getValue(any: Any?, prop: KProperty<*>) : Double {
        return if(tag.has(prop.name)) {
            tag.getDouble(prop.name)
        } else {
            setValue(any, prop, initialValue)
            initialValue
        }
    }

    operator fun setValue(any: Any?, prop: KProperty<*>, value: Double) {
        tag.setDouble(prop.name, value)
    }

}