package net.testusuke.thealloutwar

import net.testusuke.thealloutwar.Main.Companion.dataBase
import net.testusuke.thealloutwar.Main.Companion.plugin
import org.bukkit.inventory.Inventory
import java.sql.SQLException

/**
 * Created by testusuke on 2022/05/02
 * @author testusuke
 */
object KitManager {

    fun createKit(name: String, inventory: Inventory): Int? {
        //  check if name is already existed
        if (getId(name) == null) return null
        //  convert
        val base64 = Base64Converter.toBase64(inventory) ?: return null
        //  commit
        return dataBase.insert("INSERT INTO kit (`name`, `data`) VALUES (?, ?)", name, base64)?.get(0)
    }

    fun deleteKit(id: Int): Boolean? {
        return dataBase.execute("DELETE FROM kit WHERE `id`=?", id)
    }

    fun updateKit(id: Int, inventory: Inventory): Boolean {
        //  convert
        val base64 = Base64Converter.toBase64(inventory) ?: return false
        //  commit
        return dataBase.update("UPDATE `kit` SET `data`=? WHERE `id`=? LIMIT 1", base64, id) == 1
    }

    fun getKit(id: Int): Kit? {
        dataBase.query("SELECT * FROM `kit` WHERE `id`=?", id) {
            if (!this.next()) return null
            try {
                return Kit(
                    id,
                    this.getString("name"),
                    this.getString("data")
                )
            } catch (e: SQLException) {
                plugin.logger.warning("failed to get kit due to something wrong. e:\n$e")
                return null
            }
        }
        return null
    }

    fun getKit(name: String): Kit? {
        val id = getId(name) ?: return null
        return getKit(id)
    }

    fun getName(id: Int): String? {
        dataBase.query("SELECT name FROM `kit` WHERE `id`=?", id) {
            if (!this.next()) return null
            try {
                return this.getString("name")
            } catch (e: SQLException) {
                plugin.logger.warning("failed to get kit's name due to something wrong. e:\n$e")
                return null
            }
        }
        return null
    }

    fun getId(name: String): Int? {
        dataBase.query("SELECT id FROM `kit` WHERE `name`=?", name) {
            if (!this.next()) return null
            try {
                return this.getInt("id")
            } catch (e: SQLException) {
                plugin.logger.warning("failed to get kit's name due to something wrong. e:\n$e")
                return null
            }
        }
        return null
    }

}