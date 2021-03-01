package com.coinchart.show.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Builder
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Coin implements Serializable {

    private String symbol;
    private String price;

    @Override
    public String toString() {
        return "Coin{" +
                "symbol='" + symbol + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
