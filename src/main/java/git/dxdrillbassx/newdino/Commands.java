package git.dxdrillbassx.newdino;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Commands implements CommandExecutor {

    public Commands(Plugin plugin){
        plugin.getCommand("newdino").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            return false;
        }

        Player player = (Player) sender;

        if (args[0].equalsIgnoreCase("StartGame")){
            Game game = new Game(player);
            player.sendMessage("Успех!");
            return true;
        }

        return false;
    }
}
