package ghostgametest.items;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ghostgame.items.Item;

public class ItemTest {

	@Test
	public void testItemStringInt() {
		Item testItem = new Item("TestItem", 0);
		assertEquals(testItem.getName(), "TestItem");
	}

	@Test
	public void testItemStringIntIntInt() {
		Item testItem = new Item("TestItem", 0, 1, 1);
		assertEquals(testItem.getName(), "TestItem");
	}

	@Test
	public void testCreateNewInt() {
		Item testItem = new Item("TestItem", 0);
		testItem = testItem.createNew(2);
		assertEquals(testItem.getCount(), 2);
	}

	@Test
	public void testCreateNewIntInt() {
		Item testItem = new Item("TestItem", 0);
		testItem = testItem.createNew(2, 3);
		assertEquals(testItem.getX(), 2);
		assertEquals(testItem.getY(), 3);
	}

	@Test
	public void testSetPosition() {
		Item testItem = new Item("TestItem", 0);
		testItem.setPosition(4, 3);
		assertEquals(testItem.getX(), 4);
		assertEquals(testItem.getY(), 3);
	}

	@Test
	public void testSetPickedUp() {
		Item testItem = new Item("TestItem", 0);
		testItem.setPickedUp(true);
		assertTrue(testItem.isPickedUp());
	}

	@Test
	public void testGetName() {
		Item testItem = new Item("TestItem", 0);
		assertEquals(testItem.getName(), "TestItem");
	}

	@Test
	public void testSetName() {
		Item testItem = new Item("TestItem", 0);
		testItem.setName("testSetName");
		assertEquals(testItem.getName(), "testSetName");
	}

	@Test
	public void testGetX() {
		Item testItem = new Item("TestItem", 0);
		testItem.setX(2);
		assertEquals(2, testItem.getX());
	}

	@Test
	public void testSetX() {
		Item testItem = new Item("TestItem", 0);
		testItem.setX(2);
		assertEquals(2, testItem.getX());
	}

	@Test
	public void testGetY() {
		Item testItem = new Item("TestItem", 0);
		testItem.setY(6);
		assertEquals(6, testItem.getY());
	}

	@Test
	public void testSetY() {
		Item testItem = new Item("TestItem", 0);
		testItem.setY(6);
		assertEquals(6, testItem.getY());
	}

	@Test
	public void testGetCount() {
		Item itemTest = new Item("TestItem", 0);
		itemTest.setCount(10);
		assertEquals(10, itemTest.getCount());
	}

	@Test
	public void testSetCount() {
		Item itemTest = new Item("TestItem", 0);
		itemTest.setCount(10);
		assertEquals(10, itemTest.getCount());
	}

	@Test
	public void testGetId() {
		Item testItem = new Item("TestItem", 0);
		assertEquals(0, testItem.getId());
	}

	@Test
	public void testIsPickedUp() {
		Item testItem = new Item("TestItem", 0);
		testItem.setPickedUp(true);
		assertTrue(testItem.isPickedUp());
	}

}
