import java.util.ArrayList;
import java.util.List;


public class Room implements IGameEntity {
    private String name;
    private String description;

    private Room forward, back, left, right;

    private List<Item> items = new ArrayList<>();


    @Override
    public void describe() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setForward(Room forward) {
        this.forward = forward;
    }

    public void setBack(Room back) {
        this.back = back;
    }

    public void setLeft(Room left) {
        this.left = left;
    }

    public void setRight(Room right) {
        this.right = right;
    }
    public Room getConnectedRoom(String direction) {
        if(direction.equals("forward")) {
            return forward;
        } else if(direction.equals("back")){
            return back;
        } else if(direction.equals("left")) {
            return left;
        } else if(direction.equals("right")) {
            return right;
        } else {
            return null;
        }
    }

    public Item getItem(String ItemName) {
        for(Item item : items) {
            if(item.getName().equals(ItemName)) {
                return item;
            }

        }
        return null;
    }
    public void removeItem(Item item) {
        items.remove(item);
    }

}
