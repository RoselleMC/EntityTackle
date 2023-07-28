package com.iroselle.entitytackle.listener

import com.iroselle.entitytackle.EntityTackle
import com.iroselle.entitytackle.EntityTackle.projectorDistance
import com.iroselle.entitytackle.EntityTackle.projectorDuration
import com.iroselle.entitytackle.api.TackleAPI
import com.iroselle.entitytackle.api.projector.Projector
import com.iroselle.entitytackle.api.util.toProgress
import org.bukkit.Bukkit
import org.bukkit.Color
import org.bukkit.boss.BarColor
import org.bukkit.boss.BarStyle
import org.bukkit.entity.Player
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent
import taboolib.common.platform.event.SubscribeEvent
import taboolib.common.platform.function.submit
import taboolib.common.util.sync
import taboolib.platform.util.asLangText
import taboolib.platform.util.sendLang
import java.util.function.Predicate

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
        e.item!!.amount--

        val rayTrace = sync {
            e.player.world.rayTraceEntities(
                e.player.location,
                e.player.location.direction,
                projectorDistance.toDouble(),
                1.0
            ) { it !is Player }
        } ?: return

        e.player.sendLang("catcher-start")

        val choose = rayTrace.hitEntity ?: return
        val projector = Projector.getProjector(e.player.location, choose.location)
        projector.start()

        val bar = Bukkit.createBossBar(
            e.player.asLangText("catcher-progress-bossbar", choose.type.name),
            BarColor.BLUE,
            BarStyle.SOLID
        )
        bar.addPlayer(e.player)
        bar.progress = 0.0

        fun success() {
            bar.removeAll()
            projector.end()
            e.player.sendLang("catcher-to-egg")
        }

        fun failed() {
            bar.removeAll()
            projector.end()
            e.player.sendLang("catcher-failed")
        }

        var tick = 0
        submit(
            async = true,
            period = 5L
        ) {
            if (tick >= projectorDuration) {
                success()
                cancel()
                return@submit
            }
            bar.progress = toProgress(tick, projectorDuration)
            val entity = sync {
                e.player.world.rayTraceEntities(
                    e.player.location,
                    e.player.location.direction,
                    projectorDistance.toDouble(),
                    1.25
                ) { it !is Player }
            }?.hitEntity ?: return@submit

            if (choose != entity) {
                failed()
                cancel()
                return@submit
            }

            tick++
        }
    }

}