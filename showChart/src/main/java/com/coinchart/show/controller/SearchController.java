package com.coinchart.show.controller;


import com.coinchart.show.CoinService;
import com.coinchart.show.domain.Coin;
import com.coinchart.show.domain.CoinGroup;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

@RestController
@RequestMapping("/api/v1/search")
public class SearchController {

    private final CoinService coinService;

    public SearchController(CoinService coinService)
    {
        this.coinService = coinService;
    }

    @GetMapping("/coin")
    public List<Coin> getCoinByQuery(@RequestParam(name = "q") String query)
    {
        List<Coin> coinList = new ArrayList<>();

        coinList = coinService.search(query);
        CoinGroup searchCoin = new CoinGroup(coinList);
        return searchCoin.getList();
    }


}
