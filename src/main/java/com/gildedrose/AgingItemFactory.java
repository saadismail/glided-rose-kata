package com.gildedrose;

public class AgingItemFactory {

    public static AgingItem create(Item item){
        String name= item.name;
        AgingItem agingItem;

         if(name.equals("Aged Brie")){
            agingItem = new BackStagePassItem(item);
        }
        else if(name.equals("Sulfuras, Hand of Ragnaros")){
            agingItem = new LegendaryItem(item);
        }
        else {
             agingItem = new DegradableItem(item);
         }
        return agingItem;
    }
}
