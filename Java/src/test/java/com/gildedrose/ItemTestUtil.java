package com.gildedrose;

public class ItemTestUtil {
    public static Item updateSingleItem(String itemName, int sellInDate, int quality) {
        Item[] items = new Item[]{
            new Item(itemName, sellInDate, quality)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        return app.getItems().get(0);
    }
}
