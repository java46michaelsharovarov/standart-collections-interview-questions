package telran.structure;

import java.util.*;

public class MultiCountersImpl implements MultiCounters {
	
	private HashMap<Object, Integer> items = new HashMap<>(); // key - item, value - counter
	private TreeMap<Integer, HashSet<Object>> counters = new TreeMap<>(); // key counter, value - set of items having the key - counter
	 
	@Override
	public Integer addItem(Object item) {
		Integer count = items.merge(item, 1, Integer::sum);
		if(count > 1) {
			removeFromSet(item, count - 1);			
		} 
		counters.computeIfAbsent(getValue(item), k -> new HashSet<Object>()).add(item);		
		return count;
	}

	@Override
	public Integer getValue(Object item) {
		return items.get(item);
	}

	@Override
	public boolean remove(Object item) {
		Integer value = items.remove(item);
		if(value == null) {
			return false;
		}
		removeFromSet(item, value);	
		return true;
	}

	@Override
	public Set<Object> getMaxItems() {
		if(items.isEmpty()) {
			throw new NoSuchElementException();
		}
		return counters.get(counters.lastKey());
	}

	private void removeFromSet(Object item, Integer value) {
		counters.computeIfPresent(value, (k, v) -> {
			v.remove(item);
			return v.isEmpty() ? null : v;
		});
	}

}