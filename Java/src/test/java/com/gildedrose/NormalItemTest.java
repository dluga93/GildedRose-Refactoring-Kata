package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NormalItemTest {

    private static final int NORMAL_ITEM_DAILY_DEGRADATION = 1;

    private static final String NORMAL_ITEM = "foo";

    @Test
    void testNormalItemQualityBeforeSellInDate() {
        final int initialSellIn = 10;
        final int initialQuality = 10;

        Item updated = ItemTestUtil.updateSingleItem(NORMAL_ITEM, initialSellIn, initialQuality);

        final int expectedSellIn = initialSellIn - 1;
        final int expectedQuality = initialQuality - NORMAL_ITEM_DAILY_DEGRADATION;

        assertEquals(expectedSellIn, updated.sellIn);
        assertEquals(expectedQuality, updated.quality);
    }

    @Test
    void testNormalItemQualityAfterSellInDate() {
        final int initialSellIn = 0;
        final int initialQuality = 10;

        Item updated = ItemTestUtil.updateSingleItem(NORMAL_ITEM, initialSellIn, initialQuality);

        final int expectedSellIn = initialSellIn - 1;
        final int expectedQuality = initialQuality - 2 * NORMAL_ITEM_DAILY_DEGRADATION;

        assertEquals(expectedSellIn, updated.sellIn);
        assertEquals(expectedQuality, updated.quality);
    }

    @Test
    void testQualityIsNeverNegative() {
        final int initialSellIn = 10;
        final int initialQuality = 0;

        Item updated = ItemTestUtil.updateSingleItem(NORMAL_ITEM, initialSellIn, initialQuality);

        final int expectedSellIn = initialSellIn - 1;
        final int expectedQuality = 0;

        assertEquals(expectedSellIn, updated.sellIn);
        assertEquals(expectedQuality, updated.quality);
    }
}
