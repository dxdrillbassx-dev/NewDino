package git.dxdrillbassx.newdino.events;

import git.dxdrillbassx.newdino.Game;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class JumpEvent implements Listener {

    @EventHandler
    public void onJump(InventoryClickEvent event) {
        if (event.getCurrentItem().equals(new ItemStack(Game.jumpItem))){
            Game game = Game.getGameOfAPlayer((Player) event.getWhoClicked());
            if (game != null){
                game.jump();
            }
        }
    }
}
