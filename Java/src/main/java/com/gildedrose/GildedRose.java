package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            final Item item = items [i];
            final String itemName = item.name;
            final int initialQuality = item.quality;
            final int initialSellIn = item.sellIn;

            if (!itemName.equals("Aged Brie")
                    && !itemName.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (initialQuality > 0) {
                    if (!itemName.equals("Sulfuras, Hand of Ragnaros")) {
                        item.quality = initialQuality - 1;
                    }
                }
            } else {
                if (initialQuality < 50) {
                    item.quality = initialQuality + 1;

                    if (itemName.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (initialSellIn < 11) {
                            if (initialQuality < 50) {
                                item.quality = initialQuality + 1;
                            }
                        }

                        if (initialSellIn < 6) {
                            if (initialQuality < 50) {
                                item.quality = initialQuality + 1;
                            }
                        }
                    }
                }
            }

            if (!itemName.equals("Sulfuras, Hand of Ragnaros")) {
                item.sellIn = initialSellIn - 1;
            }

            if (initialSellIn < 0) {
                if (!itemName.equals("Aged Brie")) {
                    if (!itemName.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (initialQuality > 0) {
                            if (!itemName.equals("Sulfuras, Hand of Ragnaros")) {
                                item.quality = initialQuality - 1;
                            }
                        }
                    } else {
                        item.quality = 0;
                    }
                } else {
                    if (initialQuality < 50) {
                        item.quality = initialQuality + 1;
                    }
                }
            }
        }
    }
}
