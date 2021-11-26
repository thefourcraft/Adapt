package com.volmit.adapt.content.adaptation.discovery;

import com.volmit.adapt.api.adaptation.SimpleAdaptation;
import com.volmit.adapt.util.C;
import com.volmit.adapt.util.Element;
import com.volmit.adapt.util.Form;
import lombok.NoArgsConstructor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerExpChangeEvent;

public class DiscoveryUnity extends SimpleAdaptation<DiscoveryUnity.Config> {
    public DiscoveryUnity() {
        super("unity");
        registerConfiguration(Config.class);
        setDescription("Collecting Experience Orbs adds XP to random skills.");
        setIcon(Material.REDSTONE);
        setBaseCost(2);
        setInitialCost(10);
        setCostFactor(0.3);
        setMaxLevel(7);
    }

    @Override
    public void addStats(int level, Element v) {
        v.addLore(C.GREEN + "+ " + Form.f(getXPGained(getLevelPercent(level), 1), 0) + " XP " + C.GRAY + " Per Orb");
    }

    @EventHandler
    public void on(PlayerExpChangeEvent e) {
        if(e.getAmount() > 0 && getLevel(e.getPlayer()) > 0) {
            e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 1.9f);

            getPlayer(e.getPlayer()).boostXPToRandom(getPlayer(e.getPlayer()), e.getAmount() / 100D, 30000);
            getPlayer(e.getPlayer()).giveXPToRandom(getPlayer(e.getPlayer()), getXPGained(getLevelPercent(e.getPlayer()), e.getAmount()));
        }
    }

    private double getXPGained(double factor, int amount) {
        return amount * 32 * factor;
    }

    @Override
    public void onTick() {

    }

    @Override
    public boolean isEnabled() {
        return getConfig().enabled;
    }

    @NoArgsConstructor
    protected static class Config {
        boolean enabled = true;
    }
}