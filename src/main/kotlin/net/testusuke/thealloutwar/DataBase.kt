package net.testusuke.thealloutwar

import net.testusuke.thealloutwar.Main.Companion.plugin
import java.sql.*


/**
 * Created by testusuke on 2022/04/29
 * @author testusuke
 */
class DataBase {

    //  Connection option
    private var host: String? = null
    private var user: String? = null
    private var pass: String? = null
    private var port: String? = null
    private var db: String? = null

    init {
        plugin.logger.info("DataBaseを読み込みます。")

        loadConfig()
        loadClass()
        testConnect()

        plugin.logger.info("DataBaseを読み込みました。")
    }

    private fun loadConfig() {
        host = plugin.config.getString("database.host")
        user = plugin.config.getString("database.user")
        pass = plugin.config.getString("database.pass")
        port = plugin.config.getString("database.port")
        db = plugin.config.getString("database.db")
    }

    private fun loadClass() {
        try {
            Class.forName("org.mariadb.jdbc.Driver")
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
            plugin.logger.info("DataBase connection class not found!")
        }
    }

    fun getConnection(): Connection? {
        return try {
            DriverManager.getConnection("jdbc:mariadb://$host:$port/$db", user, pass)
        } catch (e: SQLException) {
            e.printStackTrace()
            return null
        }
    }

    inline fun <R,T> query(sql: String, vararg params: T, run: ResultSet.() -> R) {
        getConnection()?.use { connection ->
            connection.prepareStatement(sql).use { statement ->
                params.forEachIndexed { index, param ->
                    statement.setString(index, param.toString())
                }
                statement.executeQuery().use(run)
            }
        }
    }

    //  todo useConnectionを廃止すればいけるかも？

    fun update(sql: String, vararg params: String): Int? {
        return getConnection()?.use main@ { connection ->
            connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS).use { statement ->
                params.forEachIndexed { index, option ->
                    statement.setString(index, option)
                }
                val r = statement.executeUpdate()
                if (r == 0) return@main null
                //  get index
                statement.generatedKeys.use { generatedKeys ->
                    if (!generatedKeys.next()) return@main null
                    return@main generatedKeys.getInt(1)
                }
            }
        }
    }

    fun execute(sql: String, vararg options: String): Boolean? {
        return getConnection()?.use main@ { connection ->
            //  execute
            connection.prepareStatement(sql).use { statement ->
                options.forEachIndexed { index, option ->
                    statement.setString(index, option)
                }
               return@main statement.execute()
            }
        }
    }

    private fun testConnect(): Boolean {
        plugin.logger.info("testing connection...")
        if (this.getConnection() == null) {
            plugin.logger.warning("failed to connect")
            return false
        }
        plugin.logger.info("succeeded to connect")
        return true
    }

}