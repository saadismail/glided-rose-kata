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
    public void updateConjuredTest() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 3, 6) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, items[0].quality);
        assertEquals(2, items[0].sellIn);
    }

    @Test
    public void updateBackstageGreaterThan10DaysTest() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 15, 6) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(7, items[0].quality);
        assertEquals(14, items[0].sellIn);
    }

    @Test
    public void updateBackstageLessThan10DaysButGreaterThan5Test() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 8, 6) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, items[0].quality);
        assertEquals(7, items[0].sellIn);
    }

    @Test
    public void updateBackstageLessThan5DaysTest() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 3, 6) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, items[0].quality);
        assertEquals(2, items[0].sellIn);
    }

}
