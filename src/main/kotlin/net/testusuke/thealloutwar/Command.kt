package net.testusuke.thealloutwar

import net.testusuke.thealloutwar.HelpCommand.help
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

/**
 * Created by testusuke on 2022/04/29
 * @author testusuke
 */
object Command: CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) return true
        if (args.isEmpty()) return true

        when (args[0]) {
            //  help
            "help" -> help(sender)
        }
        return true
    }
}