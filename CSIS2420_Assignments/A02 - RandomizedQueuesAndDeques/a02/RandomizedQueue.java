/*
 * Created by: Kamdon Bird
 * Created date: Nov 27, 2022
 * Course class: CSIS 2420
 * Assignment: A02 - RandomizedQueuesAndDeques
 */
package a02;

import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {

	@Override
	public Iterator<Item> iterator() {
		return new IItemIterator();
	}
	
}
