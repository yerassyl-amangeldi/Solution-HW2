import java.util.Scanner;

public class MUDController {
    private final Player player;
    private boolean running = true;
    private final Scanner scanner = new Scanner(System.in);

    public MUDController(Player player) {
        this.player = player;
    }

    public void runGameLoop() {
        System.out.println("Welcome!");
        while (running) {
            System.out.print("> ");
            handleInput(scanner.nextLine());
        }
    }

    private void handleInput(String input) {
        if (input.isEmpty()) {
            return;
        }

        String[] words = input.split(" ");
        String command = words[0].toLowerCase();
        String argument = "";

        if (words.length > 1) {
            argument = input.substring(command.length()).trim();
        }


        if (command.equals("look")) {
            lookAround();
        } else if (command.equals("move")) {
            move(argument);
        } else if (command.equals("pick")) {
            if (argument.startsWith("up ")) {
                pickUp(argument.substring(3));
            } else {
                System.out.println("Invalid command. Try again");
            }
        } else if (command.equals("inventory")) {
            player.showInventory();
        } else if (command.equals("help")) {
            showHelp();
        } else if (command.equals("quit") || command.equals("exit")) {
            exitGame();
        } else {
            System.out.println("Unknown command.");
        }
    }


    private void lookAround() {
        System.out.println(player.getCurrentRoom());
    }

    private void move(String direction) {
        Room nextRoom = player.getCurrentRoom().getConnectedRoom(direction);
        if (nextRoom != null) {
            player.setCurrentRoom(nextRoom);
            System.out.println("You move " + direction + ".");
            lookAround();
        } else {
            System.out.println("You can't go");
        }
    }

    private void pickUp(String itemName) {
        if (itemName.isEmpty()) {
            System.out.println("Invalid command.");
            return;
        }
        Room currentRoom = player.getCurrentRoom();
        Item item = currentRoom.getItem(itemName);
        if (item != null) {
            player.addItem(item);
            currentRoom.removeItem(item);
            System.out.println("You picked up " + itemName + ".");
        } else {
            System.out.println("No item named '" + itemName + "' here!");
        }
    }

    private void showHelp() {
        System.out.println("Commands: ...");
    }

    private void exitGame() {
        running = false;
        System.out.println("Exiting game.");
    }
}
