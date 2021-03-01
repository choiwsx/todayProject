package com.coinchart.show.repository;

import com.coinchart.show.domain.Coin;

import java.util.List;

public interface CoinRepository {
    List<Coin> findByQuery(String symbol);
}
