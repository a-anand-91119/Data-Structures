package com.anand.datastructures.linkedlist;

import java.util.Iterator;

@SuppressWarnings("hiding")
public class SingleLinkedList<T> implements Iterable<T> {

	private Node<T> head;
	private Node<T> tail;
	private int size;

	private class Node<T> {
		T data;
		Node<T> next;

		public Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}

		@Override
		public String toString() {
			return data.toString();
		}

	}

	// clears the contents of the linked list
	public void clear() {
		Node<T> traversal = head;

		while (traversal != null) {
			Node<T> nextNode = traversal.next;
			traversal.next = null;
			traversal.data = null;
			traversal = nextNode;
		}

		head = tail = null;
		size = 0;
	}

	// gets the size of the linked list
	public int size() {
		return size;
	}

	// checks whether the linked list is empty or not
	public boolean isEmpty() {
		return size() == 0;
	}

	// adds an element to the linked list
	public void add(T element) {
		addLast(element);
	}

	// adds an element to the begining of the linked list
	public void addFirst(T element) {
		if (isEmpty())
			head = tail = new Node<T>(element, null);
		else {
			Node<T> newNode = new Node<T>(element, head);
			head = newNode;
		}
		size++;
	}

	// adds an element to the end of the linked list
	public void addLast(T element) {
		if (isEmpty())
			head = tail = new Node<T>(element, null);
		else {
			Node<T> newNode = new Node<T>(element, null);
			tail.next = newNode;
			tail = tail.next;
		}
		size++;
	}

	// returns the value of the first node
	public T peekFirst() {
		if (isEmpty())
			throw new RuntimeException("The Singly Linked List Is Empty");
		else
			return head.data;
	}

	// returns the value of the last node
	public T peekLast() {
		if (isEmpty())
			throw new RuntimeException("The Singly Linked List Is Empty");
		else
			return tail.data;
	}

	// removes an element from the begining of the linked list
	public T removeFirst() {
		if (isEmpty())
			throw new RuntimeException("The Singly Linked List Is Empty");

		T returnData = head.data;
		Node<T> nextNode = head.next;
		head = null;
		head = nextNode;
		size--;

		if (isEmpty())
			tail = null;

		return returnData;
	}

	// removes element at position index from the singly linked list
	public T removeAt(int index) {
		if (index < 0 || index >= size)
			throw new IllegalArgumentException("Index Is Not Within The Dimensions Of The Singly Linked List");

		Node<T> traversalNode = head;
		Node<T> traversalNodePrevious = head;

		for (int i = 0; i < index; i++) {
			traversalNodePrevious = traversalNode;
			traversalNode = traversalNode.next;
		}

		T returnData = traversalNode.data;
		traversalNodePrevious.next = traversalNode.next;
		traversalNode.next = null;

		if (isEmpty())
			head = tail = null;

		size--;
		return returnData;
	}

	// removes the first occurance of the element from the singly linked list
	public void remove(T element) {
		int index = indexOf(element);
		if(index == 0)
			removeFirst();
		else 
			removeAt(index);
			
	}

	// returns the index of element from the single linked list
	public int indexOf(T element) {
		int index = 0;
		for (Node<T> traversalNode = head; traversalNode != null; traversalNode = traversalNode.next, index++) {
			if (traversalNode.data.equals(element))
				return index;
		}
		return -1;
	}

	// returns whether the single list containst the specified element
	public boolean contains(T element) {
		return indexOf(element) != -1;
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
		StringBuilder stringBuilder = new StringBuilder("Singly Linked List {").append(size).append("} [");
		
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
	}

}
