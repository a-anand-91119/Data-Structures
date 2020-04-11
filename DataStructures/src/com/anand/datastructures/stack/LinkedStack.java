package com.anand.datastructures.stack;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedStack<T> implements Stack<T>, Iterable<T> {

	LinkedList<T> linkedStack = null;

	public LinkedStack() {
		linkedStack = new LinkedList<>();
	}

	public LinkedStack(T firstElement) {
		this();
		push(firstElement);
	}

	@Override
	public void clear() {
		while(!linkedStack.isEmpty())
			pop();
	}
	
	@Override
	public int size() {
		return linkedStack.size();
	}

	@Override
	public boolean isEmpty() {
		return linkedStack.isEmpty();
	}

	@Override
	public T peek() {
		return linkedStack.getLast();
	}

	@Override
	public void push(T element) {
		linkedStack.add(element);
	}

	@Override
	public T pop() {
		return linkedStack.removeLast();
	}

	@Override
	public Iterator<T> iterator() {
		return linkedStack.iterator();
	}

	@Override
	public String toString() {
		return linkedStack.toString();
	}

}
