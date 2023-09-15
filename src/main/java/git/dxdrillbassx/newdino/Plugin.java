package git.dxdrillbassx.newdino;

import git.dxdrillbassx.newdino.events.JumpEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Plugin extends JavaPlugin {

    @Override
    public void onEnable() {
        new Commands(this);

        Bukkit.getPluginManager().registerEvents(new JumpEvent(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
