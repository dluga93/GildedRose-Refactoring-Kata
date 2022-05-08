package com.gildedrose.itemupdaters;

import com.gildedrose.Item;

public abstract class ItemUpdater {
    protected static final int MIN_QUALITY = 0;
    protected static final int MAX_QUALITY = 50;

    public final void update(Item item) {
        updateQuality(item);
        updateSellInDate(item);

        if (hasLimitedMaxQuality() && item.quality > MAX_QUALITY) {
            item.quality = MAX_QUALITY;
        }

        if (item.quality < MIN_QUALITY) {
            item.quality = MIN_QUALITY;
        }
    }

    protected final void updateSellInDate(Item item) {
        if (hasToBeSold()) {
            item.sellIn--;
        }
    }

    protected boolean hasToBeSold() {
        return true;
    }

    protected final void updateQuality(Item item) {
        item.quality -= getDegradation(item);
    }

    protected abstract int getDegradation(Item item);

    protected boolean hasLimitedMaxQuality() {
        return true;
    }
}
