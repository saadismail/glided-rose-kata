package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GildedRoseTest {

    @Test
    public void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    public void testDegradableItem(){
        int initialSellIn = 2, initialQuality = 2;
        DegradableItem item = new DegradableItem("foo", initialSellIn, initialQuality);
        item.age();
        assertEquals(item.sellIn, initialSellIn-1);
        assertEquals(item.quality, initialQuality-1);
    }

    @Test
    public void testDegradableItem_WhenZeroInitialSellIn() {
        int initialSellIn = 0, initialQuality = 2;
        DegradableItem item = new DegradableItem("foo", initialSellIn, initialQuality);
        item.age();
        assertEquals(item.sellIn, 0);
        assertEquals(item.quality, 0);
    }

    @Test
    public void testDegradableItem_WhenZeroInitialQuality() {
        int initialSellIn = 2, initialQuality = 0;
        DegradableItem item = new DegradableItem("foo", initialSellIn, initialQuality);
        item.age();
        assertEquals(item.sellIn, 1);
        assertEquals(item.quality, 0);
    }

    @Test
    public void testDegradableItem_WhenBothZeroSellInAndQuality() {
        int initialSellIn = 0, initialQuality = 0;
        DegradableItem item = new DegradableItem("foo", initialSellIn, initialQuality);
        item.age();
        assertEquals(item.sellIn, 0);
        assertEquals(item.quality, 0);
    }
}
