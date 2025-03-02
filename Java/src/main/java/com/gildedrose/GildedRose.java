package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }


    private static void updateConjured(Item item){
        if (item.name.startsWith("Conjured")){
            if (item.sellIn > 0){
                item.quality = item.quality - 2;
            } else {
                item.quality = item.quality - 4;
            }
            item.sellIn = item.sellIn - 1;
            updateGlobal(item);
        }
    }

    private static void updateBackstagePasses(Item item){
        if (item.name.startsWith("Backstage passes")) {
            if (item.sellIn > 10) {
                item.quality = item.quality + 1;
            } else if (item.sellIn <= 10 && item.sellIn > 5){
                item.quality = item.quality + 2;
            } else if (item.sellIn <= 5 && item.sellIn > 0){
                item.quality = item.quality + 3;
            } else {// if (item.sellIn <= 0){
                item.quality = 0;
            }
            item.sellIn = item.sellIn - 1;
            updateGlobal(item);
        }
    }

    private static void updateAgedBrie(Item item){
        if (item.name.startsWith("Aged Brie")) {
            if (item.sellIn > 0) {
                item.quality = item.quality + 1;
            } else {
                item.quality = item.quality + 2;
            }
            item.sellIn = item.sellIn - 1;
            updateGlobal(item);
        }
    }

    private static void updateCommonItem(Item item){
        if (item.sellIn > 0){
            item.quality = item.quality - 1;
        } else {
            item.quality = item.quality - 2;
        }
        item.sellIn = item.sellIn - 1;
        updateGlobal(item);
    }

    private static void updateGlobal(Item item){
        if (item.quality < 0){
            item.quality = 0;
        }else if (item.quality > 50){
            item.quality = 50;
        }
    }
    private static void updateSulfuras(Item item){}

    public void updateQuality() {
        for (Item item: items) {
            if (item.name.startsWith("Conjured")){
                updateConjured(item);
           } else if (item.name.startsWith("Aged Brie")) {
                updateAgedBrie(item);
            } else if (item.name.startsWith("Sulfuras")) {
                updateSulfuras(item);
            } else if (item.name.startsWith("Backstage passes")) {
                updateBackstagePasses(item);
            } else{
                updateCommonItem(item);
            }
        }
    }
}
