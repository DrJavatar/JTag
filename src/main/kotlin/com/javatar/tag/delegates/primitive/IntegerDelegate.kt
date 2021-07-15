package com.javatar.tag.delegates.primitive

import com.javatar.tag.JTag
import kotlin.reflect.KProperty

class IntegerDelegate(val tag: JTag, val initialValue: Int = 0) {

    operator fun getValue(any: Any?, prop: KProperty<*>) : Int {
        return if(tag.has(prop.name)) {
            tag.getInt(prop.name)
        } else {
            setValue(any, prop, initialValue)
            initialValue
        }
    }

    operator fun setValue(any: Any?, prop: KProperty<*>, value: Int) {
        tag.setInt(prop.name, value)
    }

}