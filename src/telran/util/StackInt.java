package telran.util;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class StackInt {
	List <Integer> stack = new ArrayList<Integer>();
    int maxNumber;
	
	public int pop() {
		if(stack.isEmpty()) {
			throw new NoSuchElementException();
		}		
		return stack.remove(stack.size() - 1);
	}
	
	public void push(int number) {
		if(stack.isEmpty()) {
			maxNumber = number;
		}
		if(number > maxNumber) {
			maxNumber = number;
		}
		stack.add(number);
	}
	
	public boolean isEmpty() {
		return stack.isEmpty();
	}
	
	public int getMaxNumber() {
		if(stack.isEmpty()) {
			throw new NoSuchElementException();
		}
		return maxNumber;
	}
}