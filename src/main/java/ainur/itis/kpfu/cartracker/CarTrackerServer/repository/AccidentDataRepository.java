package ainur.itis.kpfu.cartracker.CarTrackerServer.repository;


import ainur.itis.kpfu.cartracker.CarTrackerServer.domain.AccidentData;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccidentDataRepository extends CrudRepository<AccidentData, Long> {

    public boolean existsByYearEquals(Integer year);

    @Query("select count(a) from AccidentData a where " +
            "a.latitude between :minX and :maxX and " +
            "a.longitude between :minY and :maxY")
    public Long findAccidentDataInLine(@Param("minX") Double minX, @Param("maxX") Double maxX,
                                      @Param("minY") Double minY, @Param("maxY") Double maxY);
}
