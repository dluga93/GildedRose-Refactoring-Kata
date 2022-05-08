package com.gildedrose.itemupdaters;

import com.gildedrose.Item;

public class ConjuredItemUpdater extends NormalItemUpdater {
    @Override
    protected int getDegradation(Item item) {
        return 2 * super.getDegradation(item);
    }
}
