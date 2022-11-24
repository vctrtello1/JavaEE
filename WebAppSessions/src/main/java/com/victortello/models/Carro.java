package com.victortello.models;

import java.util.ArrayList;
import java.util.List;

public class Carro {

    List<ItemCarro> items;

    public Carro() {
        this.items = new ArrayList<>();
    }

    public void addItemCarro(ItemCarro itemCarro) {
        this.items.add(itemCarro);

    }

    public List<ItemCarro> getItems() {
        return items;
    }

}
