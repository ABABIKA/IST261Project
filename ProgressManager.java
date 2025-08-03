// Author: Aeden Vogt
package gameprogresstracker;

import java.util.HashSet;

//This class uses HashSet to store tasks that the player has completed.
public class ProgressManager {
    private HashSet<Task> completedTasks;

    public ProgressManager() {
        completedTasks = new HashSet<>();
        //Add some test data
        completedTasks.add(new Task("Find the Key"));
        completedTasks.add(new Task("Enter Dungeon"));
    }

    public void addTask(Task task) {
        completedTasks.add(task); // Pseudocode: HashSet handles duplicates automatically
    }

    public boolean hasTask(Task task) {
        return completedTasks.contains(task);
    }

    public boolean removeTask(Task task) {
        return completedTasks.remove(task);
    }

    public HashSet<Task> getAllTasks() {
        return completedTasks;
    }
}