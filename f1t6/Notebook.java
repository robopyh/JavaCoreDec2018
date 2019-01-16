import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

/**
 * Class represents notebook. Contains an hashmap of notes.
 * Provides CRUD operations with {@link Note} objects.
 */
public class Notebook {
    private Map<Integer, Note> notes = new HashMap<>();
    private Integer id = 0;

    /**
     * Adds new note to the notebook.
     *
     * @param note new note
     * @return index of the note
     */
// Create
    public int addNote(@NonNull Note note) {
        notes.put(id, note);
        return id++;
    }

    /**
     * Shows all notes.
     */
// Read
    public void showAllNotes() {
        for (Map.Entry<Integer, Note> entry : notes.entrySet()) {
            Note note = entry.getValue();
            System.out.println(note.toString());
            System.out.println();
        }
    }

    /**
     * Replaces a note with the new one.
     *
     * @param noteIndex the note index
     * @param newNote   the new note
     */
// Update
    public void editNote(int noteIndex, Note newNote) {
        notes.put(noteIndex, newNote);
    }

    /**
     * Remove note from the list.
     *
     * @param noteIndex the note index
     */
// Delete
    public void removeNote(int noteIndex) {
        notes.remove(noteIndex);
    }
}

