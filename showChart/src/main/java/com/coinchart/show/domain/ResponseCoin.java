package com.coinchart.show.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseCoin{

    private List<Data> data;

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Data{
        private String symbol;
        private String price;

        @Override
        public String toString() {
            return "Item{" +
                    "symbol='" + symbol + '\'' +
                    ", price='" + price + '\'' +
                    '}';
        }
    }


}


