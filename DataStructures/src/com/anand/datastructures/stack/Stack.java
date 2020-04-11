package com.anand.datastructures.stack;

public interface Stack<T> {

	public int size();

	public boolean isEmpty();

	public T peek();

	public void push(T element);

	public T pop();
	
	public void clear();
	
}
