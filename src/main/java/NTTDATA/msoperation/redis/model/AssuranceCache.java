package NTTDATA.msoperation.redis.model;

import NTTDATA.msoperation.api.response.AssuranceResponse;
import lombok.*;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.math.BigDecimal;

@RedisHash("Assurance")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AssuranceCache implements Serializable {
    private String id;
    private BigDecimal minimumAmount;
    private BigDecimal maximumAmount;
    private BigDecimal price;

    public static AssuranceCache fromAssuranceResponse (AssuranceResponse assuranceResponse){
        return AssuranceCache.builder()
                .id(assuranceResponse.getId())
                .maximumAmount(assuranceResponse.getMaximumAmount())
                .minimumAmount(assuranceResponse.getMinimumAmount())
                .price(assuranceResponse.getPrice())
                .build();
    }
}
