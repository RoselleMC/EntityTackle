package com.iroselle.entitytackle.command

import com.iroselle.entitytackle.EntityTackle
import taboolib.common.platform.ProxyCommandSender
import taboolib.common.platform.command.*
import taboolib.common.platform.command.component.CommandComponent
import taboolib.common.platform.command.component.CommandComponentDynamic
import taboolib.common.platform.command.component.CommandComponentLiteral
import taboolib.expansion.createHelper
import taboolib.module.chat.colored

@CommandHeader(
    name = "EntityTackle",
    aliases = arrayOf("et", "ec", "ei")
)
object Command {

    @CommandBody
    val main = mainCommand {
        generateHelper()
    }

    @CommandBody
    val help = subCommand {
        generateHelper()
    }

    @CommandBody
    val list = subCommand {

    }

    @CommandBody
    val reload = subCommand {
        execute<ProxyCommandSender> { sender, _, _ ->
            EntityTackle.config.reload()
            sender.sendMessage("&eReloaded configs and other settings.".colored())
        }
    }

    /** TODO
     *
     * /<command> <args...>
     * - help
     * - list
     * - item
     * - reload
     * - about<?>
     *
     */
    fun CommandComponent.generateHelper() {
        execute<ProxyCommandSender> { sender, context, argument ->
            if (!sender.hasPermission(permission)) {
                sender.sendMessage("&cYou not have permission &e$permission".colored())
                return@execute
            }

            val command = context.command
            val builder = StringBuilder("\n&e/${context.args().joinToString(" ")}")

            children.filter { it is CommandComponentLiteral && sender.hasPermission(it.permission) }.forEach {
                it as CommandComponentLiteral
                builder.append("&7- &6${it.aliases[0]}${if (it.aliases.size > 1) "<${it.aliases.slice(1 until it.aliases.size).joinToString()}>" else ""}")
            }
            builder.append("")

            builder.lines().forEach {
                sender.sendMessage(it.colored())
            }
        }

    }

}