package piechota.example.restfulapi;

import java.sql.Timestamp;

public class NoteDTO {
    private int id;
    private String content;
    private String title;
    private Timestamp created;
    private Timestamp modified;

    public NoteDTO() {
    }

    public NoteDTO(Note note) {
        this.id = note.getId();
        this.content = note.getContent();
        this.title = note.getTitle();
        this.created = note.getCreated();
        this.modified =  note.getModified();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getModified() {
        return modified;
    }

    public void setModified(Timestamp modified) {
        this.modified = modified;
    }
}
