package com.iroselle.entitytackle.projector

import com.iroselle.entitytackle.EntityTackle.projectorDistance
import com.iroselle.entitytackle.EntityTackle.projectorDuration
import com.iroselle.entitytackle.api.projector.Projector
import fr.skytasul.guardianbeam.Laser.CrystalLaser
import org.bukkit.Location
import taboolib.platform.util.bukkitPlugin

class ProjectorCrystal(
    val head: Location,
    val target: Location
) : Projector {

    val laser = CrystalLaser(head, target, projectorDuration, projectorDistance)

    override fun start() {
        laser.start(bukkitPlugin)
    }

    override fun end() {
        laser.stop()
    }

}