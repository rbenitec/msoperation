package NTTDATA.msoperation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FixedTermAccount {
    private String nroAccount;
    private double availableBalance;
    private String typeCredit;         // Peronal o empresarial
    private int limit=1;            // Sin limites de movimientos
    private int clientId;
    private int managementId;
}
