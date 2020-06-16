package io.mart.data.structures;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MaxHeap {
	
	private int capacity;
	private int size = 0;
	
	int[] items;
	
	
	public MaxHeap(int capacity) {
		this.capacity = capacity;
		items = new int[this.capacity];
	}
	
	private int getLeftChildIndex(int parentIndex) {return 2 * parentIndex + 1;}
	private int getRightChildIndex(int parentIndex) {return 2 * parentIndex + 2;}
	private int getParentIndex(int childIndex) {return (childIndex-1) / 2;}
	
	private boolean hasLeftChild(int index) {return getLeftChildIndex(index) < size;}
	private boolean hasRightChild(int index) {return getRightChildIndex(index) < size;}
	private boolean hasParent(int index) {return getParentIndex(index) >= 0;}
	
	private int leftChild(int index) { return items[getLeftChildIndex(index)];}
	private int rightChild(int index) { return items[getRightChildIndex(index)];}
	private int parent(int index) { return items[getParentIndex(index)];}
	
	private void swap(int indexOne, int indexTwo) {
		int temp = items[indexOne];
		items[indexOne] = items[indexTwo];
		items[indexTwo] = temp;
	}
	
	private void ensureExtraCapacity() {
		if (size == capacity) {
			items = Arrays.copyOf(items, capacity * 2);
			capacity *= 2;
		}
	}
	
	public int peek() {
		if (size == 0) throw new IllegalStateException();
		return items[0];
	}
	
	//extract max element
	public int poll() {
		if (size == 0) throw new IllegalStateException();
		int item = items[0];
		items[0] = items[size-1];
		size--;
		heapifyDown();
		return item;
	}
	
	
	public void add(int item) {
		ensureExtraCapacity();
		items[size] = item;
		size++;
		heapifyUp();
	}
	
	
	private void heapifyUp() {
		int index = size - 1;
		while (hasParent(index) && parent(index) < items[index]) {
			swap(getParentIndex(index), index);
			index = getParentIndex(index);
		}
	}
	
	
	private void heapifyDown() {
		int index = 0;
		while (hasLeftChild(index)) { // if no left child => definitely no right child
			int biggerChildIndex = getLeftChildIndex(index); // assume left is smaller
			if (hasRightChild(index) && rightChild(index) > leftChild(index)) { // if right is bigger
				biggerChildIndex = getRightChildIndex(index);
			}
			
			if (items[index] > items[biggerChildIndex]) {
				break;
			} else {
				swap(index, biggerChildIndex);
			}
			index = biggerChildIndex;
		}
	}
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numCases = Integer.parseInt(scanner.nextLine());
		
		for (int i = 0; i < numCases; i++) {
			String[] firstLine = scanner.nextLine().split(" ");
			int arraySize = Integer.parseInt(firstLine[0]);
			int numOfElementsToReturn = Integer.parseInt(firstLine[1]);
			
			MaxHeap heap = new MaxHeap(arraySize);
			
			String[] array = scanner.nextLine().split(" ");
			Stream.of(array).map(Integer::parseInt).forEach(heap::add);
			
			IntStream.range(0, numOfElementsToReturn).forEach(value -> System.out.print(heap.poll() + " "));
			System.out.println();
		}
	}
}
