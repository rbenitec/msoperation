package NTTDATA.msoperation.service;

import NTTDATA.msoperation.redis.model.AssuranceCache;

import java.util.List;

public interface AssuranceService {
    List<AssuranceCache> getAll();
    //Metod que nos ayuda  crear una listado de los seguros
    String storageAssuranceList(List<AssuranceCache> assuranceCacheList);
}
