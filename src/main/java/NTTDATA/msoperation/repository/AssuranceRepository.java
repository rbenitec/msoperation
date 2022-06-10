package NTTDATA.msoperation.repository;

import NTTDATA.msoperation.redis.model.AssuranceCache;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.core.CrudMethods;
import org.springframework.stereotype.Repository;

@Repository
public interface AssuranceRepository extends CrudRepository<AssuranceCache, String> {
}
