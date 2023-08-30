package git.dxdrillbassx.newdino;

import org.bukkit.plugin.java.JavaPlugin;

public final class Plugin extends JavaPlugin {

    @Override
    public void onEnable() {
        new Commands(this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
