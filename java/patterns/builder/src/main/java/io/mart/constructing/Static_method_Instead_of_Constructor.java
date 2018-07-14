package io.mart.constructing;

import java.util.Collections;
import java.util.HashMap;

public class Static_method_Instead_of_Constructor {

	public static void main(String[] args) {
		Collections.synchronizedMap(new HashMap<>());
	}
}
