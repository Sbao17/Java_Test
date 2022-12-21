package com.gildedrose;

class GildedRose {
	Item[] items;
	final static int MIN_QUALITY =0;
	final static int MAX_QUALITY =50;

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {

		for(int i=0;i<items.length;i++){
			if(items[i].name.contains("Aged Brie") || items[i].name.contains("Backstage passes")){
				updateQualityUp(items[i]);
				checkQualityMax(items[i]);
				items[i].sellIn--;
			}else {
				if(!items[i].name.contains("Sulfuras")) {
					updateQualityDown(items[i]);
					checkQualityMin(items[i]);
					items[i].sellIn--;
				}
			}
		}	
	}

	private void updateQualityDown(Item item) {

		if(item.name.contains("Conjured")) {
			item.quality = (item.sellIn>0) ? item.quality-2 : item.quality-4;
		}else {
			item.quality = (item.sellIn>0) ? item.quality-1 : item.quality-2;
		}

	}

	private void updateQualityUp(Item item) {

		if(item.name.contains("Aged Brie")) {
			item.quality = (item.sellIn<1) ? item.quality+2 : item.quality+1;
		}
		if(item.name.contains("Backstage passes")) {
			item.quality++;
			if(item.sellIn<11) {
				item.quality = (item.sellIn<6) ? item.quality+2 : item.quality+1;
			}
			if(item.sellIn<=0) {
				item.quality=0;
			}
		}
	}

	private void checkQualityMin(Item item) {
		if(item.quality<0) {
			item.quality=MIN_QUALITY;
		}	
	}
	private void checkQualityMax(Item item) {
		if(item.quality>50) {
			item.quality=MAX_QUALITY;
		}
	}
}