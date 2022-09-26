package telran.util;

import java.util.HashMap;

/**
 * All methods of the class should have complexity O[1]
 * @author User
 *
 * @param <T>
 */
public class MyArray<T> {
	
	HashMap<Integer, T> hashMap = new HashMap<>();
	public int size;
	private T valueToSetAll;
	
	public MyArray(int size) {
		if(size < 0) {
			throw new IllegalArgumentException();
		}
		this.size = size;
	}
	/**
	 * sets all array's elements with a given value
	 * @param value
	 */
	public void setAll(T value) {
		valueToSetAll = value;
	}
	/**
	 * 
	 * @param index
	 * @return value at given index or null if index is wrong
	 */
	public T get(int index) {	
		if(valueToSetAll != null) {
			hashMap.put(index, valueToSetAll); 
		}
		return hashMap.get(index);
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
		valueToSetAll = null;
	}
}