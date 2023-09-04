package io.mart.data.structures;

public class StackByLinkedList {
	
	private static class Node {
		int data;
		public Node next;
	}
	
	Node top;
	
	/**
	 * Initially: 1 <- 2 <- 3 (top)
	 * After push: 1 <- 2 <- 3 <- new_value (top)
	 */
	public Node push(int value) {
		Node temp = new Node();
		if (temp == null) {
			System.out.println("Heap is full. Inserting an element would lead to stack overflow");
		}
		
		temp.data = value;
		temp.next = top;
		top = temp;
		return temp;
	}
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public int peek() {
		if (isEmpty()) {
			System.out.println("Stack is empty");
			return -1;
		} else {
			return top.data;
		}
	}
	
	public int pop() {
		if (isEmpty()) {
			System.out.println("Stack is empty");
			return -1;
		} else {
			int temp = top.data;
			top = top.next;
			return temp;
		}
	}
	
	public void display() {
		if (isEmpty()) {
			System.out.println("Stack is empty");
			return;
		}
		
		Node current = top;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
	}
	
	public static void main(String[] args)
	{
		StackByLinkedList theStack = new StackByLinkedList();
		theStack.push(11);
		theStack.push(22);
		theStack.push(33);
		theStack.push(44);
		
		theStack.display();
		
		System.out.printf("\nTop element is %d\n", theStack.peek());
		
		theStack.pop();
		theStack.pop();
		
		theStack.display();
		
		System.out.printf("\nTop element is %d\n", theStack.peek());
	}
}
