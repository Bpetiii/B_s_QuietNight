package biraw.online.b_s_QuietNight;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.plugin.java.JavaPlugin;
import de.leonhard.storage.Config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public final class B_s_QuietNight extends JavaPlugin {

    private final Config config = new Config("config", this.getDataFolder().getPath());

    private static ArrayList<EntityType> darknessNeedingMobs = new ArrayList<>(Arrays.asList(
            EntityType.SPIDER, EntityType.ZOMBIE, EntityType.CREEPER,
            EntityType.ZOMBIE_VILLAGER, EntityType.WITCH, EntityType.ENDERMAN,
            EntityType.CAVE_SPIDER, EntityType.HUSK, EntityType.SKELETON,
            EntityType.STRAY, EntityType.BOGGED
    ));

    private static ArrayList<World> worlds = new ArrayList<>();


    public static ArrayList<EntityType> getMobs() {
        return darknessNeedingMobs;
    }
    public static ArrayList<World> getWorlds() {
        return worlds;
    }

    private static ArrayList<String> getMobNames() {
        ArrayList<String> names = new ArrayList<>();

        darknessNeedingMobs.forEach(type->{
            names.add(type.name());
        });

        return names;
    }

    private static ArrayList<String> getWorldNames() {
        ArrayList<String> names = new ArrayList<>();

        worlds.forEach(world->{
            names.add(world.getName());
        });

        return names;
    }

    @Override
    public void onEnable() {

        // Get mobs from config
        List<String> mob_names = config.getOrSetDefault("MOBS",getMobNames());

        darknessNeedingMobs.clear();

        mob_names.forEach(name->{
            try{
                darknessNeedingMobs.add(EntityType.valueOf(name.strip()));
            }
            catch (Exception ignored) {
                this.getLogger().severe(name + " is an invalid mob name!");
            }
        });

        Bukkit.getWorlds().forEach(world -> {
            if (world.getEnvironment() == World.Environment.NORMAL ||
                    world.getEnvironment() ==  World.Environment.CUSTOM)
            {
                worlds.add(world);
            }
        });

        // Get worlds from config
        List<String> world_names = config.getOrSetDefault("WORLDS",getWorldNames());

        worlds.clear();

        world_names.forEach(name->{
            if (Bukkit.getWorld(name) != null){
                worlds.add(Bukkit.getWorld(name));
            }else{
                this.getLogger().severe(name + " is an invalid world name!");
            }
        });

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
