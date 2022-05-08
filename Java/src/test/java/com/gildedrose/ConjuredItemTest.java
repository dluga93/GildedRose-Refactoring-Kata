package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConjuredItemTest {
    private static final int NORMAL_ITEM_DAILY_DEGRADATION = 1;
    private static final int CONJURED_ITEM_DAILY_DEGRADATION = 2 * NORMAL_ITEM_DAILY_DEGRADATION;

    private static final String CONJURED_ITEM = "Conjured";

    @Test
    void testConjuredItemQualityBeforeSellInDate() {
        final int initialSellIn = 10;
        final int initialQuality = 10;

        Item updated = ItemTestUtil.updateSingleItem(CONJURED_ITEM, initialSellIn, initialQuality);

        final int expectedSellIn = initialSellIn - 1;
        final int expectedQuality = initialQuality - CONJURED_ITEM_DAILY_DEGRADATION;

        assertEquals(expectedSellIn, updated.sellIn);
        assertEquals(expectedQuality, updated.quality);
    }

    @Test
    void testNormalItemQualityAfterSellInDate() {
        final int initialSellIn = 0;
        final int initialQuality = 10;

        Item updated = ItemTestUtil.updateSingleItem(CONJURED_ITEM, initialSellIn, initialQuality);

        final int expectedSellIn = initialSellIn - 1;
        final int expectedQuality = initialQuality - 2 * CONJURED_ITEM_DAILY_DEGRADATION;

        assertEquals(expectedSellIn, updated.sellIn);
        assertEquals(expectedQuality, updated.quality);
    }
}
