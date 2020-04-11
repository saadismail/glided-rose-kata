package com.gildedrose;

public class LegendaryItem extends Item implements AgingItem {

    public LegendaryItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);

        if (sellIn < 0) throw new AssertionError();
        if (quality < 0) throw new AssertionError();
    }

    public LegendaryItem(Item item) {
        super(item.name, item.sellIn, item.quality);
    }

    @Override
    public void age() {
        // No Change
    }
}
