package com.gildedrose;

public class BackStagePassItem extends Item implements AgingItem {
    public BackStagePassItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public BackStagePassItem(Item item) {
        super(item.name, item.sellIn, item.quality);
    }

    @Override
    public void age() {
        if (sellIn > 0) {
            if (sellIn <= 5) {
                quality = Math.min(50, quality + 3);
            } else if (sellIn <= 10) {
                quality = Math.min(50, quality + 2);
            } else {
                quality = Math.min(50, quality + 1);
            }

            sellIn--;
        } else {
            quality = 0;
        }
    }
}
