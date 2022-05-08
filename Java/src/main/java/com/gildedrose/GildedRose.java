package com.gildedrose;

import java.util.Arrays;
import java.util.List;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemType itemType = ItemType.fromName(item.name);
            itemType.getUpdater().update(item);
        }
    }

    public List<Item> getItems() {
        return Arrays.asList(items);
    }
}
