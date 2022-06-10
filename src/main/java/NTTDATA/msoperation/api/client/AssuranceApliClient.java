package NTTDATA.msoperation.api.client;

import NTTDATA.msoperation.api.response.AssuranceResponse;
import NTTDATA.msoperation.config.AssuranceApiProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
@RequiredArgsConstructor
public class AssuranceApliClient {
    private final WebClient webClient;
    private final AssuranceApiProperties assuranceApiProperties;

    //Metodo que nos permite obtener los Assurance activos.
    public List<AssuranceResponse> getActiveAssuranceList() throws InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        List<AssuranceResponse> result = new ArrayList<>();
        webClient.get().uri(assuranceApiProperties.getBaseUrl()+"/assurance/active")
                .accept(MediaType.TEXT_EVENT_STREAM)
                .retrieve()
                .bodyToFlux(AssuranceResponse.class)
                .publishOn(Schedulers.fromExecutor(executor))
                .subscribe(assuranceResponse -> result.add(assuranceResponse));

        executor.awaitTermination(1, TimeUnit.SECONDS);
        log.info("Assurance list "+ result);
        return result;
    }
}
