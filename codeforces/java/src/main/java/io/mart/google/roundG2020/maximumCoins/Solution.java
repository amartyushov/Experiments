package io.mart.google.roundG2020.maximumCoins;

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int tcNum = Integer.parseInt(scanner.nextLine());
		
		for (int i = 1; i <= tcNum; i++) {
			int matrixSize = Integer.parseInt(scanner.nextLine());
			int[][] c = new int[matrixSize][matrixSize];
			for (int j = 0; j < matrixSize; j++) {
				c[j] = readLine(scanner);
			}
			
			int sumArrSize = 2 * matrixSize - 1;
			int[] sums = new int[sumArrSize];
			for (int row = 0; row < c.length; row++) {
				for (int col = 0; col < c[row].length; col++) {
					if (col - row >= 0) {
						sums[col - row] += c[row][col];
					} else {
						sums[col - row + sumArrSize] += c[row][col];
					}
				}
			}
			int max = Integer.MIN_VALUE;
			for (int s : sums) {
				if (s > max) {
					max = s;
				}
			}
			System.out.println(String.format("Case #%d: %d", i, max));
		}
	}
	
	
//	1. я заполняю формуляр. i do know this person.
//			1.1. adress is on the formular
//	2. получаю письмо от о2 to go ti post station with docs
//	3. => через день в онлайн кабинете  я буду как владелец
	
	
	private static int[] readLine(Scanner scanner) {
		String[] values = scanner.nextLine().split(" ");
		int[] arr = new int[values.length];
		for (int i = 0; i < values.length; i++) {
			arr[i] = Integer.parseInt(values[i]);
		}
		return arr;
	}
}
