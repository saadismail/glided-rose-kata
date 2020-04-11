package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BackStagePassItemTest {

    @Test(expected = AssertionError.class)
    public void testBackStagePassItem_ConstructWithNegativeValues() {
        int initialSellIn = -2, initialQuality = -32;
        new BackStagePassItem("foo", initialSellIn, initialQuality);
    }

    @Test
    public void testBackStagePassItem() {
        int initialSellIn = 20, initialQuality = 10;
        BackStagePassItem item = new BackStagePassItem("foo", initialSellIn, initialQuality);
        item.age();
        assertEquals(initialSellIn - 1, item.sellIn);
        assertEquals(initialQuality + 1, item.quality);
    }

    @Test
    public void testBackStagePassItem_LessThanTenDays() {
        int initialSellIn = 7, initialQuality = 10;
        BackStagePassItem item = new BackStagePassItem("foo", initialSellIn, initialQuality);
        item.age();
        assertEquals(initialSellIn - 1, item.sellIn);
        assertEquals(initialQuality + 2, item.quality);
    }

    @Test
    public void testBackStagePassItem_LessThanFiveDays() {
        int initialSellIn = 4, initialQuality = 10;
        BackStagePassItem item = new BackStagePassItem("foo", initialSellIn, initialQuality);
        item.age();
        assertEquals(initialSellIn - 1, item.sellIn);
        assertEquals(initialQuality + 3, item.quality);
    }

    @Test
    public void testBackStagePassItem_ZeroSellIn() {
        int initialSellIn = 0, initialQuality = 10;
        BackStagePassItem item = new BackStagePassItem("foo", initialSellIn, initialQuality);
        item.age();
        assertEquals(initialSellIn, item.sellIn);
        assertEquals(0, item.quality);
    }

    @Test
    public void testBackStagePassItem_MaxQuality() {
        int initialSellIn = 4, initialQuality = 50;
        BackStagePassItem item = new BackStagePassItem("foo", initialSellIn, initialQuality);
        item.age();
        assertEquals(initialSellIn - 1, item.sellIn);
        assertEquals(50, item.quality);
    }
}
