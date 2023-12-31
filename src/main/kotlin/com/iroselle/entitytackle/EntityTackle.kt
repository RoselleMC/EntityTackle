package com.iroselle.entitytackle

import com.iroselle.entitytackle.api.TackleAPI
import taboolib.common.platform.Plugin
import taboolib.common.platform.function.info
import taboolib.common.util.ResettableLazy
import taboolib.common.util.resettableLazy
import taboolib.library.xseries.XMaterial
import taboolib.module.configuration.Config
import taboolib.module.configuration.ConfigNode
import taboolib.module.configuration.Configuration
import taboolib.platform.util.ItemBuilder
import taboolib.platform.util.buildItem
import java.util.UUID

object EntityTackle : Plugin(), TackleAPI {

    @Config(autoReload = true)
    lateinit var config: Configuration

    @ConfigNode("projector-duration")
    var projectorDuration = 100

    @ConfigNode("projector-distance")
    var projectorDistance = 10

    @ConfigNode("projector-type")
    var projectorType = "Guardian"

    val catcherItem by resettableLazy("main") {
        buildItem(XMaterial.PLAYER_HEAD) {
            skullTexture = ItemBuilder.SkullTexture(config.getString("catcher-item.texture")!!, UUID.randomUUID())
            name = config.getString("catcher-item.name")
            lore.addAll(config.getStringList("catcher-item.lore"))
        }
    }

    override fun onEnable() {
        info("Successfully running ExamplePlugin!")

        config.onReload {
            ResettableLazy.reset("main")
        }
    }
}