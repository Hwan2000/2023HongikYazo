package hongik.yazo.repository;

import hongik.yazo.domain.Work;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkRepository extends JpaRepository <Work, Integer>{
    @Override
    long count();
}
