package com.anand.datastructures.stack;

import java.util.EmptyStackException;
import java.util.Iterator;

import com.anand.datastructures.arrays.DynamicArray;

public class ArrayStack<T> implements Stack<T>, Iterable<T> {

	DynamicArray<T> arrayStack = new DynamicArray<T>();

	public ArrayStack(int initialStackSize) {
		arrayStack = new DynamicArray<T>(initialStackSize);
	}

	public ArrayStack() {
		this(16);
	}

	@Override
	public void clear() {
		while(!isEmpty())
			pop();
	}
	
	@Override
	public int size() {
		return arrayStack.size();
	}

	@Override
	public boolean isEmpty() {
		return arrayStack.isEmpty();
	}

	@Override
	public T peek() {
		if (arrayStack.size() <= 0)
			throw new EmptyStackException();

		return arrayStack.get(arrayStack.size() - 1);
	}

	@Override
	public void push(T element) {
		arrayStack.add(element);
	}

	@Override
	public T pop() {
		if (arrayStack.size() <= 0)
			throw new EmptyStackException();

		return arrayStack.removeAt(arrayStack.size() - 1);
	}

	@Override
	public Iterator<T> iterator() {
		return arrayStack.iterator();
	}

	@Override
	public String toString() {
		return arrayStack.toString();
	}

}
