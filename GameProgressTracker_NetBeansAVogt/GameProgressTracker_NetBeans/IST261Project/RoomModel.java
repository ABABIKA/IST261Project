// Noun - Room / Verb - Navigate / By Cody Impson
public class RoomModel {
    private String Name; // like room 1 or 2
    private String Description; // like basement or library
    private int id; // room id #

    //costructor to initialize
    public RoomModel(String name, String Description, int id) {
        this.Name = name;
        this.Description = Description;
        this.id = id;
    }
    //all the getter and setters:
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        this.Name = name;
    }
    public String getDescription() {
        return Description;
    }
    public void setDescription(String Description) {
        this.Description = Description;
    }
    public int getId() {
        return id;
    }
    //sets id for the room
    public void setId(int id) {
        this.id = id;
    }
    //action verb navigate or move to next room message
    public void navigate(RoomModel nextRoom) {
        System.out.println("Move" + this.Name + "to.nextRoom.getName()" + ".");
    }
    //prints info about the room
    public String toString(){
        return "Room:" + Name + Description +", Room ID:" + id;

    }

    private PuzzleModel puzzle;  // Add this field to the Room class

    public void setPuzzle(PuzzleModel puzzle) {
        this.puzzle = puzzle;
    }

    public PuzzleModel getPuzzle() {
        return this.puzzle;
    }

}
