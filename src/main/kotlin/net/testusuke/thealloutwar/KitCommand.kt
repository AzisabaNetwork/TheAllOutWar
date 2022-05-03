package net.testusuke.thealloutwar

import org.bukkit.Bukkit
import org.bukkit.entity.Player

/**
 * Created by testusuke on 2022/04/29
 * @author testusuke
 */
object KitCommand {

    fun onCommand(player: Player, args: Array<out String>) {
        if (args.isEmpty()) {
            player.sendMessage("§c構文が不正です。ヘルプを参照してください")
            return
        }

        when (args[0]) {
            "list" -> {

            }

            "create" -> {

            }

            "delete" -> {

            }

            "update" -> {

            }
        }
    }
}