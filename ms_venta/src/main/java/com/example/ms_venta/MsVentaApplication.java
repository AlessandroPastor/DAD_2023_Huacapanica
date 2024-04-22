package com.example.ms_venta;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class MsVentaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsVentaApplication.class, args);
    }
    @Bean
    public OpenAPI custumOpenApi() {
        return new OpenAPI().info(new Info()
                .title("OPEN API MICROSERVICIO VENTA")
                .version("0.0.1")
                .description("servicio web ventas Repartidora Huacapanica")
                .termsOfService("http://swagger.io/terms")
                .license(new License().name("Apache 2.0").url("http://springdoc.org"))
        );
    }
}
