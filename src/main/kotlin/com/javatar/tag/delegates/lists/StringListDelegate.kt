package com.javatar.tag.delegates.lists

import com.javatar.tag.JTag
import kotlin.reflect.KProperty

class StringListDelegate(val tag: JTag, val initialValues: List<String>) {

    operator fun getValue(any: Any?, prop: KProperty<*>) : List<String> {
        return if(tag.has(prop.name)) {
            tag.getStrings(prop.name)
        } else {
            setValue(any, prop, initialValues)
            initialValues
        }
    }

    operator fun setValue(any: Any?, prop: KProperty<*>, values: List<String>) {
        tag.setStrings(prop.name, *values.toTypedArray())
    }

}