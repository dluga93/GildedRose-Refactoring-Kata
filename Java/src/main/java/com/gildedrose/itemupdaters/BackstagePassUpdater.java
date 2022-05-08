package com.gildedrose.itemupdaters;

import com.gildedrose.Item;

public class BackstagePassUpdater extends ItemUpdater {
    @Override
    protected int getDegradation(Item item) {
        if (item.sellIn > 10) {
            return -1;
        } else if (item.sellIn > 5) {
            return -2;
        } else if (item.sellIn > 0) {
            return -3;
        } else {
            return item.quality;
        }
    }
}
