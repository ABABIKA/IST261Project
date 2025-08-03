// Author: Aeden Vogt
package gameprogresstracker;

// his class represents a puzzle/room/task the player interacts with.
public class Task {
    private String name;

    public Task(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    //Override equals and hashCode so HashSet can compare tasks by name.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Task task = (Task) obj;
        return name.equalsIgnoreCase(task.name);
    }

    @Override
    public int hashCode() {
        return name.toLowerCase().hashCode();
    }

    @Override
    public String toString() {
        return "Task: " + name;
    }
}