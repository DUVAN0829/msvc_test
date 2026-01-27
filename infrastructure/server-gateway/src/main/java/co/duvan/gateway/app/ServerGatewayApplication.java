package co.duvan.gateway.app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.server.reactive.ServerHttpRequest;

import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
@Slf4j
public class ServerGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerGatewayApplication.class, args);
    }

    public static final String HEADER = "X-Correlation-Id";

    @Bean
    public GlobalFilter correlationFilter() {
        return (exchange, chain) -> {

            String correlationId = UUID.randomUUID().toString();

            log.info("[{}] Incoming request {}", correlationId,
                    exchange.getRequest().getURI());

            ServerHttpRequest request = exchange.getRequest()
                    .mutate()
                    .header(HEADER, correlationId)
                    .build();

            return chain.filter(exchange.mutate().request(request).build());
        };
    }

}
