package piechota.example.restfulapi;
import java.util.List;

public interface NoteService {
    List<NoteDTO> findNoteByTitleAndReturnDTO(String title);
    List<NoteDTO> findNoteByContentAndReturnDTO(String content);
    List<NoteDTO> findAllNotesAndReturnDTO();
    NoteDTO addNoteAndReturnDTO(NoteDTO noteDTOs);
    NoteDTO updateNoteAndReturnDTO(NoteDTO noteDTO);
    NoteDTO deleteNoteAndReturnDTO(Integer id);
}
