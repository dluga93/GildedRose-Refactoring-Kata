package com.gildedrose;

import com.gildedrose.itemupdaters.AgedBrieUpdater;
import com.gildedrose.itemupdaters.BackstagePassUpdater;
import com.gildedrose.itemupdaters.ConjuredItemUpdater;
import com.gildedrose.itemupdaters.ItemUpdater;
import com.gildedrose.itemupdaters.NormalItemUpdater;
import com.gildedrose.itemupdaters.SulfurasUpdater;

import java.util.Arrays;

public enum ItemType {
    NORMAL("", new NormalItemUpdater()),
    AGED_BRIE("Aged Brie", new AgedBrieUpdater()),
    BACKSTAGE_PASS("Backstage passes to a TAFKAL80ETC concert", new BackstagePassUpdater()),
    SULFURAS("Sulfuras, Hand of Ragnaros", new SulfurasUpdater()),
    CONJURED("Conjured.*", new ConjuredItemUpdater());

    private final String name;
    private final ItemUpdater itemUpdater;

    ItemType(String name, ItemUpdater itemUpdater) {
        this.name = name;
        this.itemUpdater = itemUpdater;
    }

    public static ItemType fromName(final String name) {
        return Arrays.stream(ItemType.values())
            .filter(itemType -> name.matches(itemType.name))
            .findAny()
            .orElse(NORMAL);
    }

    public ItemUpdater getUpdater() {
        return itemUpdater;
    }
}
