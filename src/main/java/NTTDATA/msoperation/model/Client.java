package NTTDATA.msoperation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @NotBlank
    private String dni;

    @NotBlank
    private String name;

    private String email;

    private String phone;

    private String address;

    @NotBlank
    private String typeClient;

    private int operationId;
}
