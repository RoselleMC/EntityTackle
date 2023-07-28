package com.iroselle.entitytackle.listener

import com.iroselle.entitytackle.EntityTackle
import com.iroselle.entitytackle.api.TackleAPI
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent
import taboolib.common.platform.event.SubscribeEvent

object PlayerListener {

    @SubscribeEvent
    fun e(e: PlayerInteractEvent) {
        e.item ?: return
        if (!(e.action == Action.RIGHT_CLICK_AIR || e.action == Action.RIGHT_CLICK_BLOCK)) {
            return
        }
        if (!e.item!!.isSimilar(EntityTackle.catcherItem)) {
            return
        }

        


    }

}