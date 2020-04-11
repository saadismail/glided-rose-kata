package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                continue;
            }

            if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;
                    processQualityForBackstage(items[i]);
                }

                items[i].sellIn = items[i].sellIn - 1;

                if (items[i].sellIn < 0) {
                    items[i].quality = 0;
                }
                continue;
            }

            if (isNotAgedBrieAndNotBackstage(items[i])) {
                if (items[i].quality > 0) {
                    items[i].quality = items[i].quality - 1;
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                }
            }

            items[i].sellIn = items[i].sellIn - 1;

            processQualityForNegativeSellIn(items[i]);
        }
    }

    private void processQualityForBackstage(Item item) {
        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (item.sellIn < 11 && item.quality < 50) {
                item.quality = item.quality + 1;
            }

            if (item.sellIn < 6 && item.quality < 50) {
                item.quality = item.quality + 1;
            }
        }
    }

    private void processQualityForNegativeSellIn(Item item) {
        if (item.sellIn < 0) {

            if (!item.name.equals("Aged Brie")) {
                if (item.quality > 0) {
                    item.quality = item.quality - 1;
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
        }
    }

    private boolean isNotAgedBrieAndNotBackstage(Item item) {
        return !item.name.equals("Aged Brie");
    }
}