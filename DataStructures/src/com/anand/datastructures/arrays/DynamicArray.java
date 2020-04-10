package com.anand.datastructures.arrays;

import java.util.Iterator;

@SuppressWarnings("unchecked")
public class DynamicArray<T> implements Iterable<T> {

	private T[] array;
	private int arrayLength = 0;
	private int arrayCapacity = 0;

	public DynamicArray() {
		this(16);
	}

	public DynamicArray(int capacityOfArray) {
		if (capacityOfArray <= 0)
			throw new IllegalArgumentException("Capacity Of DynamicArray Cannot Be Less Than Zero");

		this.arrayCapacity = capacityOfArray;
		array = (T[]) new Object[capacityOfArray];
	}

	public int size() {
		return arrayLength;
	}

	public boolean isEmpty() {
		return array.length == 0;
	}

	public T get(int index) {
		if (index >= arrayCapacity)
			throw new IndexOutOfBoundsException();
		return array[index];
	}

	public void set(int index, T element) {
		if (index >= arrayCapacity)
			throw new IndexOutOfBoundsException();
		array[index] = element;
	}

	public void clear() {
		for (int i = 0; i < arrayCapacity; i++) {
			array[i] = null;
		}
		arrayLength = 0;
	}

	public void add(T element) {
		if (arrayLength + 1 >= arrayCapacity) {

			arrayCapacity = arrayCapacity == 0 ? 1 : arrayCapacity * 2;

			T[] newArray = (T[]) new Object[arrayCapacity];

			for (int i = 0; i < arrayLength; i++)
				newArray[i] = array[i];

			array = newArray;
		}

		array[arrayLength++] = element;
	}

	public T removeAt(int index) {
		if (index < 0 || index >= arrayLength)
			throw new IndexOutOfBoundsException();

		T data = array[index];

		T[] newArray = (T[]) new Object[arrayCapacity];
		for (int i = 0, j = 0; i < arrayLength; i++, j++) {
			if (j == index)
				i--;
			else
				newArray[i] = array[j];
		}
		array = newArray;
		arrayLength--;
		return data;
	}

	public boolean remove(Object object) {
		int index = indexOf(object);
		if (index == -1)
			return false;
		removeAt(index);
		return true;
	}

	public int indexOf(Object object) {
		for (int i = 0; i < arrayLength; i++)
			if (array[i].equals(object))
				return i;
		return -1;
	}

	public boolean contains(Object object) {
		return indexOf(object) != -1;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			int index = 0;

			@Override
			public boolean hasNext() {
				return index < arrayLength;
			}

			@Override
			public T next() {
				return array[index++];
			}
		};
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder("DynamicArray {").append(arrayLength).append("} [");

		for (int i = 0; i < arrayLength - 1; i++)
			stringBuilder.append(array[i]).append(", ");

		if (arrayLength > 0)
			stringBuilder.append(array[arrayLength - 1]);

		stringBuilder.append("]");

		return stringBuilder.toString();
	}

}
