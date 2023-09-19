package io.mart.arrays;

public class MergeArray {
	
	public static void mergeArray(int[] a, int[] b, int aLength, int bLength) throws Exception {
		if (aLength + bLength > a.length) {
			throw new Exception("result of merge will not fit into array a");
		}
		
		int aIndex = aLength - 1;
		int bIndex = bLength - 1;
		int mergeIndex = aLength + bLength - 1;
		
		while (aIndex >= 0 && bIndex >= 0) {
			if (a[aIndex] > b[bIndex]) {
				a[mergeIndex] = a[aIndex];
				aIndex--;
			} else {
				a[mergeIndex] = b[bIndex];
				bIndex--;
			}
			mergeIndex--;
		}
		
		while (bIndex >= 0) {
			a[mergeIndex] = b[bIndex];
			bIndex--;
			mergeIndex--;
		}
	}
	
}
