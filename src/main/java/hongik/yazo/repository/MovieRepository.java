package hongik.yazo.repository;

import hongik.yazo.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, String> {
    List<Movie> findByWorkId(Integer workId);
}
