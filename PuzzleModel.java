/** By Aeden V
 * The Puzzle class is basically a challenge in a room that the player needs to figure out.
 * It holds info about what the puzzle is, what the correct answer is, and if it's already solved.
 * Now includes a reward item for solving it!
 */
public class PuzzleModel {
    private String puzzleID;          // A unique name for this puzzle, like "riddle_door"
    private String puzzleDescription; // What the player reads to try and solve it
    private String solution;          // The secret code or answer that unlocks it
    private boolean isSolved;         // True if the puzzle is done, false if it's still a mystery
    private ItemModel reward;              // The item rewarded for solving the puzzle

    // Making a new puzzle:
    public PuzzleModel(String puzzleID, String puzzleDescription, String solution, ItemModel reward) {
        this.puzzleID = puzzleID;
        this.puzzleDescription = puzzleDescription;
        this.solution = solution;
        this.reward = reward;
        this.isSolved = false; // Always starts unsolved, gotta earn that win!
    }

    // Getters and setters for puzzle details:
    public String getPuzzleID() {
        return puzzleID;
    }

    public void setPuzzleID(String puzzleID) {
        this.puzzleID = puzzleID;
    }

    public String getPuzzleDescription() {
        return puzzleDescription;
    }

    public void setPuzzleDescription(String puzzleDescription) {
        this.puzzleDescription = puzzleDescription;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public boolean isSolved() {
        return isSolved;
    }

    public ItemModel getReward() {
        return reward;
    }

    public void setReward(ItemModel reward) {
        this.reward = reward;
    }

    // This method lets the player "solve" the puzzle
    public boolean attemptSolve(String playerAttempt) {
        if (isSolved) {
            System.out.println("Puzzle '" + puzzleID + "' is already solved. Good job!");
            return true; // Already done, nothing to do here
        } else if (playerAttempt.equalsIgnoreCase(solution)) {
            this.isSolved = true; // Mark it as solved!
            System.out.println("Puzzle '" + puzzleID + "' solved! You got it!");
            return true;
        } else {
            System.out.println("Incorrect attempt for puzzle '" + puzzleID + "'. Try again!");
            return false;
        }
    }

    // Quick text summary of the puzzle
    @Override
    public String toString() {
        return "Puzzle ID: " + puzzleID + "\n" +
                "Description: " + puzzleDescription + "\n" +
                "Solved: " + isSolved;
    }
}
