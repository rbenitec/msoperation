package NTTDATA.msoperation.model;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
@Builder
public class Transaction implements Serializable {
    private String id;
    private String transactionType;
    private String bankAccountNumber;
    private String token;
    private boolean bankAssurance;
    private Long amount;
    private String serviceId;

}
