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
            new Item("Backstage passes to a TAFKAL80ETC concert", 12, 30),
            new Item("Backstage passes to a TAFKAL80ETC concert", 11, 30),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 30),
            new Item("Backstage passes to a TAFKAL80ETC concert", 9, 30),
            new Item("Backstage passes to a TAFKAL80ETC concert", 8, 30),
            new Item("Backstage passes to a TAFKAL80ETC concert", 7, 30),
            new Item("Backstage passes to a TAFKAL80ETC concert", 6, 30),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 30),
            new Item("Backstage passes to a TAFKAL80ETC concert", 4, 30),
            new Item("Backstage passes to a TAFKAL80ETC concert", 3, 30),
            new Item("Backstage passes to a TAFKAL80ETC concert", 2, 30),
            new Item("Backstage passes to a TAFKAL80ETC concert", 1, 30),
            new Item("Backstage passes to a TAFKAL80ETC concert", 0, 30),
            new Item("Backstage passes to a TAFKAL80ETC concert", -1, 30),
            new Item("Backstage passes to a TAFKAL80ETC concert", -1, 0),


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
        {
            final Item item = app.items[12];
            assertEquals("Backstage passes to a TAFKAL80ETC concert", item.name);
            assertEquals(31, item.quality);
            assertEquals(11, item.sellIn);
        }
        {
            final Item item = app.items[13];
            assertEquals("Backstage passes to a TAFKAL80ETC concert", item.name);
            assertEquals(31, item.quality);
            assertEquals(10, item.sellIn);
        }
        {
            final Item item = app.items[14];
            assertEquals("Backstage passes to a TAFKAL80ETC concert", item.name);
            assertEquals(32, item.quality);
            assertEquals(9, item.sellIn);
        }
        {
            {
                final Item item = app.items[15];
                assertEquals("Backstage passes to a TAFKAL80ETC concert", item.name);
                assertEquals(32, item.quality);
                assertEquals(8, item.sellIn);
            }
            {
                final Item item = app.items[16];
                assertEquals("Backstage passes to a TAFKAL80ETC concert", item.name);
                assertEquals(32, item.quality);
                assertEquals(7, item.sellIn);
            }

            {
                final Item item = app.items[17];
                assertEquals("Backstage passes to a TAFKAL80ETC concert", item.name);
                assertEquals(32, item.quality);
                assertEquals(6, item.sellIn);
            }
            {
                final Item item = app.items[18];
                assertEquals("Backstage passes to a TAFKAL80ETC concert", item.name);
                assertEquals(32, item.quality);
                assertEquals(5, item.sellIn);
            }
            {
                final Item item = app.items[19];
                assertEquals("Backstage passes to a TAFKAL80ETC concert", item.name);
                assertEquals(33, item.quality);
                assertEquals(4, item.sellIn);
            }

            {
                final Item item = app.items[20];
                assertEquals("Backstage passes to a TAFKAL80ETC concert", item.name);
                assertEquals(33, item.quality);
                assertEquals(3, item.sellIn);
            }
            {
                final Item item = app.items[21];
                assertEquals("Backstage passes to a TAFKAL80ETC concert", item.name);
                assertEquals(33, item.quality);
                assertEquals(2, item.sellIn);
            }
            {
                final Item item = app.items[22];
                assertEquals("Backstage passes to a TAFKAL80ETC concert", item.name);
                assertEquals(33, item.quality);
                assertEquals(1, item.sellIn);
            }
            {
                final Item item = app.items[23];
                assertEquals("Backstage passes to a TAFKAL80ETC concert", item.name);
                assertEquals(33, item.quality);
                assertEquals(0, item.sellIn);
            }
            {
                final Item item = app.items[24];
                assertEquals("Backstage passes to a TAFKAL80ETC concert", item.name);
                assertEquals(0, item.quality);
                assertEquals(-1, item.sellIn);
            }

            {
                final Item item = app.items[25];
                assertEquals("Backstage passes to a TAFKAL80ETC concert", item.name);
                assertEquals(0, item.quality);
                assertEquals(-2, item.sellIn);
            }
            {
                final Item item = app.items[26];
                assertEquals("Backstage passes to a TAFKAL80ETC concert", item.name);
                assertEquals(0, item.quality);
                assertEquals(-2, item.sellIn);
            }
        }
    }

}
