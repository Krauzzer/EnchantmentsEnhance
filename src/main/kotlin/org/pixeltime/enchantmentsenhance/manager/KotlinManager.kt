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

package org.pixeltime.enchantmentsenhance.manager

import org.bukkit.Bukkit
import org.bukkit.inventory.ItemStack
import org.pixeltime.enchantmentsenhance.Main
import org.pixeltime.enchantmentsenhance.Main.getMain
import org.pixeltime.enchantmentsenhance.listener.VanillaEnchantHandler
import org.pixeltime.enchantmentsenhance.util.Util

class KM {
    companion object {
        @JvmStatic
        fun setUp() {
            getMain().logger.info("Kotlin module is enabled: Hello World!")
            MM.setup()
            EM.setUp()

            // Register kotlin module events.
            val pm = Bukkit.getPluginManager()
            pm.registerEvents(VanillaEnchantHandler(), Main.getMain())
        }

        @JvmStatic
        fun sortArray(a: IntArray) {
            a.sort()
        }

        @JvmStatic
        fun getLevel(lore: String, itemlore: List<String>): Int {
            itemlore.filter { it.contains(lore) }.forEach {
                var temp = it.split(" ")
                return (Util.romanToInt((temp)[temp.size - 1]))
            }
            return 0
        }

        @JvmStatic
        fun stripLore(item: ItemStack): List<String>? {
            if (item.hasItemMeta() && item.itemMeta.hasLore() && item.itemMeta.lore.isNotEmpty()) {
                val lores = item.itemMeta.lore
                return lores.filter { !it.startsWith(Util.UNIQUEID) }
            }
            return null
        }
    }
}