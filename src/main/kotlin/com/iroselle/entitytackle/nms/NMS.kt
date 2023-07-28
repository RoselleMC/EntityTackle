package com.iroselle.entitytackle.nms

import org.bukkit.Location
import org.bukkit.entity.EntityType
import org.bukkit.entity.Player
import taboolib.module.nms.nmsProxy

abstract class NMS {

    abstract fun spawnEntity(player: Player, id: Int, type: EntityType, location: Location)

    abstract fun destroyEntity(player: Player, id: Int)

    abstract fun updateEntityMetadata(player: Player, id: Int, vararg objects: Any)

    companion object {
        val nms by lazy { nmsProxy<NMS>() }
    }
}