package hongik.yazo.repository;

import hongik.yazo.domain.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PhotoRepository extends JpaRepository<Photo, String> {
//    @Query("select p from Photo p where p.work.id =: workID")
//    List<Photo> findByWorkId(@Param("workID") Integer workID);
      List<Photo> findByWorkId(Integer workId);
      List<Photo> findByDetail(Integer detail);
}
