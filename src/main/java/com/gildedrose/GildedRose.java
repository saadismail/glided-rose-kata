package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
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

    private boolean isEqual(Item item, String name) {
        return item.name.equals(name);
    }

    public void updateQuality() {

        for (int i = 0; i < items.length; i++) {
            if (isEqual(items[i], "Aged Brie")) {
                updateAgedbrieQuality(i);
            } else if (isEqual(items[i], "Backstage passes to a TAFKAL80ETC concert")) {
                updateBackstageQuality(i);
            } else if (isEqual(items[i], "Sulfuras, Hand of Ragnaros")) {
//                TODO: quality can not be other than 80, check and throw exception
            } else if (isEqual(items[i], "Conjured Mana Cake")) {
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
        if (items[i].quality < 1) items[i].quality = 0;
    }

    private void updateBackstageQuality(int i) {
        if (items[i].quality < 50) items[i].quality++;

        if (items[i].sellIn < 11 && items[i].quality < 50) items[i].quality++;
        if (items[i].sellIn < 6 && items[i].quality < 50) items[i].quality++;

        if (items[i].quality < 1) items[i].quality = 0;
    }

    private void updateAgedbrieQuality(int i) {
        if (items[i].quality < 50) items[i].quality++;
        if (items[i].quality < 1) items[i].quality = 0;
    }

    private void updateConjuredQuality(int i) {
        items[i].quality -= 2;
        if (items[i].quality < 1) items[i].quality = 0;
    }
}