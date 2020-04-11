package com.gildedrose;

import org.junit.Assert;
import org.junit.Test;

public class LegendaryItemTest {

    @Test(expected = AssertionError.class)
    public void testLegendaryItem_ConstructWithNegativeValues() {
        int initialSellIn = -2, initialQuality = -32;
        new LegendaryItem("foo", initialSellIn, initialQuality);
    }

    @Test
    public void testLegendaryItem() {
        int initialSellIn = 2, initialQuality = 2;
        LegendaryItem item = new LegendaryItem("foo", initialSellIn, initialQuality);
        item.age();
        Assert.assertEquals(initialSellIn, item.sellIn);
        Assert.assertEquals(initialQuality, item.quality);
    }

    @Test
    public void testLegendaryItem_WhenBothZeroSellInAndQuality(){
        int initialSellIn = 0, initialQuality = 0;
        LegendaryItem item = new LegendaryItem("foo", initialSellIn, initialQuality);
        item.age();
        Assert.assertEquals(initialSellIn, item.sellIn);
        Assert.assertEquals(initialQuality, item.quality);
    }
}
