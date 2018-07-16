package io.mart;

public class Bad_autoboxing {

	private static long sum() {
		Long sum = 0L;  // here 2^31 instances are created. Should be "long sum = 0";

		for (long i = 0; i <= Integer.MAX_VALUE; i ++) {
			sum += i;
		}
		return sum;
	}
}
