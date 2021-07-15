package com.javatar.tag.delegates.tags

import com.javatar.tag.JTag
import kotlin.reflect.KProperty

class TagListDelegate(val tag: JTag, val initialValues: List<JTag>) {

    operator fun getValue(any: Any?, prop: KProperty<*>) : List<JTag> {
        return if(tag.has(prop.name)) {
            tag.getTags(prop.name)
        } else {
            setValue(any, prop, initialValues)
            initialValues
        }
    }

    operator fun setValue(any: Any?, prop: KProperty<*>, values: List<JTag>) {
        tag.setTags(prop.name, *values.toTypedArray())
    }

}