package git.dxdrillbassx.newdino;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Game {

    public static final Material jumpItem = Material.RED_CONCRETE;
    public static final Material sneakItem = Material.GREEN_CONCRETE;
    public static final Material dinoMaterial = Material.BLACK_WOOL;

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

        player.getInventory().setItem(0, new ItemStack(jumpItem));
        player.getInventory().setItem(1, new ItemStack(sneakItem));
    }
}
