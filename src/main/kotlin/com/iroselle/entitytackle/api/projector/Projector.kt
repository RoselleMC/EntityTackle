package com.iroselle.entitytackle.api.projector

import com.iroselle.entitytackle.EntityTackle.projectorType
import org.bukkit.Location
import taboolib.common.io.runningClasses
import taboolib.library.reflex.Reflex.Companion.invokeConstructor

interface Projector {

    fun start()

    fun end()

    companion object {

        val projectors =
            runningClasses.filter {
                it.interfaces.contains(Projector::class.java)
            }

        fun getProjector(head: Location, target: Location): Projector {
            return getProjector(projectorType, head, target)
        }

        fun getProjector(type: String, head: Location, target: Location): Projector {
            val clazz = projectors.find {
                it.simpleName.removePrefix("Projector").endsWith(type, ignoreCase = true)
            }!!
            return clazz.invokeConstructor(head, target) as Projector
        }

    }

}