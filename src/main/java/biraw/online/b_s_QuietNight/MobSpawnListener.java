package biraw.online.b_s_QuietNight;

import org.bukkit.entity.Creature;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

import java.util.List;

public class MobSpawnListener implements Listener
{
    private static final List<EntityType> darknessNeedingMobs = List.of(
            EntityType.SPIDER,EntityType.ZOMBIE,EntityType.CREEPER,
            EntityType.ZOMBIE_VILLAGER,EntityType.WITCH,EntityType.ENDERMAN,
            EntityType.CAVE_SPIDER,EntityType.HUSK,EntityType.SKELETON,
            EntityType.STRAY
            );

    @EventHandler
    private void MobSpawn(CreatureSpawnEvent event){
        // If the spawning is because natural reasons
        if (event.getSpawnReason() != CreatureSpawnEvent.SpawnReason.NATURAL) return;

        // And if the mob cannot spawn in light
        if (!darknessNeedingMobs.contains(event.getEntity().getType())) return;

        // And if the mob tries to spawn under the sky
        if (event.getLocation().getBlock().getLightFromSky() > 0)
        {
            event.setCancelled(true); // Cancel it
        }
                                      // Else just let it spawn
    }
}
