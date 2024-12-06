package biraw.online.b_s_QuietNight;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class B_s_QuietNight extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new MobSpawnListener(),this);

        // Print the motd
        this.getLogger().info(" ");
        this.getLogger().info("O=========================================================O");
        this.getLogger().info("   The B's B's QuietNight plugin has loaded successfully");
        this.getLogger().info("        This is B's QuietNight for Minecraft 1.18 +");
        this.getLogger().info("                       Author: BiRaw");
        this.getLogger().info("         Discord: https://discord.gg/XwFqu7uahX :>");
        this.getLogger().info("O=========================================================O");
        this.getLogger().info(" ");
    }
}
