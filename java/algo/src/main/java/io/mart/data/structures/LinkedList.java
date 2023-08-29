package io.mart.data.structures;

public class LinkedList {
	Node head;

	public static LinkedList insertToTail(LinkedList list, int data) {
		Node newNode = new Node(data);
		
		if (list.head == null) { // if list is empty
			list.head = newNode;
		} else {
			// traverse till the last node and insert new node there
			Node currentNode = list.head;
			while (currentNode.next != null) {
				currentNode = currentNode.next;
			}
			currentNode.next = newNode;
		}
		return list;
	}
	
	public static LinkedList deleteNode(LinkedList list, int key) {
		Node currentNode = list.head;
		Node prevNode = null;
		
		// CASE 1:
		// If head node itself holds the key to be deleted
		if (currentNode != null && currentNode.data == key) {
			list.head = currentNode.next;
			System.out.println(key + " found and deleted");
			return list;
		}
		
		// CASE 2:
		// If the key is somewhere other than at head
		
		// Search for the key to be deleted,
		// keep track of the previous node
		// as it is needed to change currNode.next
		while (currentNode != null && currentNode.data != key) {
			prevNode = currentNode;
			currentNode = currentNode.next;
		}
		
		// If the key was present, it should be at currentNode
		// Therefore the currentNode shall not be null
		if (currentNode != null) {
			// Since the key is at currentNode
			// Unlink currentNode from linked list
			prevNode.next = currentNode.next;
			
			// Display the message
			System.out.println(key + " found and deleted");
		}
		
		// CASE 3: The key is not present
		
		// If key was not present in linked list
		// currentNode should be null
		if (currentNode == null) {
			// Display the message
			System.out.println(key + " not found");
		}
		return list;
	}
	
	public static LinkedList deleteAtPosition(LinkedList list, int index) {
		Node currentNode = list.head;
		Node prevNode = null;
		
		// CASE 1:
		// If index is 0, then head node itself is to be deleted
		if (index == 0 && currentNode != null) {
			list.head = currentNode.next;
			System.out.println(index + " position element deleted");
			return list;
		}
		
		// If the index is greater than 0 but less than the size of LinkedList
		int counter = 0;
		
		// Count for the index to be deleted,
		// keep track of the previous node as it is needed to change currNode.next
		while (currentNode != null) {
			if (counter == index) {
				// Since the currentNode is the required
				// position Unlink currNode from linked list
				prevNode.next = currentNode.next;
				
				System.out.println(index + " position element deleted");
				break;
			} else {
				// If current position is not the index continue to next node
				prevNode = currentNode;
				currentNode = currentNode.next;
				counter++;
			}
		}
		
		// CASE 3: The index is greater than the size of the LinkedList
		// In this case, the currNode should be null
		if (currentNode == null) {
			System.out.println(index + " position element not found");
		}
		return list;
	}
	
	public static void printList(LinkedList list) {
		Node currentNode = list.head;
		System.out.print(" List: ");
		
		while (currentNode != null) {
			System.out.print(currentNode.data + " ");
			currentNode = currentNode.next;
		}
	}
	
	static class Node {
		int data;
		Node next; // by default it is null
		
		Node(int value) { data = value; }
	}
	
	// Driver code
	public static void main(String[] args)
	{
		LinkedList list = new LinkedList();
		for (int i = 1; i < 9; i++) {
			list = insertToTail(list, i);
		}
		
		deleteAtPosition(list, 7);
		printList(list);
	}
}
