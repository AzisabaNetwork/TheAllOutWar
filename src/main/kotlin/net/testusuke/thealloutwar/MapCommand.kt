package net.testusuke.thealloutwar

import org.bukkit.entity.Player

/**
 * Created by testusuke on 2022/05/07
 * @author testusuke
 */
object MapCommand {
    
    fun onCommand(player: Player, args: Array<out String>) {
        //  Permission
        if (!player.hasPermission(Permission.MAP_GENERAL)) {
            player.sendMessage(Message.PERMISSION_ERROR)
            return
        }

        if (args.isEmpty()) {
            player.sendMessage(Message.INCORRECT_COMMAND_USAGE)
            return
        }

        when (args[0]) {
            "create" -> {

            }

            "delete" -> {

            }
        }
    }
}