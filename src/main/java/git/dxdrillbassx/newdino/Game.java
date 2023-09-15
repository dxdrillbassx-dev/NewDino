package git.dxdrillbassx.newdino;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private static final List<Game> gameList = new ArrayList<>();

    public static final Material jumpItem = Material.RED_CONCRETE;
    public static final Material sneakItem = Material.GREEN_CONCRETE;
    public static final Material dinoMaterialTop = Material.IRON_HELMET;
    public static final Material dinoMaterialBottom = Material.IRON_BOOTS;

    public static Game getGameOfAPlayer(Player player) {
        for (Game game: gameList) {
            if (game.player == player)
                return game;
        }

        return null;
    }

    private Inventory field;
    private Player player;

    private final int fieldSize = 54;
    private final Material ground = Material.GRASS_BLOCK;

    private int dinoTopPos;
    private int dinoBottomPos;

    public Game(Player player){
        field = Bukkit.createInventory(null, fieldSize);
        this.player = player;
        prepareField();
        dinoBottomPos = 37;
        dinoTopPos = 28;

        this.player.openInventory(field);
        gameList.add(this);
    }

    private void prepareField(){
        for (int i = 44; i < 54; i++){
            field.setItem(i, new ItemStack(ground));
        }

        field.setItem(37, new ItemStack(dinoMaterialBottom));
        field.setItem(28, new ItemStack(dinoMaterialTop));

        player.getInventory().setItem(27, new ItemStack(jumpItem));
        player.getInventory().setItem(28, new ItemStack(sneakItem));
    }

    public void jump(){
        new Thread(() -> {
            while (dinoTopPos > 9){
                moveOneFrame(true);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            while (dinoTopPos < 36){
                moveOneFrame(false);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    public void moveOneFrame(boolean isUp){
        field.setItem(dinoTopPos, new ItemStack(Material.AIR));
        field.setItem(dinoBottomPos, new ItemStack(Material.AIR));
        if (isUp) {
            dinoTopPos += 1;
            dinoBottomPos += 1;
        }
        else {
            dinoTopPos -= 1;
            dinoBottomPos -= 1;
        }
        field.setItem(dinoTopPos, new ItemStack(dinoMaterialTop));
        field.setItem(dinoTopPos, new ItemStack(dinoMaterialBottom));
    }
}
