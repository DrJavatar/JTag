package com.javatar.tag.delegates.lists

import com.javatar.tag.JTag
import kotlin.reflect.KProperty

class DoubleListDelegate(val tag: JTag, val initialValues: List<Double>) {

    operator fun getValue(any: Any?, prop: KProperty<*>) : List<Double> {
        return if(tag.has(prop.name)) {
            tag.getDoubles(prop.name)
        } else {
            setValue(any, prop, initialValues)
            initialValues
        }
    }

    operator fun setValue(any: Any?, prop: KProperty<*>, values: List<Double>) {
        tag.setDoubles(prop.name, *values.toDoubleArray())
    }

}