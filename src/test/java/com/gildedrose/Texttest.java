package com.gildedrose;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class Texttest {
    @Test
    public  void textTestforAllItems() throws IOException {

        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 47),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6) };

        GildedRose app = new GildedRose(items);

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("Day0.out").getFile());
        String expected = FileUtils.readFileToString(file, "UTF-8");

        int days = 10;


        for (int i = 0; i < days; i++) {
            StringBuilder actual = new StringBuilder();
            actual.append("-------- day " + i + " --------\n");
            actual.append("name, sellIn, quality\n");
            for (Item item : items) {
                actual.append(item + "\n");
            }
            file = new File("Day" + i + ".out");
            FileUtils.writeStringToFile(file, actual.toString());
            //assertEquals(expected, actual.toString());
            app.updateQuality();
        }
    }
}
