package com.javatar.tag.delegates.tags

import com.javatar.tag.JTag
import kotlin.reflect.KProperty

class TagDelegate(val tag: JTag, val name: String, val builder: JTag.() -> Unit) {

    init {
        if(name.isNotEmpty()) {
            tag.setTag(name, JTag(name).apply(builder))
        }
    }

    operator fun getValue(any: Any?, prop: KProperty<*>) : JTag {
        return if(tag.has(prop.name)) {
            tag.getTag(prop.name)
        } else {
            val v = JTag(name.ifEmpty { prop.name }).apply(builder)
            setValue(any, prop, v)
            v
        }
    }

    operator fun setValue(any: Any?, prop: KProperty<*>, tag: JTag) {
        this.tag.setTag(prop.name, tag)
    }

}