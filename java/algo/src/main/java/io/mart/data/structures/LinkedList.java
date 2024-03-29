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
		System.out.println();
	}
	
	static class Node {
		int data;
		Node next; // by default it is null
		
		Node(int value) { data = value; }
	}
	
	/**
	 * <a href="https://www.geeksforgeeks.org/rotate-a-linked-list/">source</a>
	 * Input: linked list = 10->20->30->40->50->60, k = 4
	 * Output: 50->60->10->20->30->40.
	 * Explanation: k is smaller than the count of nodes in a linked list so (k+1 )th node i.e. 50 becomes the head node and 60’s next points to 10
	 */
	public static LinkedList rotateCounterClockwise(LinkedList list, int k) {
		if (list.head == null) {
			System.out.println("List is empty");
			return list;
		}
		if (k == 0) return list;
		
		// Let us understand the below code for example k =
		// 4 and list = 10->20->30->40->50->60.
		Node currentNode = list.head;
		
		int counter = 1;
		// current will either point to kth or NULL after
		// this loop. current will point to node 40 in the
		// above example
		while (currentNode != null && counter < k) {
			currentNode = currentNode.next;
			counter++;
		}
		
		// If current is NULL, k is greater than or equal to
		// count of nodes in linked list. Don't change the
		// list in this case
		if (currentNode == null) {
			System.out.println(k + " is bigger than list size");
			return list;
		}
		
		// current points to kth node. Store it in a
		// variable. kthNode points to node 40 in the above example
		Node kNode = currentNode;
		
		// current will point to last node after this loop
		// current will point to node 60 in the above
		// example
		while (currentNode.next != null) {
			currentNode = currentNode.next;
		}
		
		// Change next of last node to previous head
		// Next of 60 is now changed to node 10
		currentNode.next = list.head;
		
		// Change head to (k+1)th node
		// head is now changed to node 50
		list.head = kNode.next;
		
		// change next of kth node to null
		kNode.next = null;
		return list;
	}
	
	public static LinkedList reverseList(LinkedList list) {
		Node current = list.head;
		Node previous = null;
		
		while (current != null) {
			Node nextNode = current.next;
			
			current.next = previous;
			
			previous = current;
			current = nextNode;
		}
		list.head = previous;
		return list;
	}
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		for (int i = 1; i < 9; i++) {
			list = insertToTail(list, i);
		}
		printList(list);
		deleteNode(list, 5);
		printList(list);
		deleteNode(list, 1);
		printList(list);
		
		LinkedList list2 = new LinkedList();
		list2 = insertToTail(list2, 1);
		printList(list2);
		
		System.out.println("==== before rotation");
		LinkedList list3 = new LinkedList();
		for (int i = 1; i < 9; i++) {
			insertToTail(list3, i);
		}
		printList(list3);
		rotateCounterClockwise(list3, 4);
		printList(list3);
	}
}
