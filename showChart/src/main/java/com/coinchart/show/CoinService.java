package com.coinchart.show;


import com.coinchart.show.domain.Coin;
import com.coinchart.show.domain.CoinGroup;
import com.coinchart.show.repository.CoinRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoinService {

    private final CoinRepository coinRepository;

    public CoinService(CoinRepository coinRepository)
    {
        this.coinRepository = coinRepository;
    }

    public List<Coin> search(final String query)
    {
        CoinGroup coinGroup = new CoinGroup(coinRepository.findByQuery(query));
        return coinGroup.getList();
    }




}
