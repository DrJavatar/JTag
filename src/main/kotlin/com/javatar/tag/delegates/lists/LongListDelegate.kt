package com.javatar.tag.delegates.lists

import com.javatar.tag.JTag
import kotlin.reflect.KProperty

class LongListDelegate(val tag: JTag, val initialValues: List<Long>) {

    operator fun getValue(any: Any?, prop: KProperty<*>) : List<Long> {
        return if(tag.has(prop.name)) {
            tag.getLongs(prop.name)
        } else {
            setValue(any, prop, initialValues)
            initialValues
        }
    }

    operator fun setValue(any: Any?, prop: KProperty<*>, values: List<Long>) {
        tag.setLongs(prop.name, *values.toLongArray())
    }

}