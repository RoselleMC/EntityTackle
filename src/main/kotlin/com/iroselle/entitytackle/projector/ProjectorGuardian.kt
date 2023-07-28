package com.iroselle.entitytackle.projector

import com.iroselle.entitytackle.EntityTackle
import com.iroselle.entitytackle.api.projector.Projector
import fr.skytasul.guardianbeam.Laser.GuardianLaser
import org.bukkit.Location
import taboolib.platform.util.bukkitPlugin

class ProjectorGuardian(
    val head: Location,
    val target: Location
) : Projector {

    val laser = GuardianLaser(head, target, EntityTackle.projectorDuration, EntityTackle.projectorDistance)

    override fun start() {
        laser.start(bukkitPlugin)
    }

    override fun end() {
        laser.stop()
    }

}