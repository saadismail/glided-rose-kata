package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    private boolean isAgedBrie(Item item) {
        return item.name.equals("Aged Brie");
    }

    private boolean isBackstage(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isSulfuras(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean isConjured(Item item) {
        return item.name.equals("Conjured Mana Cake");
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];

            updateItemQuality(item);
            updateItemSellIn(item);
        }
    }

    private void updateItemQuality(Item item) {
        if (isAgedBrie(item)) {
            updateAgedbrieQuality(item);
        } else if (isBackstage(item)) {
            updateBackstageQuality(item);
        } else if (isSulfuras(item)) {
//                TODO: quality can not be other than 80, check and throw exception
        } else if (isConjured(item)) {
            updateConjuredQuality(item);
        } else {
            updateGeneralQuality(item);
        }
    }

    private void updateItemSellIn(Item item) {
        if (!isSulfuras(item)) {
            item.sellIn--;
        }
    }

    private void updateGeneralQuality(Item item) {
        item.quality--;

        if (item.sellIn < 1) item.quality--;
        resetQualityToZeroIfNegative(item);
    }

    private void resetQualityToZeroIfNegative(Item item) {
        if (item.quality < 1) item.quality = 0;
    }

    private void updateBackstageQuality(Item item) {
        incrementQualityIfLessThan50(item);

        if (item.sellIn < 11) incrementQualityIfLessThan50(item);
        if (item.sellIn < 6) incrementQualityIfLessThan50(item);

        resetQualityToZeroIfNegative(item);
    }

    private void incrementQualityIfLessThan50(Item item) {
        if (item.quality < 50) item.quality++;
    }

    private void updateAgedbrieQuality(Item item) {
        incrementQualityIfLessThan50(item);
        resetQualityToZeroIfNegative(item);
    }

    private void updateConjuredQuality(Item item) {
        item.quality = item.quality - 2;
        resetQualityToZeroIfNegative(item);
    }

    public void printOutput(int days) {
        System.out.println("OMGHAI!");

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (Item item : this.items) {
                System.out.println(item);
            }
            System.out.println();
            this.updateQuality();
        }
    }
}