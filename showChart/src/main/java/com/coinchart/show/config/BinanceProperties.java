package com.coinchart.show.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "binance.openapi")
public class BinanceProperties {

    private String apiKey;
    private String secretKey;

}
