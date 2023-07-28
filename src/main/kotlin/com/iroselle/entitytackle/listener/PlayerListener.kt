package com.iroselle.entitytackle.listener

import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent
import taboolib.common.platform.event.SubscribeEvent

object PlayerListener {

    @SubscribeEvent
    fun e(e: PlayerInteractEvent) {
        if (!(e.action == Action.RIGHT_CLICK_AIR || e.action == Action.RIGHT_CLICK_BLOCK)) {
            return
        }
        e.item


    }

}