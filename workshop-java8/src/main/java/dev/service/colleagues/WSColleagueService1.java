package dev.service.colleagues;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class WSColleagueService1 {

    public static final String BASE_URL = "https://c1.cleverapps.io/collegues";
    private final WebClient webClient;

    public WSColleagueService1(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(BASE_URL).build();
    }

    public Flux<WSColleague> findAll() {
        return  this.webClient.get()
                .retrieve()
                .bodyToFlux(WSColleague.class)
                .share();

    }
}
