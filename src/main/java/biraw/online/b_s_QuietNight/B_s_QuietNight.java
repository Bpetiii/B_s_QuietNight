package biraw.online.b_s_QuietNight;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class B_s_QuietNight extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(new MobSpawnListener(),this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
