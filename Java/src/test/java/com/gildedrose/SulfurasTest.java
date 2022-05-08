package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SulfurasTest {

    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    @Test
    void testSulfurasNoChange() {
        final int initialSellIn = 10;
        final int initialQuality = 10;

        Item updated = ItemTestUtil.updateSingleItem(SULFURAS, initialSellIn, initialQuality);

        assertEquals(initialSellIn, updated.sellIn);
        assertEquals(initialQuality, updated.quality);
    }
}
