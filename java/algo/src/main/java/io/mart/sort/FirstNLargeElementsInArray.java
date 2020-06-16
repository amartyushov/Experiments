package io.mart.sort;

import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import io.mart.data.structures.MaxHeap;

public class FirstNLargeElementsInArray {
	
	public static void main(String[] args) {
		MaxHeap.main(args); // this is a correct solution
	}
	
	
	private static void nonPerformanSolution2() {
		Scanner scanner = new Scanner(System.in);
		int numCases = Integer.parseInt(scanner.nextLine());
		
		for (int i = 0; i < numCases; i++) {
			String[] firstLine = scanner.nextLine().split(" ");
			int arraySize = Integer.parseInt(firstLine[0]);
			int numOfElementsToReturn = Integer.parseInt(firstLine[1]);
			
			String[] array = scanner.nextLine().split(" ");
			Integer[] arrayAsInt = Stream.of(array).map(Integer::parseInt).toArray(Integer[]::new);
			
			for (int j = 0; j <= numOfElementsToReturn; j++) {
				
				for (int k = j+1; k < arraySize; k++) {
					if (arrayAsInt[j] < arrayAsInt[k]) {
						int temp = arrayAsInt[j];
						arrayAsInt[j] = arrayAsInt[k];
						arrayAsInt[k] = temp;
					}
				}
			}
			
			IntStream.range(0, numOfElementsToReturn).map(m -> arrayAsInt[m]).forEach(val -> System.out.print(val+" "));
			System.out.println();
		}
	}
	
	
	private static void nonPerformantSolution() {
		Scanner scanner = new Scanner(System.in);
		int numCases = Integer.parseInt(scanner.nextLine());
		
		for (int i = 0; i < numCases; i++) {
			String[] firstLine = scanner.nextLine().split(" ");
			int arraySize = Integer.parseInt(firstLine[0]);
			int numOfElementsToReturn = Integer.parseInt(firstLine[1]);
			
			String[] array = scanner.nextLine().split(" ");
			Integer[] arrayAsInt = Stream.of(array).map(Integer::parseInt).toArray(Integer[]::new);
			
			for (int j = 0; j < arraySize; j++) {
				for (int k = j+1; k < arraySize; k++) {
					if (arrayAsInt[j] > arrayAsInt[k]) {
						int temp = arrayAsInt[j];
						arrayAsInt[j] = arrayAsInt[k];
						arrayAsInt[k] = temp;
					}
				}
			}
			
			int length = arrayAsInt.length;
			IntStream.rangeClosed(1, numOfElementsToReturn).map(m -> arrayAsInt[length-m]).forEach(val -> System.out.print(val+" "));
			System.out.println();
		}
	}
	
}
