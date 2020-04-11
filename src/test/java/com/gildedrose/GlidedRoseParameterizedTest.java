package com.gildedrose;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized.Parameter;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class GlidedRoseParameterizedTest {

    @Parameter(0)
    public Item item;

    @Parameter(1)
    public int expectedQuality;

    @Parameter(2)
    public int expectedSellIn;

    @Parameters(name = "update item {0}, expected quality: {1}. expected sellIn: {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new Item("Conjured Mana Cake", 3, 6), 4, 2},
                {new Item("Backstage passes to a TAFKAL80ETC concert", 15, 6), 7, 14},
                {new Item("Backstage passes to a TAFKAL80ETC concert", 8, 6), 8, 7},
                {new Item("Backstage passes to a TAFKAL80ETC concert", 3, 6), 9, 2},
                {new Item("Aged Brie", 3, 6), 7, 2}
        });
    }

    @Test
    public void glidedRoseTest() {
        Item[] items = new Item[]{item};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(expectedQuality, items[0].quality);
        assertEquals(expectedSellIn, items[0].sellIn);
    }
}
