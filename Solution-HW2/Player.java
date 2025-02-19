import java.util.ArrayList;
import java.util.List;


public class Player implements IGameEntity{
    private String name;
    private String description;
    private int health;
    private Room currentRoom;
    private List<Item> inventory = new ArrayList<>();
    private List<String> inventory_player;

    private List<Item> items = new ArrayList<>();



    public Player(Room startingRoom) {
        this.currentRoom = startingRoom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }


    public List<Item> getInventory() {
        return inventory;
    }

    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
    }

    public List<String> getInventory_player() {
        return inventory_player;
    }

    public void setInventory_player(List<String> inventory_player) {
        this.inventory_player = inventory_player;
    }

    @Override
    public void describe() {

    }
    public void showInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            System.out.println("You are carrying:");
            for (Item item : inventory) {
                System.out.println("- " + item.getName());
            }
        }
    }


    public void addItem(Item item) {
        items.add(item);
    }
}
