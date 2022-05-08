package net.testusuke.thealloutwar

import org.bukkit.Location

/**
 * Created by testusuke on 2022/05/06
 * @author testusuke
 */
data class Map(
    val id: Int,
    val name: String,
    val point_0: Location,
    val point_1: Location,
    val bases: ArrayList<Location>
)
