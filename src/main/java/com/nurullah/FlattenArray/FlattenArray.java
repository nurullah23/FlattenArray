package com.nurullah.FlattenArray;

import java.util.ArrayList;

public class FlattenArray {

	public ArrayList<Integer> flattenArray(ArrayList array) {
		if (array == null)
			return null;
		return (ArrayList<Integer>) array.stream().reduce(new ArrayList<Integer>(), (acc, elem) -> {
			ArrayList<Integer> accumulator = (ArrayList<Integer>) acc;
			if (elem instanceof Integer) {
				accumulator.add((Integer) elem);
			}
			else {
				accumulator.addAll(flattenArray((ArrayList<Object>) elem));
			}
			return accumulator;
		});
	}
}
