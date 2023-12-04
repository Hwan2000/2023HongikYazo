package hongik.yazo.repository;

import hongik.yazo.domain.Work;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkRepository extends JpaRepository <Work, Integer>{
}
