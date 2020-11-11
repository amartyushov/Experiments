package io.mart.problems;

import java.util.LinkedList;
import java.util.Stack;

public class p445 {
	
	public static void main(String[] args) {
		/*(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7
*/
		LinkedList<Integer> list1 = new LinkedList<>();
		list1.add(3);
		list1.add(4);
		list1.add(2);
		list1.add(7);
		ListNode first = new ListNode(list1.removeFirst());
		ListNode second = null;
		for (Integer l : list1) {
			second = new ListNode(l, first);
			first = second;
		}
		LinkedList<Integer> list2 = new LinkedList<>();
		list2.add(4);
		list2.add(6);
		list2.add(5);
		ListNode first2 = new ListNode(list2.removeFirst());
		ListNode second2 = null;
		for (Integer l : list2) {
			second2 = new ListNode(l, first2);
			first2 = second2;
		}
		p445 s = new p445();
		s.addTwoNumbers(second, second2);
	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		Stack<Integer> stack1 = toStack(l1);
		Stack<Integer> stack2 = toStack(l2);
		LinkedList<Integer> result = new LinkedList<>();
		
		boolean perenos = false;
		while (!stack1.empty() || !stack2.empty()) {
			int v1 = getV(stack1);
			int v2 = getV(stack2);
			int calc = v1 + v2;
			if (perenos) calc++;
			if (calc / 10 == 1) {
				perenos = true;
			} else {
				perenos = false;
			}
			result.add(calc % 10);
		}
		if (perenos) result.add(1);
		
		ListNode firstNode = new ListNode(result.removeFirst());
		ListNode second = null;
		for (Integer l : result) {
			second = new ListNode(l, firstNode);
			firstNode = second;
		}
		return second == null ? firstNode : second;
	}
	
	private int getV(Stack<Integer> stack) {
		if (stack.empty()) {
			return 0;
		}
		return stack.pop();
	}
	
	private Stack<Integer> toStack(ListNode l1) {
		Stack<Integer> stack = new Stack<Integer>();
		ListNode current = l1;
		while (current != null) {
			stack.push(current.val);
			current = current.next;
		}
		return stack;
	}
	
	public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
	
}
