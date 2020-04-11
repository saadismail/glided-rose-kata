package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GildedRoseTest {

    @Test
    public void foo() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("fixme", app.items[0].name);
    }

    @Test
    public void agedBrie() {
        Item item = new Item("Aged Brie", 2, 0);
        GildedRose gildedRose = new GildedRose(new Item[]{item});
        gildedRose.updateQuality();
        assertEquals(1, item.sellIn);
        assertEquals(1, item.quality);
    }

    @Test
    public void agedBrie_qualityCannotExceed50() {
        Item item = new Item("Aged Brie", 2, 50);
        GildedRose gildedRose = new GildedRose(new Item[]{item});
        gildedRose.updateQuality();
        assertEquals(1, item.sellIn);
        assertEquals(50, item.quality);
    }




}
