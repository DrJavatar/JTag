package com.javatar.tag.delegates.lists

import com.javatar.tag.JTag
import kotlin.reflect.KProperty

class IntListDelegate(val tag: JTag, val initialValues: List<Int> = mutableListOf()) {

    operator fun getValue(any: Any?, prop: KProperty<*>) : List<Int> {
        return if(tag.has(prop.name)) {
            tag.getInts(prop.name)
        } else {
            setValue(any, prop, initialValues)
            initialValues
        }
    }

    operator fun setValue(any: Any?, prop: KProperty<*>, values: List<Int>) {
        tag.setInts(prop.name, *values.toIntArray())
    }

}