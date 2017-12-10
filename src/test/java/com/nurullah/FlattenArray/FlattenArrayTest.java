package com.nurullah.FlattenArray;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class FlattenArrayTest {

	@Test
	public void emptyArray() {
		// []
		FlattenArray arrayFlattener = new FlattenArray();
		ArrayList<Object> empty = new ArrayList<Object>();
		
		Assert.assertTrue(arrayFlattener.flattenArray(empty).isEmpty());
	}

	@Test
	public void emptyNestedArray() {
		// [[[]], []]
		FlattenArray arrayFlattener = new FlattenArray();
		ArrayList<Object> emptyList1 = new ArrayList<>();
		ArrayList<Object> emptyList2 = new ArrayList<>();
		ArrayList<Object> nestedList = new ArrayList<>();
		nestedList.add(emptyList1);
		ArrayList<Object> nestedEmptyList = new ArrayList<Object>();
		nestedEmptyList.add(nestedList);
		nestedEmptyList.add(emptyList2);
		
		Assert.assertTrue(arrayFlattener.flattenArray(nestedEmptyList).isEmpty());
	}
	
	@Test
	public void nestedArray() {
		// [[1, 2, [3]], 4]
		FlattenArray arrayFlattener = new FlattenArray();
		ArrayList<Object> listLevel2 = new ArrayList<>();
		listLevel2.add(3);
		ArrayList<Object> listLevel1 = new ArrayList<>();
		listLevel1.add(1);
		listLevel1.add(2);
		listLevel1.add(listLevel2);
		ArrayList<Object> rootList = new ArrayList<>();
		rootList.add(listLevel1);
		rootList.add(4);
		
		ArrayList<Integer> expected = new ArrayList<>();
		expected.add(1);
		expected.add(2);
		expected.add(3);
		expected.add(4);
		
		Assert.assertEquals(expected, arrayFlattener.flattenArray(rootList));
	}
	
	@Test
	public void alreadyFlattenedArray() {
		// [1, 2, 3, 4]
		FlattenArray arrayFlattener = new FlattenArray();
		
		ArrayList<Integer> expected = new ArrayList<>();
		expected.add(1);
		expected.add(2);
		expected.add(3);
		expected.add(4);
		
		Assert.assertEquals(expected, arrayFlattener.flattenArray(expected));
	}
}
