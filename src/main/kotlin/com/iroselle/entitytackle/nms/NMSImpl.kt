package com.iroselle.entitytackle.nms

import net.minecraft.network.protocol.game.PacketPlayOutEntityDestroy
import net.minecraft.network.protocol.game.PacketPlayOutEntityMetadata
import net.minecraft.network.protocol.game.PacketPlayOutSpawnEntity
import net.minecraft.network.syncher.DataWatcher
import net.minecraft.world.entity.Entity
import net.minecraft.world.entity.EntityTypes
import net.minecraft.world.phys.Vec3D
import org.bukkit.Location
import org.bukkit.entity.EntityType
import org.bukkit.entity.Player
import taboolib.module.nms.sendPacket
import java.util.UUID

class NMSImpl : NMS() {
    override fun spawnEntity(player: Player, id: Int, type: EntityType, location: Location) {
        player.sendPacket(PacketPlayOutSpawnEntity(
            id,
            UUID.randomUUID(),
            location.x,
            location.y,
            location.z,
            location.yaw,
            location.pitch,
            type.asNMS(),
            0,
            Vec3D.ZERO,
            0.0
        ))
    }

    override fun destroyEntity(player: Player, id: Int) {
        player.sendPacket(PacketPlayOutEntityDestroy(id))
    }

    override fun updateEntityMetadata(player: Player, id: Int, vararg objects: Any) {
//        player.sendPacket(PacketPlayOutEntityMetadata(
//            id,
//            objects.map { it as DataWatcher.Item<*> }.toList()
//        ))
    }

    fun EntityType.asNMS(): EntityTypes<*> {
        return EntityTypes.byString(name).get()
    }
}