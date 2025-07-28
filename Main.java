/*
    Riddle Game - By Team/Group 5 of IST 261 - Cody Impson, Hafsah Bah, Aiden Acton, and Aeden Vogt
 */
/** PLEASE READ: This is not your typical program! The following will be highlighted:
 * Model class - Puzzle.java and Room.java for information, RoomBuilder.java has the ArrayList from these classes!
 * The data will be displayed/accessed when user is in a ROOM or accesses their INVENTORY.
 * Previous - "BACK" Button
 * Next - "NEXT" Button
 * Add - Add is achieved ONLY after SOLVING RIDDLES! The item will be added in an arrayList view of the user INVENTORY
 * Update - You cannot update Item descriptions in the user inventory itself, but the ArrayList of the INVENTORY is updated through add and delete
 * Delete - "DROP" Item. This will remove the item in the user INVENTORY
 * Quit - Quit and close the application
*/
public class Main {
    public static void main(String[] args) {
        GameController controller = new GameController();
        new StartView(controller);
    }
}
