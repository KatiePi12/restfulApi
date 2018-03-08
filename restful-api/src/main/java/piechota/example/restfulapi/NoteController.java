package piechota.example.restfulapi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class NoteController {

    private NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping(value = "note/byTitle/{title}")
    public ResponseEntity<List<NoteDTO>> getNoteByTitle(@PathVariable String title) {
        List<NoteDTO> noteDTOs = noteService.findNoteByTitleAndReturnDTO(title);
        if(noteDTOs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(noteDTOs, HttpStatus.OK);
    }

    @GetMapping(value = "note/byContext/{context}")
    public ResponseEntity<List<NoteDTO>> getNoteByContext(@PathVariable String context) {
        List<NoteDTO> noteDTOs = noteService.findNoteByContentAndReturnDTO(context);
        if(noteDTOs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(noteDTOs, HttpStatus.OK);
    }

    @GetMapping(value = "/getAllNotes")
    public ResponseEntity<List<NoteDTO>> getAllNotes() {
        List<NoteDTO> noteDTOs = noteService.findAllNotesAndReturnDTO();
        if(noteDTOs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(noteDTOs, HttpStatus.OK);
    }

    @PostMapping(value = "/addNote")
    public ResponseEntity<NoteDTO> createNewNote(@RequestBody NoteDTO noteDTO) {
        NoteDTO createdNodeDTO = noteService.addNoteAndReturnDTO(noteDTO);
        if(createdNodeDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(createdNodeDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/updateNote")
    public ResponseEntity<NoteDTO> updateNote(@RequestBody NoteDTO noteDTO) {
        NoteDTO updatedNoteDTO = noteService.updateNoteAndReturnDTO(noteDTO);
        if(updatedNoteDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(updatedNoteDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteNote/{id}")
    public ResponseEntity<NoteDTO> deleteNote(@PathVariable Integer id) {
        NoteDTO deletedNote = noteService.deleteNoteAndReturnDTO(id);
        if(deletedNote == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(deletedNote, HttpStatus.OK);
    }
}
