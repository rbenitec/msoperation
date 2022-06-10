package NTTDATA.msoperation.service.implement;

import NTTDATA.msoperation.redis.model.AssuranceCache;
import NTTDATA.msoperation.repository.AssuranceRepository;
import NTTDATA.msoperation.service.AssuranceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class AssuranceServiceImpl implements AssuranceService {

    private final AssuranceRepository assuranceRepository;

    @Override
    public List<AssuranceCache> getAll() {
        try{
            List<AssuranceCache> assuranceCacheList =  new ArrayList<>();
            assuranceRepository.findAll().forEach(assuranceCacheList::add);
            return assuranceCacheList;
        }catch (Exception e){
            log.error("Error while trying to get assurance from Redis cache. "+ e.getMessage());
            return Collections.EMPTY_LIST;
        }
    }

    @Override
    public String storageAssuranceList(List<AssuranceCache> assuranceCacheList) {
        try{
            Iterable<AssuranceCache> assuranceCachesIterable = assuranceCacheList;
            assuranceRepository.saveAll(assuranceCachesIterable);
            return "Assurance list create successfully";
        }catch (Exception e){
            return "Error saving assurance cache list. " + e.getMessage();
        }

    }
}
