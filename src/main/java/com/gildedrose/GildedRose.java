package com.gildedrose;

import java.util.Arrays;
import java.util.stream.Collectors;

class GildedRose {
    AgingItem[] agingItems;
    Item[] items;

    public GildedRose(Item[] items) {
        this.agingItems = new AgingItem[items.length];
        this.items= items;
        Arrays.stream(items).map(AgingItemFactory::create).collect(Collectors.toList()).toArray(this.agingItems);
    }

    public void updateQuality() {
        Arrays.stream(agingItems).forEach(AgingItem::age);
        Arrays.asList(agingItems).toArray(this.items);
    }
}