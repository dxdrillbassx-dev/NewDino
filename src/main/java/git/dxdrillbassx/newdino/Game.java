package git.dxdrillbassx.newdino;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Game {

    private Inventory field;
    private Player player;

    private final int fieldSize = 54;
    private final Material ground = Material.GRASS_BLOCK;

    public Game(Player player){
        field = Bukkit.createInventory(null, fieldSize);
        prepareField();
        this.player = player;

        this.player.openInventory(field);
    }

    private void prepareField(){
        for (int i = 44; i < 54; i++){
            field.setItem(i, new ItemStack(ground));
        }
    }
}
