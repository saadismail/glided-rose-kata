package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GildedRoseTest {

    @Test
    public void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("fixme", app.items[0].name);
    }

    @Test
    public void testDegradableItem(){
        int initialSellIn = 2, initialQuality = 2;
        DegradableItem item = new DegradableItem("foo", initialSellIn, initialQuality);
        item.age();
        assertEquals(item.sellIn, initialSellIn-1);
        assertEquals(item.quality, initialQuality-1);
    }

}
