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
import org.bukkit.event.player.PlayerMoveEvent
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import org.pixeltime.enchantmentsenhance.manager.IM
import org.pixeltime.enchantmentsenhance.manager.SettingsManager

class Saturation : Listener {
    @EventHandler
    fun onPalyerWalk(playerMoveEvent: PlayerMoveEvent) {
        val translateAlternateColorCodes = ChatColor.translateAlternateColorCodes('&', SettingsManager.lang.getString("enchantments." + "saturation"))
        val player = playerMoveEvent.player
        try {
            val level = IM.getHighestLevel(player, translateAlternateColorCodes)
            if (level > 0) {
                player.addPotionEffect(PotionEffect(PotionEffectType.SATURATION, Int.MAX_VALUE, SettingsManager.enchant.getInt("saturation.$level.potion_lvl") - 1))
            } else {
                player.removePotionEffect(PotionEffectType.SATURATION)
            }
        } catch (ex: Exception) {
        }
    }
}
