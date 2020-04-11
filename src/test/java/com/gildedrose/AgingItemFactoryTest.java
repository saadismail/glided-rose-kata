package com.gildedrose;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AgingItemFactoryTest {

    @Test
    public void testCreateAgingItemDegradable() {
        Item item = new Item("+5 Dexterity Vest", 10, 20);
        AgingItem agingItem = AgingItemFactory.create(item);
        Assert.assertTrue(agingItem instanceof DegradableItem);
    }
    @Test
    public void testCreateAgingItemBackStagePass(){
        Item item =new Item("Aged Brie", 2, 0);
        AgingItem agingItem = AgingItemFactory.create(item);
        Assert.assertTrue(agingItem instanceof BackStagePassItem);
    }


    @Test
    public void testCreateAgingItemLegendary(){
        Item item =new Item("Sulfuras, Hand of Ragnaros", 0, 80);
        AgingItem agingItem = AgingItemFactory.create(item);
        Assert.assertTrue(agingItem instanceof LegendaryItem);
    }

}