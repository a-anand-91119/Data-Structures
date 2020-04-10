package com.anand.datastructures;

import com.anand.datastructures.arrays.DynamicArray;
import com.anand.datastructures.linkedlist.DoublyLinkedList;
import com.anand.datastructures.linkedlist.SingleLinkedList;

public class DriverClass {
	
	public static void main(String[] args) {
		
		displayHeader("Dynamic Arrays");
		dynamicArrayCheck();
		displayFooter();
		
		displayHeader("Singly Linked List");
		singlyLinkedListCheck();
		displayFooter();
		
		displayHeader("Doubly Linked List");
		doublyLinkedListCheck();
		displayFooter();
		
	}
	
	private static void displayHeader(String heading) {
		System.out.println("*************************************************");
		System.out.println("***********\t  " + heading + "  \t*********");
		System.out.println("*************************************************");
	}
	
	private static void displayFooter() {
		System.out.println("--------------------------------------------------");
		System.out.println("");
		System.out.println("");
	}

	private static void doublyLinkedListCheck() {
		DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
		System.out.println("Size: " + doublyLinkedList.size());
		System.out.println("Contains: " + doublyLinkedList.contains(20));
		System.out.println("Index Of: " + doublyLinkedList.indexOf(20));
		try {
			System.out.println("Peek First: " + doublyLinkedList.peekFirst());
		}catch(Exception e) {System.out.println(e);}
		try {
			System.out.println("Peek Last: " + doublyLinkedList.peekLast());
		}catch(Exception e) {System.out.println(e);}
		try {
			System.out.println("Remove At: " + doublyLinkedList.removeAt(2));
		}catch(Exception e) {System.out.println(e);}
		
		
		doublyLinkedList.add(1);
		doublyLinkedList.addFirst(0);
		doublyLinkedList.addLast(2);
		
		System.out.println(doublyLinkedList);
		
		System.out.println("Size: " + doublyLinkedList.size());
		System.out.println("Contains: " + doublyLinkedList.contains(20));
		System.out.println("Index Of: " + doublyLinkedList.indexOf(20));
		try {
			System.out.println("Peek First: " + doublyLinkedList.peekFirst());
		}catch(Exception e) {System.out.println(e);}
		try {
			System.out.println("Peek Last: " + doublyLinkedList.peekLast());
		}catch(Exception e) {System.out.println(e);}
		try {
			System.out.println("Remove At (2): " + doublyLinkedList.removeAt(2));
		}catch(Exception e) {System.out.println(e);}
		
		System.out.println(doublyLinkedList);
		
		doublyLinkedList.remove(0);
		System.out.println(doublyLinkedList);
		doublyLinkedList.removeFirst();
		System.out.println(doublyLinkedList);
		
		doublyLinkedList.add(10);
		doublyLinkedList.add(20);
		doublyLinkedList.add(30);
		doublyLinkedList.add(30);
		System.out.println(doublyLinkedList);
		doublyLinkedList.remove(30);
		doublyLinkedList.remove(30);
		System.out.println(doublyLinkedList);
		try {
			doublyLinkedList.remove(30);
		}catch(Exception e) {System.out.println(e);}
		System.out.println("Contains: " + doublyLinkedList.contains(20));
	}
	
	private static void singlyLinkedListCheck() {
		SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<>();
		System.out.println("Size: " + singleLinkedList.size());
		System.out.println("Contains: " + singleLinkedList.contains(20));
		System.out.println("Index Of: " + singleLinkedList.indexOf(20));
		try {
			System.out.println("Peek First: " + singleLinkedList.peekFirst());
		}catch(Exception e) {System.out.println(e);}
		try {
			System.out.println("Peek Last: " + singleLinkedList.peekLast());
		}catch(Exception e) {System.out.println(e);}
		try {
			System.out.println("Remove At: " + singleLinkedList.removeAt(2));
		}catch(Exception e) {System.out.println(e);}
		
		
		singleLinkedList.add(1);
		singleLinkedList.addFirst(0);
		singleLinkedList.addLast(2);
		
		System.out.println(singleLinkedList);
		
		System.out.println("Size: " + singleLinkedList.size());
		System.out.println("Contains: " + singleLinkedList.contains(20));
		System.out.println("Index Of: " + singleLinkedList.indexOf(20));
		try {
			System.out.println("Peek First: " + singleLinkedList.peekFirst());
		}catch(Exception e) {System.out.println(e);}
		try {
			System.out.println("Peek Last: " + singleLinkedList.peekLast());
		}catch(Exception e) {System.out.println(e);}
		try {
			System.out.println("Remove At (2): " + singleLinkedList.removeAt(2));
		}catch(Exception e) {System.out.println(e);}
		
		System.out.println(singleLinkedList);
		
		singleLinkedList.remove(0);
		System.out.println(singleLinkedList);
		singleLinkedList.removeFirst();
		System.out.println(singleLinkedList);
		
		singleLinkedList.add(10);
		singleLinkedList.add(20);
		singleLinkedList.add(30);
		singleLinkedList.add(30);
		System.out.println(singleLinkedList);
		singleLinkedList.remove(30);
		singleLinkedList.remove(30);
		System.out.println(singleLinkedList);
		try {
			singleLinkedList.remove(30);
		}catch(Exception e) {System.out.println(e);}
		System.out.println("Contains: " + singleLinkedList.contains(20));
	}
	
	private static void dynamicArrayCheck() {
		DynamicArray<Integer> dynamicArray = new DynamicArray<>();
		dynamicArray.add(10);
		dynamicArray.add(20);
		dynamicArray.add(30);
		dynamicArray.add(40);
		dynamicArray.add(50);

		System.out.println(dynamicArray);
		System.out.println("Size: " + dynamicArray.size());

		dynamicArray.remove(30);
		System.out.println(dynamicArray);
		System.out.println("Size: " + dynamicArray.size());

		Integer removed = dynamicArray.removeAt(2);
		System.out.println(dynamicArray);
		System.out.println("Removed: " + removed);
		System.out.println("Size: " + dynamicArray.size());
		
		if(dynamicArray.contains(10)) {
			System.out.println("Index: " + dynamicArray.indexOf(10));
			System.out.println(dynamicArray.get(dynamicArray.indexOf(10)));
		}
	}
}
