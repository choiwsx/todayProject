package com.coinchart.show.repository;


import com.coinchart.show.config.BinanceProperties;
import com.coinchart.show.domain.Coin;
import com.coinchart.show.domain.ResponseCoin;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Component
//@JsonIgnoreProperties(ignoreUnknown = true)
public class CoinRepositoryImpl implements CoinRepository {

    private final RestTemplate restTemplate;
    private final BinanceProperties binanceProperties;

    @Autowired
    public CoinRepositoryImpl(RestTemplate restTemplate, BinanceProperties binanceProperties)
    {
        this.restTemplate = restTemplate;
        this.binanceProperties = binanceProperties;
    }


    @Override
    public List<Coin> findByQuery(String symbol) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-MBX-APIKEY", binanceProperties.getApiKey());
        String url="";
        if(symbol.equals(""))
            url = "https://api.binance.com/api/v3/ticker/price";
        else
            url = "https://api.binance.com/api/v3/ticker/price?symbol="+symbol;


        System.out.println(url);
        ResponseEntity<ResponseCoin> test = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity(httpHeaders), ResponseCoin.class);
        System.out.println(test.toString());
        System.out.println(test.getBody().toString());
        System.out.println(test.getBody().getData().toString());
        System.out.println(test.getBody().getData().stream().toString());
        return restTemplate.exchange(url, HttpMethod.GET, new HttpEntity(httpHeaders), ResponseCoin.class)
                .getBody()
                .getData()
                .stream()
                .map(m->Coin.builder()
                        .symbol(m.getSymbol())
                        .price(m.getPrice())
                        .build())
                .collect(Collectors.toList());
    }
}
