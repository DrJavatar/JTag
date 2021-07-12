package com.javatar.tag

import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass

object TagModule {

    val module = SerializersModule {
        polymorphic(Tag::class) {
            subclass(JTag::class)
        }
        polymorphic(MutableTag::class) {
            subclass(JTag::class)
        }
    }

    val json = Json {
        ignoreUnknownKeys = true
        serializersModule = module
    }

}