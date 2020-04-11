package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DegradableItemTest {
    @Test
    public void testDegradableItem(){
        int initialSellIn = 2, initialQuality = 2;
        DegradableItem item = new DegradableItem("foo", initialSellIn, initialQuality);
        item.age();
        assertEquals(initialSellIn - 1, item.sellIn);
        assertEquals(initialQuality - 1, item.quality);
    }

    @Test
    public void testDegradableItem_WhenZeroInitialSellIn() {
        int initialSellIn = 0, initialQuality = 2;
        DegradableItem item = new DegradableItem("foo", initialSellIn, initialQuality);
        item.age();
        assertEquals(initialSellIn, item.sellIn);
        assertEquals(initialQuality - 2, item.quality);
    }

    @Test
    public void testDegradableItem_WhenZeroInitialQuality() {
        int initialSellIn = 2, initialQuality = 0;
        DegradableItem item = new DegradableItem("foo", initialSellIn, initialQuality);
        item.age();
        assertEquals(initialSellIn - 1, item.sellIn);
        assertEquals(initialQuality, item.quality);
    }

    @Test
    public void testDegradableItem_WhenBothZeroSellInAndQuality() {
        int initialSellIn = 0, initialQuality = 0;
        DegradableItem item = new DegradableItem("foo", initialSellIn, initialQuality);
        item.age();
        assertEquals(initialSellIn, item.sellIn);
        assertEquals(initialQuality, item.quality);
    }
}
