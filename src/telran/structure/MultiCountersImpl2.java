package telran.structure;

import java.util.*;
import java.util.Map.Entry;

public class MultiCountersImpl2 implements MultiCounters {
	
	private HashMap<Object, Integer> items = new HashMap<>(); // key - item, value - counter
	private TreeMap<Integer, HashSet<Object>> counters; // key counter, value - set of items having the key - counter
	 
	@Override
	public Integer addItem(Object item) {				
		return items.merge(item, 1, Integer::sum);
	}

	@Override
	public Integer getValue(Object item) {
		return items.get(item);
	}

	@Override
	public boolean remove(Object item) {
		return items.remove(item) != null ? true : false;
	}

	@Override
	public Set<Object> getMaxItems() {
		counters = new TreeMap<>();
		items.entrySet()
		.stream()
		.forEach(k -> counters.computeIfAbsent(getValue(k.getKey()), e -> new HashSet<Object>()).add(k.getKey()));
		Entry<Integer, HashSet<Object>> maxCounter = counters.lastEntry();
		return maxCounter != null ? maxCounter.getValue() : Collections.emptySet();
	}

}