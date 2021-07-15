package com.javatar.tag.delegates.primitive

import com.javatar.tag.JTag
import kotlin.reflect.KProperty

class StringDelegate(val tag: JTag, val initialValue: String = "") {

    operator fun getValue(any: Any?, prop: KProperty<*>) : String {
        return if(tag.has(prop.name)) {
            tag.getString(prop.name)
        } else {
            setValue(any, prop, initialValue)
            initialValue
        }
    }

    operator fun setValue(any: Any?, prop: KProperty<*>, value: String) {
        tag.setString(prop.name, value)
    }

}