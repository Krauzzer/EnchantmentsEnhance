/*
 *     Copyright (C) 2017-Present HealPotion
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 *
 */

package org.pixeltime.enchantmentsenhance.event.enchantment

import org.bukkit.ChatColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent
import org.pixeltime.enchantmentsenhance.manager.IM
import org.pixeltime.enchantmentsenhance.manager.SettingsManager

private val translateAlternateColorCodes: String = ChatColor.translateAlternateColorCodes('&', SettingsManager.lang.getString("enchantments." + "aegis"))

class Aegis : Listener {
    @EventHandler
    fun block(playerInteractEvent: PlayerInteractEvent) {
        val player = playerInteractEvent.player
        if (playerInteractEvent.action != Action.RIGHT_CLICK_AIR) {
            return
        }
        try {
            val level = IM.getHighestLevel(player, translateAlternateColorCodes)
            if (level > 0 && (Math.random() * 100.0).toInt() < SettingsManager.enchant.getInt("aegis.$level.chance")) {
                player.health += SettingsManager.enchant.getDouble("aegis.$level.health")
            }
        } catch (ex: Exception) {
        }
    }
}
