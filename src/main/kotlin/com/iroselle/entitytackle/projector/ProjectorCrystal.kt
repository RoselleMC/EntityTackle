package com.iroselle.entitytackle.projector

import com.iroselle.entitytackle.EntityTackle.laserDistance
import com.iroselle.entitytackle.EntityTackle.laserDuration
import com.iroselle.entitytackle.api.projector.Projector
import fr.skytasul.guardianbeam.Laser.CrystalLaser
import org.bukkit.Location
import taboolib.platform.util.bukkitPlugin

class ProjectorCrystal(
    val head: Location,
    val target: Location
) : Projector {

    val laser = CrystalLaser(head, target, laserDuration, laserDistance)

    override fun start() {
        laser.start(bukkitPlugin)
    }

    override fun end() {
        laser.stop()
    }

}