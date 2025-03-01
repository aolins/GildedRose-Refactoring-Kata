package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] {
            new Item("foo", 0, 0),
            new Item("foo", 1, 2),
            new Item("past due date", -1, 2),
            new Item("sell now", 0, 2),
            new Item("sell tomorrow", 1, 2),
            new Item("Aged Brie", 1, 2),
            new Item("Aged Brie", 10, 50),
            new Item("Sulfuras, Hand of Ragnaros", 10, 50),
            new Item("Sulfuras, Hand of Ragnaros", -1, 50),
            new Item("Sulfuras, Hand of Ragnaros", 0, 50),
            new Item("Aged Brie", -1, 29),
            new Item("Aged Brie", -9, 49),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        {
            final Item item = app.items[0];

            assertEquals("foo", item.name);
            assertEquals(0, item.quality);
            assertEquals(-1, item.sellIn);
        }
        {
            final Item item = app.items[1];
            assertEquals("foo", item.name);
            assertEquals(1, item.quality);
            assertEquals(0, item.sellIn);
        }
        {
            final Item item = app.items[2];
            assertEquals("past due date", item.name);
            assertEquals(0, item.quality);
            assertEquals(-2, item.sellIn);
        }
        {
            final Item item = app.items[3];
            assertEquals("sell now", item.name);
            assertEquals(0, item.quality);
            assertEquals(-1, item.sellIn);
        }
        {
            final Item item = app.items[4];
            assertEquals("sell tomorrow", item.name);
            assertEquals(1, item.quality);
            assertEquals(0, item.sellIn);
        }
        {
            final Item item = app.items[5];
            assertEquals("Aged Brie", item.name);
            assertEquals(3, item.quality);
            assertEquals(0, item.sellIn);
        }
        {
            final Item item = app.items[6];
            assertEquals("Aged Brie", item.name);
            assertEquals(50, item.quality);
            assertEquals(9, item.sellIn);
        }
        {
            final Item item = app.items[7];
            assertEquals("Sulfuras, Hand of Ragnaros", item.name);
            assertEquals(50, item.quality);
            assertEquals(10, item.sellIn);
        }

        {
            final Item item = app.items[8];
            assertEquals("Sulfuras, Hand of Ragnaros", item.name);
            assertEquals(50, item.quality);
            assertEquals(-1, item.sellIn);
        }
        {
            final Item item = app.items[9];
            assertEquals("Sulfuras, Hand of Ragnaros", item.name);
            assertEquals(50, item.quality);
            assertEquals(0, item.sellIn);
        }

        /**
         * Here I will ask business to resolve this:
         *  * it is not stated that Aged Brie increases its quality twice as fast after sell in date
         *  * on the other hand "Once the sell by date has passed, Quality degrades twice as fast"
         *
         *  It should be made clear
         *  * whether Aged Brie should comply to the second rule (increase up to 50 before due date; then degrade by two every day)
         *  * or it should have its own rule - quality increases by one every day
         */
        {
            final Item item = app.items[10];
            assertEquals("Aged Brie", item.name);
            assertEquals(31, item.quality);
            assertEquals(-2, item.sellIn);
        }
        {
            final Item item = app.items[11];
            assertEquals("Aged Brie", item.name);
            assertEquals(50, item.quality);
            assertEquals(-10, item.sellIn);
        }


    }

}
