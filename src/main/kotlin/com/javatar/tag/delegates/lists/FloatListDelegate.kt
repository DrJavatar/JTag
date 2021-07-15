package com.javatar.tag.delegates.lists

import com.javatar.tag.JTag
import kotlin.reflect.KProperty

class FloatListDelegate(val tag: JTag, val initialValues: List<Float>) {

    operator fun getValue(any: Any?, prop: KProperty<*>) : List<Float> {
        return if(tag.has(prop.name)) {
            tag.getFloats(prop.name)
        } else {
            setValue(any, prop, initialValues)
            initialValues
        }
    }

    operator fun setValue(any: Any?, prop: KProperty<*>, values: List<Float>) {
        tag.setFloats(prop.name, *values.toFloatArray())
    }

}