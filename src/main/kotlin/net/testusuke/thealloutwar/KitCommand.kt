package net.testusuke.thealloutwar

import org.bukkit.entity.Player

/**
 * Created by testusuke on 2022/04/29
 * @author testusuke
 */
object KitCommand {

    fun onCommand(player: Player, args: Array<out String>) {
        //  Permission
        if (!player.hasPermission(Permission.KIT_GENERAL)) {
            player.sendMessage(Message.PERMISSION_ERROR)
            return
        }

        if (args.isEmpty()) {
            player.sendHelp()
            return
        }

        //  kit name
        val name = args[1]

        when (args[0]) {
            "list" -> {
                var msg = "§e=================キット一覧================="
                val kitList = KitManager.list()
                kitList.forEach {
                    msg += "\n${it.name}"
                }
                player.sendMessage(msg)
            }

            "create" -> {
                if (name.isEmpty()) {
                    player.sendMessage(Message.INCORRECT_COMMAND_USAGE)
                    return
                }
                //  check if kit is already existed
                if (KitManager.getId(name) != null) {
                    player.sendMessage(Message.KIT_ALREADY_EXISTED)
                    return
                }

                //  inventory
                val inv = player.inventory

                //  create
                val id = KitManager.createKit(name, inv)
                if (id == null) {
                    player.sendMessage(Message.DATABASE_ERROR)
                    return
                }

                player.sendMessage(
                    Message.KIT_SUCCESS_CREATING.replace("#0", name)
                )
            }

            "delete" -> {
                if (name.isEmpty()) {
                    player.sendMessage(Message.INCORRECT_COMMAND_USAGE)
                    return
                }
                //  check if kit is existed
                val id = KitManager.getId(name)
                if (id == null) {
                    player.sendMessage(Message.KIT_NOT_EXISTED)
                    return
                }

                //  delete
                val result = KitManager.deleteKit(id) ?: false
                if (!result){
                    player.sendMessage(Message.DATABASE_ERROR)
                    return
                }

                player.sendMessage(Message.KIT_SUCCESS_DELETING)
            }

            "update" -> {
                if (name.isEmpty()) {
                    player.sendMessage(Message.INCORRECT_COMMAND_USAGE)
                    return
                }
                //  check if kit is existed
                val id = KitManager.getId(name)
                if (id == null) {
                    player.sendMessage(Message.KIT_NOT_EXISTED)
                    return
                }

                val inv = player.inventory
                //  update
                if (!KitManager.updateKit(id, inv)) {
                    player.sendMessage(Message.DATABASE_ERROR)
                    return
                }
                player.sendMessage(Message.KIT_SUCCESS_UPDATING)
            }

            "show" -> {

            }

            else -> {
                player.sendMessage(Message.INCORRECT_COMMAND_USAGE)
            }
        }
    }

    private fun Player.sendHelp() {
        val msg = """
            
        """.trimIndent()
        this.sendMessage(msg)
    }

}