package NTTDATA.msoperation.service;


import NTTDATA.msoperation.model.BusinessCredit;
import NTTDATA.msoperation.model.Client;
import NTTDATA.msoperation.model.CurrentAccount;
import NTTDATA.msoperation.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OperationService {
    String processTransaction(Transaction transaction) throws InterruptedException;

    /*
    // Crear Clientes
    public Mono<Client> savedClient(String operationId,Client client);

    //Eliminar Clientes
    public Mono<Void> deleteClient(String clientId);

    // Crear BussinesCredit para un client
    public Mono<CurrentAccount> savedBusinessCredit(int clientId, CurrentAccount currentAccount);

    //Obtener todos los clientes desde operation response
    //Flux<Client> getAllClient();

    // Crear CreditCard
    // Crear CurrentAccount
    // Crear FixedTermAccount
    // Crear PersonalCredit
    // Crear SavingAccount

    // Eliminar Cuentas
//    Mono<Void> deleteAccount(String id);
    // Consultar Cuentas
//    Flux<BusinessCredit> getAllAccounts();
    // Actualizar Cuentas

    //Mostrar todas las cuentas de un cliente


     */
}
