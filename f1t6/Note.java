import lombok.NonNull;

import java.util.Date;
import java.util.Objects;

/**
 * Class represents a note that might be contained in the {@link Notebook} object.
 */
public class Note {
    /**
     * The note text.
     */
    private String text;
    /**
     * Date of the note creation.
     */
    private Date date;
    /**
     * The note author.
     */
    private String author;

    public Note(@NonNull String text, String author) {
        this.text = text;
        this.author = author;
        this.date = new Date();
    }

    @Override
    public String toString() {
        return author + "\n" +
                date + "\n" +
                text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return text.equals(note.text) &&
                date.equals(note.date) &&
                Objects.equals(author, note.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, date, author);
    }
}

