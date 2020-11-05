package io.mart.contest.n1433;


class Solution {
	
	public static void main(String[] args) {
		ListNode last = new ListNode(1);
		ListNode prelastlast = new ListNode(2, last);
		ListNode first = new ListNode(0, prelastlast);
		
		Solution solution = new Solution();
		solution.insertionSortList(first);
	}
	
	
	public ListNode insertionSortList(ListNode head) {
		ListNode sorted = null;
		ListNode current = head;
		
		while (current != null) {
			
			ListNode currentForRestore = current.next;
			sorted = findPlace(sorted, current);
			current = currentForRestore;
		}
		return sorted;
	}
	
	
	private ListNode findPlace(ListNode sorted, ListNode toInsert) {
		// just insert in the beginning of list
		if (sorted == null || sorted.val >= toInsert.val) {
			toInsert.next = sorted;
			sorted = toInsert;
			return sorted;
			
		} else {
			// find a proper place in sorted list
			ListNode currInSorted = sorted;
			while (currInSorted.next != null && currInSorted.next.val <= toInsert.val) {
				currInSorted = currInSorted.next;
			}
			toInsert.next = currInSorted.next;
			currInSorted.next = toInsert;
		}
		return sorted;
	}
	
	
	public static class ListNode {
		
		int val;
		ListNode next;
		
		
		ListNode() {
		}
		
		
		ListNode(int val) {
			this.val = val;
		}
		
		
		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
}