/*
 RoomBuilder By Hafsah
 This is where the rooms and puzzles are "built". Extendable/addable for custom riddles and rooms!
 */

import java.util.ArrayList;

public class RoomBuilderModel {

    public static ArrayList<RoomModel> buildRooms() {
        ArrayList<RoomModel> rooms = new ArrayList<>();

        // Room 1 - Entry Hall
        RoomModel room1 = new RoomModel("Entry Hall", "You are in a dimly lit entry hall. There's a keypad on the wall.", 1);
        ItemModel reward1 = new ItemModel("Key", "A rusty old key, maybe it opens a door.", true);
        PuzzleModel puzzle1 = new PuzzleModel(
                "riddle_1",
                "I brighten your path but am not the sun. With just a spark, my work is done. What am I?",
                "Match",
                reward1
        );
        room1.setPuzzle(puzzle1);
        rooms.add(room1);

        // Room 2 - Library
        RoomModel room2 = new RoomModel("Library", "Stacks of books surround you. There's a strange book with a lock.", 2);
        ItemModel reward2 = new ItemModel("Library Clue", "A torn page that might help later.", true);
        PuzzleModel puzzle2 = new PuzzleModel(
                "riddle_2",
                "The more you take, the more you leave behind. What am I?",
                "Footsteps",
                reward2
        );
        room2.setPuzzle(puzzle2);
        rooms.add(room2);

// Room 3 - Observatory
        RoomModel room3 = new RoomModel("Observatory", "A dome-like room with a massive telescope. The stars whisper secrets.", 3);
        ItemModel reward3 = new ItemModel("Starlit Note", "A piece of paper with constellations sketched on it.", true);
        PuzzleModel puzzle3 = new PuzzleModel(
                "riddle_3",
                "I’m always running but never move. I have hands but no arms. What am I?",
                "Clock",
                reward3
        );
        room3.setPuzzle(puzzle3);
        rooms.add(room3);

// Room 4 - Garden
        RoomModel room4 = new RoomModel("Garden", "An overgrown garden with twisted vines and glowing flowers.", 4);
        ItemModel reward4 = new ItemModel("Vine Key", "A delicate key hidden in the petals of a glowing flower.", true);
        PuzzleModel puzzle4 = new PuzzleModel(
                "riddle_4",
                "What can you break without touching it?",
                "Promise",
                reward4
        );
        room4.setPuzzle(puzzle4);
        rooms.add(room4);

        return rooms;


    }
}
