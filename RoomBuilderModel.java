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


// Room 5 - Basement
        RoomModel room5 = new RoomModel("Basement", "A cold, damp basement with flickering lights and distant echoes.", 5);
        ItemModel reward5 = new ItemModel("Worn Tape", "An old cassette tape labeled 'Do Not Listen'.", true);
        PuzzleModel puzzle5 = new PuzzleModel("riddle_5", "I’m tall when I’m young and short when I’m old. What am I?", "Candle", reward5);
        room5.setPuzzle(puzzle5);
        rooms.add(room5);

// Room 6 - Control Room
        RoomModel room6 = new RoomModel("Control Room", "Panels and blinking lights line the walls. A monitor displays static.", 6);
        ItemModel reward6 = new ItemModel("Override Chip", "A glowing chip labeled 'Emergency Access'.", true);
        PuzzleModel puzzle6 = new PuzzleModel("riddle_6", "I speak without a mouth and hear without ears. What am I?", "Echo", reward6);
        room6.setPuzzle(puzzle6);
        rooms.add(room6);

// Room 7 - The Vault
        RoomModel room7 = new RoomModel("Vault", "A heavy metal door stands sealed. The air is tense with silence.", 7);
        ItemModel reward7 = new ItemModel("Encrypted Scroll", "A scroll with symbols that shift when touched.", true);
        PuzzleModel puzzle7 = new PuzzleModel("riddle_7", "What has keys but can’t open locks?", "Piano", reward7);
        room7.setPuzzle(puzzle7);
        rooms.add(room7);

// Room 8 - Forgotten Study
        RoomModel room8 = new RoomModel("Forgotten Study", "Bookshelves tower to the ceiling. Dust swirls in the beam of a broken lamp.", 8);
        ItemModel reward8 = new ItemModel("Old Journal", "A cracked leather journal filled with scribbled entries.", true);
        PuzzleModel puzzle8 = new PuzzleModel("riddle_8", "What comes once in a minute, twice in a moment, but never in a thousand years?", "M", reward8);
        room8.setPuzzle(puzzle8);
        rooms.add(room8);

 // Room 9 - Medical Bay
        RoomModel room9 = new RoomModel("Medical Bay", "Sterile walls and old equipment remain. A faint mechanical hum can be heard.", 9);
        ItemModel reward9 = new ItemModel("Serum Vial", "A glowing vial with unreadable markings.", true);
        PuzzleModel puzzle9 = new PuzzleModel("riddle_9", "What can run but never walks, has a bed but never sleeps?", "River", reward9);
        room9.setPuzzle(puzzle9);
        rooms.add(room9);

 // Room 10 - The exit!
        RoomModel room10 = new RoomModel(
                "Exit Room",
                "A glowing panel awaits your final input. The air feels charged with anticipation.",
                10
        );
        ItemModel reward10 = new ItemModel(
                "Exit Code",
                "The final code that unlocks your way out.",
                true
        );
        PuzzleModel puzzle10 = new PuzzleModel(
                "riddle_10",
                "I have cities, but no houses. I have mountains, but no trees. I have water, but no fish. What am I?",
                "Map",
                reward10
        );
        room10.setPuzzle(puzzle10);
        rooms.add(room10);

        return rooms;
    }
}
