package com.anand.datastructures.linkedlist;

import java.util.Iterator;

@SuppressWarnings("hiding")
public class DoublyLinkedList<T> implements Iterable<T> {

	private Node<T> head;
	private Node<T> tail;
	private int size;

	private class Node<T> {
		private T data;
		private Node<T> next;
		private Node<T> previous;

		Node(T data, Node<T> previous, Node<T> next) {
			this.data = data;
			this.next = next;
			this.previous = previous;
		}

		@Override
		public String toString() {
			return data.toString();
		}

	}

	// removes all the elements from the doubly linked list
	public void clear() {
		Node<T> traversalNode = head;
		while (traversalNode != null) {
			traversalNode.data = null;
			Node<T> next = traversalNode.next;
			traversalNode.next = traversalNode.previous = null;
			traversalNode = next;
		}
		head = tail = traversalNode = null;
		size = 0;
	}

	// returns the size of the doubly linked list
	public int size() {
		return size;
	};

	// checks whether the doubly linked list is empty or not
	public boolean isEmpty() {
		return size() == 0;
	};

	// returns the index of the element from the doubly linked list
	public int indexOf(T element) {
		Node<T> traversalNode = null;
		int index = -1;

		if (element == null) {
			for (traversalNode = head; traversalNode != null; traversalNode = traversalNode.next, index++)
				if (traversalNode.data == element)
					return index;
		} else {
			for (traversalNode = head; traversalNode != null; traversalNode = traversalNode.next, index++)
				if (traversalNode.data.equals(element))
					return index;
		}

		return -1;
	};

	// checks whether the doubly linked list contains the element
	public boolean contains(T element) {
		return indexOf(element) != -1;
	};

	// adds an element to the doubly linked list
	public void add(T element) {
		addLast(element);
	};

	// adds an element to the begining of the doubly linked list
	public void addFirst(T element) {
		if (isEmpty())
			head = tail = new Node<T>(element, null, null);
		else {
			head.previous = new Node<T>(element, null, head);
			head = head.previous;
		}
		size++;
	};

	// adds an element to the end of the doubly linked list
	public void addLast(T element) {
		if (isEmpty())
			head = tail = new Node<T>(element, null, null);
		else {
			tail.next = new Node<T>(element, tail, null);
			tail = tail.next;
		}
		size++;
	};

	// removes the specified node from the doubly linked list
	private T remove(Node<T> node) {
		if (node.previous == null)
			return removeFirst();

		if (node.next == null)
			return removeLast();

		T returnData = node.data;
		node.next.previous = node.previous;
		node.previous.next = node.next;

		node.data = null;
		node = node.next = node.previous = null;
		size--;

		return returnData;
	};

	// removes the first element from the double linked list
	public T removeFirst() {
		if (isEmpty())
			throw new IllegalStateException("doubly linked list is empty");

		T returnData = head.data;
		head = head.next;
		size--;

		if (isEmpty())
			head = tail = null;
		else
			head.previous = null;

		return returnData;
	};

	// removes the last element from the double linked list
	public T removeLast() {
		if (isEmpty())
			throw new IllegalStateException("doubly linked list is empty");

		T returnData = tail.data;
		tail = tail.previous;
		size--;

		if (isEmpty())
			head = tail = null;
		else
			tail.next = null;

		return returnData;
	};

	// removes the node at the specified index from the doubly linked list
	public T removeAt(int index) {
		if (index < 0 || index >= size)
			throw new IllegalArgumentException("Index beyond the dimensions of the doubly linked list");

		int count = 0;
		Node<T> traversalNode = null;

		// search from front of the list
		if (index < size / 2)
			for (count = 0, traversalNode = head; count != index; count++)
				traversalNode = traversalNode.next;

		// search from the back of the list
		else
			for (count = size - 1, traversalNode = tail; count != index; count--)
				traversalNode = traversalNode.previous;

		return remove(traversalNode);
	};

	// removes the element from the doubly linked list if it exists
	public void remove(T data) {
		int index = indexOf(data);

		if (index != -1)
			removeAt(index);
	}

	// gets the value from the head of the doubly linked list
	public T peekFirst() {
		if (isEmpty())
			throw new IllegalStateException("doubly linked list is empty");

		return head.data;
	};

	// gets the value from the tail of the doubly linked list
	public T peekLast() {
		if (isEmpty())
			throw new IllegalStateException("doubly linked list is empty");

		return tail.data;
	};

	// gets the value at specified index from the double linked list
	public T get(int index) {
		if (isEmpty())
			throw new IllegalStateException("doubly linked list is empty");

		int count = 0;
		for (Node<T> traversalNode = head; traversalNode != null; traversalNode = traversalNode.next, count++)
			if (count == index)
				return traversalNode.data;

		return null;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			private Node<T> traversalNode = head;

			@Override
			public boolean hasNext() {
				return traversalNode != null;
			}

			@Override
			public T next() {
				T data = traversalNode.data;
				traversalNode = traversalNode.next;
				return data;
			}
		};
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder("Doubly Linked List {").append(size).append("} [");
		
		if(size > 0) {
			Node<T> traversalNode = head;
			while (traversalNode.next != null) {
				stringBuilder.append(traversalNode.data).append(", ");
				traversalNode = traversalNode.next;
			}
			stringBuilder.append(traversalNode.data).append("]");
		}else {
			stringBuilder.append("]");
		}
		return stringBuilder.toString();
	};

	
}
