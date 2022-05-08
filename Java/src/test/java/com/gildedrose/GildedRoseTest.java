package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    private static final String AGED_BRIE = "Aged Brie";

    @Test
    void testMaxQualityFifty() {
        final int initialSellIn = 10;
        final int initialQuality = 50;

        Item updated = ItemTestUtil.updateSingleItem(AGED_BRIE, initialSellIn, initialQuality);

        final int expectedSellIn = initialSellIn - 1;

        assertEquals(expectedSellIn, updated.sellIn);
        assertEquals(initialQuality, updated.quality);
    }

}
