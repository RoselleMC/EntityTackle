package com.iroselle.entitytackle.api

import com.iroselle.entitytackle.EntityTackle
import taboolib.platform.util.bukkitPlugin

interface TackleAPI {


    companion object {

        val inst get() = EntityTackle

    }
}