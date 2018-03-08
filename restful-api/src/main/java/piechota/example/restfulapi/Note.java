package piechota.example.restfulapi;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "public")
    @SequenceGenerator(name = "public", sequenceName = "note_id_sequence", initialValue = 1, allocationSize = 1)
    private Integer id;
    private String content;
    private String title;
    private Timestamp created;
    private Timestamp modified;

    public Note() {
    }

    public Note(NoteDTO noteDTO) {
        this.content = noteDTO.getContent();
        this.title = noteDTO.getTitle();
        this.created = noteDTO.getCreated();
        this.modified = noteDTO.getModified();
    }

    public Integer getId() {
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
