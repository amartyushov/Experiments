package io.mart;

public class IsBraceSequencedCorrectRecursion {
	
	private static int n = 2;
	static char[] s = new char[2*n];
	
	public static void main(String[] args) {
		rec(0,0);
	}
	
	private static void rec(int idx, int bal) {
		if (idx == 2*n) {
			if (bal == 0) {
				out();
			}
			return;
		}
		
		s[idx] = '(';
		rec(idx + 1, bal + 1);
		
		if (bal == 0) {
			return;
		}
		
		s[idx] = ')';
		rec(idx + 1, bal - 1);
	}
	
	
	private static void out() {
		new String(s).chars().mapToObj(i->(char)i).forEach(System.out::print);
		System.out.println("");
	}
}
