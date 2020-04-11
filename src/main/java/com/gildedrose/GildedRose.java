package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    private boolean isEqual(Item item, String name) {
        return item.name.equals(name);
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
            if (isAgedBrie(items[i])) {
                updateAgedbrieQuality(i);
            } else if (isBackstage(items[i])) {
                updateBackstageQuality(i);
            } else if (isSulfuras(items[i])) {
//                TODO: quality can not be other than 80, check and throw exception
            } else if (isConjured(items[i])) {
                updateConjuredQuality(i);
            } else {
                updateGeneralQuality(i);
            }

            if (!isEqual(items[i], "Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn--;
            }
        }
    }

    private void updateGeneralQuality(int i) {
        items[i].quality--;

        if (items[i].sellIn < 1) items[i].quality--;
        resetQualityToZeroIfNegative(i);
    }

    private void resetQualityToZeroIfNegative(int i) {
        if (items[i].quality < 1) items[i].quality = 0;
    }

    private void increaseBackStageQuality(int i) {
        if (items[i].quality < 50) items[i].quality++;
    }

    private void updateBackstageQuality(int i) {
        increaseBackStageQuality(i);

        if (items[i].sellIn < 11) increaseBackStageQuality(i);
        if (items[i].sellIn < 6) increaseBackStageQuality(i);

        resetQualityToZeroIfNegative(i);
    }

    private void updateAgedbrieQuality(int i) {
        if (items[i].quality < 50) items[i].quality++;
        resetQualityToZeroIfNegative(i);
    }

    private void updateConjuredQuality(int i) {
        items[i].quality -= 2;
        resetQualityToZeroIfNegative(i);
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