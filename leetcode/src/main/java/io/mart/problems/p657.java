package io.mart.problems;

//https://leetcode.com/problems/robot-return-to-origin/
public class p657 {
	
	public boolean judgeCircle(String moves) {
		int LR = 0;
		int UD = 0;
		
		for (int i = 0; i < moves.length(); i++) {
			char currentMove = moves.charAt(i);
			if (currentMove == 'U') {
				UD++;
			} else if (currentMove == 'D') {
				UD--;
			} else if (currentMove == 'R') {
				LR++;
			} else if (currentMove == 'L') {
				LR--;
			}
		}
		return LR == 0 && UD == 0;
	}
}
