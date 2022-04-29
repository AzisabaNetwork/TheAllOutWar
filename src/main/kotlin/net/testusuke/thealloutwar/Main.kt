package net.testusuke.thealloutwar

import org.bukkit.plugin.java.JavaPlugin

/**
 * Created by testusuke on 2022/04/26
 * @author testusuke
 */
class Main: JavaPlugin() {

    companion object {
        lateinit var plugin: Main
    }

    override fun onEnable() {
        plugin = this

        //  command
        getCommand("war")?.setExecutor(Command)
    }
}