package NTTDATA.msoperation.entity;

import lombok.*;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Operation {

    @Id
    private String id;
    private String type;
    private String description;
    private int userId;
}
