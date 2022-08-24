/*------------------------------------------------------------------------------
 -   Adapt is a Skill/Integration plugin  for Minecraft Bukkit Servers
 -   Copyright (c) 2022 Arcane Arts (Volmit Software)
 -
 -   This program is free software: you can redistribute it and/or modify
 -   it under the terms of the GNU General Public License as published by
 -   the Free Software Foundation, either version 3 of the License, or
 -   (at your option) any later version.
 -
 -   This program is distributed in the hope that it will be useful,
 -   but WITHOUT ANY WARRANTY; without even the implied warranty of
 -   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 -   GNU General Public License for more details.
 -
 -   You should have received a copy of the GNU General Public License
 -   along with this program.  If not, see <https://www.gnu.org/licenses/>.
 -----------------------------------------------------------------------------*/

package com.volmit.adapt.commands.openGui;

import com.volmit.adapt.commands.boost.CommandBoostPlayer;
import com.volmit.adapt.content.gui.SkillsGui;
import com.volmit.adapt.util.Command;
import com.volmit.adapt.util.MortarCommand;
import com.volmit.adapt.util.MortarSender;
import org.bukkit.Sound;

import java.util.List;

public class CommandOpenGui extends MortarCommand {
    @Command
    private CommandOpenGui player = new CommandOpenGui();

    public CommandOpenGui() {
        super("opengui", "gui");
    }

    @Override
    public boolean handle(MortarSender sender, String[] args) {
        sender.player().playSound(sender.player().getLocation(), Sound.ITEM_BOOK_PAGE_TURN, 1.1f, 0.72f);
        sender.player().playSound(sender.player().getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, 0.35f, 0.755f);
        SkillsGui.open(sender.player());
        return true;
    }

    @Override
    public void addTabOptions(MortarSender sender, String[] args, List<String> list) {

    }

    @Override
    protected String getArgsUsage() {
        return "";
    }
}
