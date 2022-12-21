package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

	@Test
	void foo() {
		Item[] items = new Item[] { new Item("foo", 0, 2), new Item("Sulfuras, Hand of Ragnaros",0,80)
				,new Item("Aged Brie",0,8),new Item("Backstage passes to a TAFKAL80ETC concert",0,8)
				,new Item("Backstage passes to a TAFKAL80ETC concert",10,8),
				new Item("Backstage passes to a TAFKAL80ETC concert",2,8),
				new Item("Conjured",2,1),new Item("Conjured",0,3)};
		GildedRose app = new GildedRose(items);
		app.updateQuality();

		assertAll("quality", 
				()-> assertEquals(0, app.items[0].quality),
				()-> assertEquals(80, app.items[1].quality),
				()-> assertEquals(10, app.items[2].quality),
				()-> assertEquals(0, app.items[3].quality),
				()-> assertEquals(10, app.items[4].quality),
				()-> assertEquals(11, app.items[5].quality),
				()-> assertEquals(0, app.items[6].quality),
				()-> assertEquals(0, app.items[7].quality)
				);

	}

}
