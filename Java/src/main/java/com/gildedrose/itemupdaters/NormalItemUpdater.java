package com.gildedrose.itemupdaters;

import com.gildedrose.Item;

public class NormalItemUpdater extends ItemUpdater {
    protected static final int DAILY_DEGRADATION = 1;

    @Override
    protected int getDegradation(Item item) {
        if (item.sellIn > 0) {
            return DAILY_DEGRADATION;
        } else {
            return 2 * DAILY_DEGRADATION;
        }
    }
}
