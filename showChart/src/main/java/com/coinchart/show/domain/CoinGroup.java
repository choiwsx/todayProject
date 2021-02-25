package com.coinchart.show.domain;

import java.util.List;

public class CoinGroup {

    private final List<Coin> list;

    public CoinGroup(final List<Coin> list)
    {
        this.list = list;
    }

    public List<Coin> getList() {return list;}

}
