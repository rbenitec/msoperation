package NTTDATA.msoperation.service.implement;

import NTTDATA.msoperation.api.client.AssuranceApliClient;
import NTTDATA.msoperation.config.Util;
import NTTDATA.msoperation.model.Transaction;
import NTTDATA.msoperation.redis.model.AssuranceCache;
import NTTDATA.msoperation.service.AssuranceService;
import NTTDATA.msoperation.service.OperationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
@Slf4j
@Service
@RequiredArgsConstructor
public class OperationServiceImpl implements OperationService {
    private final AssuranceService assuranceService;
    private final AssuranceApliClient assuranceApliClient;

    @Override
    public String processTransaction(Transaction transaction) throws InterruptedException{
        if(transaction.getTransactionType().equals(Util.DRAFT_TRANSACTION)){
            if(assuranceService.getAll().isEmpty()){
                assuranceService.storageAssuranceList(
                        assuranceApliClient.getActiveAssuranceList()
                                .stream()
                                .map(AssuranceCache::fromAssuranceResponse)
                                .collect(Collectors.toList())
                );
                log.info(assuranceService.getAll().toString());
            }
            return "Processing Draft ...";
        }else{
            return "Processing "+ transaction.getTransactionType();
        }
    }

    /*
    private OperationRepository operationRepository;

    @Override
    public Mono<Client> savedClient(String operationId, Client client) {
        return operationRepository.saveClient(operationId,client);
    }

    @Override
    public Mono<Void> deleteClient(String clientId) {
        return operationRepository.deleteById(clientId);
    }

    @Override
    public Mono<CurrentAccount> savedBusinessCredit(int clientId, CurrentAccount currentAccount) {
        return operationRepository.saveCurrentAccount(clientId, currentAccount);
    }

     */

}
