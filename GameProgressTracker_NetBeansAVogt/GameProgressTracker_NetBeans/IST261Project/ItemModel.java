// Noun - Item / Verb - Collect / By Cody Impson
public class ItemModel implements Printable {
    private String name; // This is the name of the item, "Key", "map", "etc"
    private String description; //This is what it looks like, color or shiny?
    private boolean isCollectible; // Only items with is isCollectible true

    //costructor to initialize
    public ItemModel(String Name, String Description, boolean isCollectible) {
        this.name = Name;
        this.description = Description;
        this.isCollectible = isCollectible;
    }
    //all the getter and setters:
    public String getName() {
        return name;
    }
    public void setName(String Name) {
        this.name = Name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String Description) {
        this.description = Description;
    }
    public boolean isCollectible() {
        return isCollectible;
    }
    public void setCollectible(boolean isCollectible) {
        this.isCollectible = this.isCollectible;
    }

    @Override
    public void printSetup() {//banner
        String banner = "************** ITEM **************";
    }
    public void print() {
        System.out.println("banner");
        System.out.println("Name: " + this.name);// I followed the video but not sure if correct-cody
    }

    //time for method of verb message
    public void collect() {
        if (isCollectible) {
            System.out.println(name + " was collected.");
        } else {
            System.out.println(name + " can't be collected.");
        }
    }
    //message with all thi info of the code for display
    public String toString() {
        return "Item: " + name + "," + description + ", collectible: "+ isCollectible;
    }
}
