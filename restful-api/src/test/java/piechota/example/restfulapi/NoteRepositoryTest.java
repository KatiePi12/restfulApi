package piechota.example.restfulapi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class NoteRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private NoteRepository noteRepository;

    @Test
    public void whenFindById_thenReturnNote() {
        Note note = new Note();
        note.setId(1);
        entityManager.persist(note);
        entityManager.flush();

        Note found = noteRepository.getOne(note.getId());

        assertThat(found.getId())
                .isEqualTo(note.getId());
    }
}