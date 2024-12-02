package zero.weather_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zero.weather_app.domain.Memo;

@Repository
public interface JpaMemoRepository extends JpaRepository<Memo, Integer> {
}
