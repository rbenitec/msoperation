package NTTDATA.msoperation.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Setter
@Getter
@ConfigurationProperties(prefix = "assurance-api")
public class AssuranceApiProperties {
    private String baseUrl;
}
