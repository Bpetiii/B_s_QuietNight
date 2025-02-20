package biraw.online.b_s_QuietNight;

import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;


public class MobSpawnListener implements Listener
{

    @EventHandler
    private void MobSpawn(CreatureSpawnEvent event){
        // If the spawn location is in the OVERWORLD,
        if (event.getLocation().getWorld().getEnvironment() != World.Environment.NORMAL) return;

        // If the spawning is because natural reasons,
        if (event.getSpawnReason() != CreatureSpawnEvent.SpawnReason.NATURAL) return;

        // If the mob cannot spawn in light,
        if (!B_s_QuietNight.getMobs().contains(event.getEntity().getType())) return;

        // And if the mob tries to spawn under the sky
        if (event.getLocation().getBlock().getLightFromSky() > 0)
        {
            event.setCancelled(true); // Cancel it
        }
                                      // Else, just let it spawn
    }
}
