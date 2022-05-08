package com.gildedrose.itemupdaters;

import com.gildedrose.Item;

public class SulfurasUpdater extends ItemUpdater {

    @Override
    protected boolean hasLimitedMaxQuality() {
        return false;
    }

    @Override
    protected boolean hasToBeSold() {
        return false;
    }

    @Override
    protected int getDegradation(Item item) {
        return 0;
    }
}
