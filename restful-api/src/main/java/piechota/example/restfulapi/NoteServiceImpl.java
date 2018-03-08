package piechota.example.restfulapi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    private NoteRepository noteRepository;

    @Autowired
    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public NoteServiceImpl() {
    }

    @Override
    public List<NoteDTO> findNoteByTitleAndReturnDTO(String title) {
        List<Note> notes = noteRepository.findByTitle(title);
        List<NoteDTO> noteDTOs = new ArrayList<>();
        notes.forEach(note -> noteDTOs.add(new NoteDTO(note)));
        return noteDTOs;
    }

    @Override
    public List<NoteDTO> findNoteByContentAndReturnDTO(String content) {
        List<Note> notes = noteRepository.findByContent(content);
        List<NoteDTO> noteDTOs = new ArrayList<>();
        notes.forEach(note -> noteDTOs.add(new NoteDTO(note)));
        return noteDTOs;
    }

    @Override
    public List<NoteDTO> findAllNotesAndReturnDTO() {
        List<Note> notes = noteRepository.findAll();
        List<NoteDTO> noteDTOs = new ArrayList<>();
        notes.forEach(note -> noteDTOs.add(new NoteDTO(note)));
        return noteDTOs;
    }

    @Override
    public NoteDTO addNoteAndReturnDTO(NoteDTO noteDTO) {
        if(noteDTO.getContent() != null && noteDTO.getTitle() != null) {
            Note note = new Note(noteDTO);
           noteRepository.save(note);
            return new NoteDTO(note);
        }
        return null;
    }

    @Override
    public NoteDTO updateNoteAndReturnDTO(NoteDTO noteDTO) {
        Note note = noteRepository.getOne(noteDTO.getId());
        note.setContent(noteDTO.getContent());
        note.setTitle(noteDTO.getTitle());
        noteRepository.save(note);
        return new NoteDTO(note);
    }

    @Override
    public NoteDTO deleteNoteAndReturnDTO(Integer id) {
        Note note = noteRepository.getOne(id);
        noteRepository.delete(note);
        return new NoteDTO(note);
    }
}
