package zero.weather_app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import zero.weather_app.domain.Memo;
import zero.weather_app.repository.JdbcMemoRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
public class JdbcMemoRepositoryTest {
    @Autowired
    JdbcMemoRepository jdbcMemoRepository;

    @Test
    void insertMemoTest() {
        // given
        Memo newMemo = new Memo(1, "insertMemoTest");

        // when
        jdbcMemoRepository.save(newMemo);

        // then
        Optional<Memo> result = jdbcMemoRepository.findById(1);
        assertEquals(result.get().getText(), "insertMemoTest");
    }

    @Test
    void findAllMemoTest() {
        List<Memo> memoList = jdbcMemoRepository.findAll();
        System.out.println(memoList);
        assertNotNull(memoList);
    }
}
