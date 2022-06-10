package NTTDATA.msoperation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessCredit {

    private String nroAccount;
    private double availableBalance;
    private int limit;
    private int clientId;
    private int managementId;
}
