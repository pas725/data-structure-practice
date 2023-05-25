package com.generics;

/**
 * Created by psagar on 3/27/2018.
 */
public class ItemService extends AbstractService<Item> {
    public ItemService(Item obj) {
        super(obj);
    }
}

class Item {
    private int id;
}