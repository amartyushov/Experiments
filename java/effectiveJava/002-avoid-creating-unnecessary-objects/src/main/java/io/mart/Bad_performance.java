package io.mart;

import java.util.regex.Pattern;

public class Bad_performance {

	/**
	 * String.matches is not suitable for repeated use in performance-critical situations.
	 *
	 * @param s
	 * @return
	 */
	static boolean isRomanNumeral(String s) {
		return s.matches("HUGE_REGEX_HERE");
	}
}

class Better_performance {
	private static final Pattern ROMAN = Pattern.compile("HUGE_REGEX_HERE"); // it is expensive step. But we do it only once

	static boolean isRomanNumeral(String s) {
		return ROMAN.matcher(s).matches(); // also readability increases
	}
}


