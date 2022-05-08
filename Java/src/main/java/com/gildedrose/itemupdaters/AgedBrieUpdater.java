package com.gildedrose.itemupdaters;

import com.gildedrose.Item;

public class AgedBrieUpdater extends ItemUpdater {
    private static final int DEGRADATION = -1;

    @Override
    protected int getDegradation(Item item) {
        if (item.sellIn > 0) {
            return DEGRADATION;
        } else {
            return 2 * DEGRADATION;
        }
    }
}
