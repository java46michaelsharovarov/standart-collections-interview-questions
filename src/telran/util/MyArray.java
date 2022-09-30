package telran.util;

import java.util.HashMap;

/**
 * All methods of the class should have complexity O[1]
 * @author User
 *
 * @param <T>
 */
public class MyArray<T> {
	
	HashMap<Integer, T> hashMap;
	private int size;
	private T valueToSetAll;
	
	public MyArray(int size) {
		if(size < 0) {
			throw new IllegalArgumentException();
		}
		this.size = size;
		hashMap = new HashMap<>();
	}
	/**
	 * sets all array's elements with a given value
	 * @param value
	 */
	public void setAll(T value) {
		valueToSetAll = value;
		hashMap = new HashMap<>();
	}
	/**
	 * 
	 * @param index
	 * @return value at given index or null if index is wrong
	 */
	public T get(int index) {
		if (index < 0 || index >= size) {
			return null;
		}
		return hashMap.getOrDefault(index, valueToSetAll);
	}
	/**
	 * sets a given value at a given index
	 * throws IndexOutOfBoundsException in the case of wrong index
	 * @param index
	 * @param value
	 */
	public void set(int index, T value) {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		hashMap.put(index, value);
	}
	public int getSize() {
		return size;
	}
}