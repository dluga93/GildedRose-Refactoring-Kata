package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgedBrieTest {

    private static final String AGED_BRIE = "Aged Brie";

    @Test
    void testAgedBrieIncreasesInQualityBeforeSellInDate() {
        final int initialSellIn = 10;
        final int initialQuality = 10;

        Item updated = ItemTestUtil.updateSingleItem(AGED_BRIE, initialSellIn, initialQuality);

        final int expectedSellIn = initialSellIn - 1;
        final int currentQuality = updated.quality;

        assertEquals(expectedSellIn, updated.sellIn);
        assertEquals(initialQuality + 1, currentQuality);
    }

    @Test
    void testAgedBrieIncreasesInQualityAfterSellInDate() {
        final int initialSellIn = 0;
        final int initialQuality = 10;

        Item updated = ItemTestUtil.updateSingleItem(AGED_BRIE, initialSellIn, initialQuality);

        final int expectedSellIn = initialSellIn - 1;
        final int currentQuality = updated.quality;

        assertEquals(expectedSellIn, updated.sellIn);
        assertEquals(initialQuality + 2, currentQuality);
    }
}
