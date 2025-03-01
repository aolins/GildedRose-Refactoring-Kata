package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] {
            new Item("foo", 0, 0),
            new Item("foo", 1, 2),
            new Item("past due date", -1, 2)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        {
            final int i = 0;
            assertEquals("foo", app.items[i].name);
            assertEquals(0, app.items[i].quality);
            assertEquals(-1, app.items[i].sellIn);
        }
        {
            final int i = 1;
            assertEquals("foo", app.items[i].name);
            assertEquals(1, app.items[i].quality);
            assertEquals(0, app.items[i].sellIn);
        }
        {
            final int i = 2;
            assertEquals("past due date", app.items[i].name);
            assertEquals(0, app.items[i].quality);
            assertEquals(-2, app.items[i].sellIn);
        }

    }

}
