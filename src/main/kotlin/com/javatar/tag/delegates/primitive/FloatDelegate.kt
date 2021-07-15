package com.javatar.tag.delegates.primitive

import com.javatar.tag.JTag
import kotlin.reflect.KProperty

class FloatDelegate(val tag: JTag, val initialValue: Float = 0.0f) {

    operator fun getValue(any: Any?, prop: KProperty<*>) : Float {
        return if(tag.has(prop.name)) {
            tag.getFloat(prop.name)
        } else {
            setValue(any, prop, initialValue)
            initialValue
        }
    }

    operator fun setValue(any: Any?, prop: KProperty<*>, value: Float) {
        tag.setFloat(prop.name, value)
    }

}