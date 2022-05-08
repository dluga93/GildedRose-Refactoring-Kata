package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BackstagePassesTest {

    private static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";

    @Test
    void testBackstagePassesEarlyIncreaseInQuality() {
        final int initialSellIn = 20;
        final int initialQuality = 10;

        Item updated = ItemTestUtil.updateSingleItem(BACKSTAGE_PASS, initialSellIn, initialQuality);

        final int expectedSellIn = initialSellIn - 1;
        final int currentQuality = updated.quality;

        assertEquals(expectedSellIn, updated.sellIn);
        assertTrue(currentQuality > initialQuality);
    }

    @Test
    void testBackstagePassesIncreaseInQuality10DaysLeft() {
        final int initialSellIn = 10;
        final int initialQuality = 10;

        Item updated = ItemTestUtil.updateSingleItem(BACKSTAGE_PASS, initialSellIn, initialQuality);

        final int expectedSellIn = initialSellIn - 1;
        final int expectedQuality = initialQuality + 2;

        assertEquals(expectedSellIn, updated.sellIn);
        assertEquals(expectedQuality, updated.quality);
    }

    @Test
    void testBackstagePassesIncreaseInQuality5DaysLeft() {
        final int initialSellIn = 5;
        final int initialQuality = 10;

        Item updated = ItemTestUtil.updateSingleItem(BACKSTAGE_PASS, initialSellIn, initialQuality);

        final int expectedSellIn = initialSellIn - 1;
        final int expectedQuality = initialQuality + 3;

        assertEquals(expectedSellIn, updated.sellIn);
        assertEquals(expectedQuality, updated.quality);
    }

    @Test
    void testBackstagePassesQualityZeroAfterConcert() {
        final int initialSellIn = 0;
        final int initialQuality = 10;

        Item updated = ItemTestUtil.updateSingleItem(BACKSTAGE_PASS, initialSellIn, initialQuality);

        final int expectedSellIn = initialSellIn - 1;

        assertEquals(expectedSellIn, updated.sellIn);
        assertEquals(0, updated.quality);
    }
}
