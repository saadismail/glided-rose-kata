package com.gildedrose;

public class DegradableItem extends Item implements AgingItem {

    public DegradableItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);

        if (sellIn < 0) throw new AssertionError();
        if (quality < 0) throw new AssertionError();
    }

    public DegradableItem(Item item) {
        super(item.name, item.sellIn, item.quality);
    }

    @Override
    public void age() {
        if (sellIn > 0) {
            sellIn--;
            quality = Math.max(0, quality - 1);
        }
        else {
            quality = Math.max(0, quality - 2);
        }
    }
}
