package piechota.example.restfulapi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface NoteRepository extends JpaRepository<Note, Integer> {
    List <Note> findByTitle(String title);
    List <Note> findByContent(String content);
}
